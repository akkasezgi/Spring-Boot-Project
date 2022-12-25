package com.eakkas.springbootproject.config;

import com.eakkas.springbootproject.exception.GlobalException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ResponseStatusException;

@Aspect
@Configuration
public class AspectConfig {

    /*
     anotationları yakalama islemi yapıyoruz.
     anotation execution içindeki metodu temsil ediyor. Cağırdıgımızda yakalayacak.
     servisi cagırınca bu metod devreye girip yakalıyor. serviceimpl için gerekli
     */

    private final Logger log = LoggerFactory.getLogger(AspectConfig.class);

    @Around(value = "execution(* com.eakkas.springbootproject.service.impl.*.*(..))")
    public Object handler(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        // saniye baslatarak problem yoksa kaç sn de işlem tamamlandıgını söylemesi sağlandı.


        // metodu ilerlet çalışsın. çalışınca hata varsa catch gidiyor.
        try {
            Object obj = joinPoint.proceed();
            long timeTaken = System.currentTimeMillis() - startTime;
            log.info("Time taken by {} is {}", joinPoint, timeTaken);
            return obj;
        } catch (GlobalException e) {
            log.error("Exception message {}", e.getMessage());
            log.error("Exception status {}", e.getStatus());
            throw new ResponseStatusException(e.getStatus(), e.getMessage());
        }
    }

}
