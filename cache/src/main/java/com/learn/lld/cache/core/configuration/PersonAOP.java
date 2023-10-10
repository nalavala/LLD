package com.learn.lld.cache.core.configuration;

import com.learn.lld.cache.Person;
import com.learn.lld.cache.core.Cache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
// TODO : check how this behavious in multiThreaded env
@Component
public class PersonAOP {

    @Autowired
    private Cache<String, Person> personCache;

    @Around("@annotation(com.example.ratelimiter.cache.interceptor.Cacheable)")
    public Person cacheInterceptor(ProceedingJoinPoint pj) throws Throwable {

        String key = (String)pj.getArgs()[0];
        Person value = personCache.get(key);

        if(value == null) {
            value = (Person)pj.proceed();
            personCache.put(key, value);
        }
        return personCache.get(key);

    }
}
