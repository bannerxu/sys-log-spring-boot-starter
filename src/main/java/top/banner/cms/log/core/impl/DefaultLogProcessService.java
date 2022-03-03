package top.banner.cms.log.core.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.banner.cms.log.core.ILogProcessService;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class DefaultLogProcessService implements ILogProcessService {

    /**
     * 请求参数脱敏规则
     * key ==> 正则表达式
     * value ==> 替换的值
     */
    private final Map<String, String> desensitizationRules = new HashMap<String, String>() {{
        put("password[^,]*", "password\\\":\\\"******\\\"");
    }};

    @Override
    public Map<String, String> getDesensitizationRules() {
        return desensitizationRules;
    }

    @Override
    public void process(String module, String desc, String className, String methodName, String params, String ip, long time, boolean isError) {
        log.info("DefaultLogProcessService ==> {} {} {} {} {} {} {} {}", module, desc, className, methodName, params, ip, time, isError);
    }
}
