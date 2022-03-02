package top.banner.cms.log.core;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "spring.sys-log")
public class SysLogProperties {

    /**
     * 忽略的包名
     * joinPoint.getTarget().getClass().getName()
     * 获取的方法名包含了包名，过长了。可以通过这个地方忽略部分
     */
    private String ignorePackageName;


    /**
     * 请求参数脱敏规则
     * key ==> 正则表达式
     * value ==> 替换的值
     */
    private Map<String, String> desensitizationRules;


    public String getIgnorePackageName() {
        return ignorePackageName;
    }

    public void setIgnorePackageName(String ignorePackageName) {
        this.ignorePackageName = ignorePackageName;
    }

    public Map<String, String> getDesensitizationRules() {
        return desensitizationRules;
    }

    public void setDesensitizationRules(Map<String, String> desensitizationRules) {
        this.desensitizationRules = desensitizationRules;
    }
}
