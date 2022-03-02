package top.banner.cms.log.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import top.banner.cms.log.core.ILogProcessService;
import top.banner.cms.log.core.SysLogProperties;

@Configuration
@EnableConfigurationProperties(SysLogProperties.class)
@ConditionalOnClass(ILogProcessService.class)
public class SysLogConfiguration {


}
