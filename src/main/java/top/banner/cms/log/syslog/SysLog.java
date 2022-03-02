package top.banner.cms.log.syslog;

import java.lang.annotation.*;

/**
 * 日志注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    /**
     * 操作模块
     **/
    String module() default "";

    /**
     * 操作内容
     **/
    String desc() default "";

}
