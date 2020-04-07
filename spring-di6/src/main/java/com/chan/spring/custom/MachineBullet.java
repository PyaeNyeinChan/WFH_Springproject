package com.chan.spring.custom;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Retention(RUNTIME)
@Target(FIELD)
@Autowired
@Qualifier("machine")
public @interface MachineBullet {

}
