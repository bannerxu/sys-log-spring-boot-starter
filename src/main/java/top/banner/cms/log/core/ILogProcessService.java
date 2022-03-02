package top.banner.cms.log.core;

public interface ILogProcessService {


    void process(String module, String desc, String className, String methodName, String params, String ip, long time, boolean isError);
}
