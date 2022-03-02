package top.banner.cms.log.core.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.banner.cms.log.core.ILogProcessService;

@Slf4j
@Service
public class DefaultLogProcessService implements ILogProcessService {


    @Override
    public void process(String module, String desc, String className, String methodName, String params, String ip, long time, boolean isError) {
        log.info("{} {} {} {} {} {} {} {}", module, desc, className, methodName, params, ip, time, isError);
    }
}
