package top.banner.cms.log.core;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.sys-log")
public class SysLogProperties {

    /**
     * 获取到的类名 是否包含包名
     * joinPoint.getTarget().getClass().getName()
     * 获取的方法名包含了包名，过长了。可以通过这个地方忽略部分
     */
    private Boolean ignorePackage = true;


    public Boolean getIgnorePackage() {
        return ignorePackage;
    }

    public void setIgnorePackage(Boolean ignorePackage) {
        this.ignorePackage = ignorePackage;
    }


}
