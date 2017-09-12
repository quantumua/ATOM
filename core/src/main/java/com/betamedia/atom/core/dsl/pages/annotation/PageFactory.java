package com.betamedia.atom.core.dsl.pages.annotation;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * @author Maksym Tsybulskyy
 * Date: 9/12/17.
 */

/**
 * Indicates that class is PageObjectFactory, automatically register it in Context to inject in associated tests
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Lazy
@Component
@Scope(SCOPE_PROTOTYPE)
public @interface PageFactory {
}
