package top.banner.cms.log.syslog;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import top.banner.cms.log.core.ILogProcessService;
import top.banner.cms.log.core.SysLogProperties;
import top.banner.cms.log.utils.IPHelper;

import javax.annotation.Resource;

/**
 * @author xgl
 */
@Aspect
@Component
public class SysLogAspect {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Resource
    private ILogProcessService logProcessService;

    @Resource
    private SysLogProperties sysLogProperties;


    @Around("@annotation(log)")
    public Object around(ProceedingJoinPoint joinPoint, SysLog log) throws Throwable {

        Object result;
        //模块名称
        String module = log.module();
        //操作内容
        String desc = log.desc();

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName().replace("com.ican.controller.", "");
        String methodName = joinPoint.getSignature().getName();

        //请求的参数
        Object[] args = joinPoint.getArgs();

        String params = null;

        try {
            params = objectMapper.writeValueAsString(args).replaceAll("password[^,]*", "password\":\"******\"");
            if (params.length() > 2000) {
                params = params.substring(0, 2000) + "...";
            }
        } catch (JsonProcessingException ignored) {
        }
        final String ip = IPHelper.getIpAddr();
        long time = 0;
        boolean isError = false;
        try {
            //执行时长(毫秒)
            long beginTime = System.currentTimeMillis();
            //执行方法
            result = joinPoint.proceed();

            //执行时长(毫秒)
            time = System.currentTimeMillis() - beginTime;
            //systemLog.setActionTime(time);
            //systemLog.setIsError(false);

        } catch (Throwable t) {
            isError = true;
            throw t;
        } finally {
            logProcessService.process(module, desc, className, methodName, params, ip, time, isError);
        }

        return result;
    }

}
