package com.chan.spring.custom;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Retention(RUNTIME)
@Target(TYPE)
@Component
@Qualifier("machine")
public @interface GunMachine {

}
