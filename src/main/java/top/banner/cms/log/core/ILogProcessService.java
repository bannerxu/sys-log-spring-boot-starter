package top.banner.cms.log.core;

import java.util.Map;

public interface ILogProcessService {


    /**
     * 请求参数脱敏规则
     * key ==> 正则表达式
     * value ==> 替换的值
     */
    Map<String, String> getDesensitizationRules();


    void process(String module, String desc, String className, String methodName, String params, String ip, long time, boolean isError);
}
