package com.alin.springboot.config;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Controller 的所有方法在执行前后都会进入functionAccessCheck方法
 *
 * @author lijiazhi
 */
@Aspect
@Configuration
public class AOPConfig {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(AOPConfig.class);

    @Around("@within(org.springframework.stereotype.Controller) ")
    public Object functionAccessCheck(final ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        LOG.info("####传入参数：" + Arrays.asList(args));

        Object o = pjp.proceed();

        LOG.info("####返回参数 :" + JSON.toJSONString(o));
        return o;

    }
}