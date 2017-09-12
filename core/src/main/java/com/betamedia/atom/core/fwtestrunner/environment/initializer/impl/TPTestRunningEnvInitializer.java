package com.betamedia.atom.core.fwtestrunner.environment.initializer.impl;

import com.betamedia.atom.core.dsl.templates.tp.TPTemplateProvider;
import com.betamedia.atom.core.fwtestrunner.environment.initializer.AbstractTestRunningEnvInitializer;
import com.betamedia.atom.core.holders.ThreadLocalBeansHolder;
import com.betamedia.atom.core.product.TPProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Configures and exposes environment-specific components through {@link ThreadLocalBeansHolder} for later use outside of
 * managed application context.
 *
 * @author mbelyaev
 * @since 5/31/17
 */
@Component
public class TPTestRunningEnvInitializer extends AbstractTestRunningEnvInitializer implements  TPProduct {

    @Autowired
    private TPTemplateProvider templateProvider;

    @Override
    protected TPTemplateProvider getTemplateProvider() {
        return templateProvider;
    }
}
