package com.learn.lld.cache.core.configuration;

import com.learn.lld.cache.Person;
import com.learn.lld.cache.core.Cache;
import com.learn.lld.cache.core.eviction.LRUEvictionStrategy;
import com.learn.lld.cache.core.storage.InMemoryCacheStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {

    @Bean
    public Cache<String, Person> personCache() {
        return new Cache<>(new LRUEvictionStrategy<>(), new InMemoryCacheStorage<>(3));
    }
}

