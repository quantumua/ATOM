package com.betamedia.atom.core.behalf.pages.factory.impl;

import com.betamedia.atom.core.behalf.pages.factory.BehalfPageFactory;
import com.betamedia.atom.core.behalf.pages.pageobject.topnavigation.TopNavigation;
import com.betamedia.atom.core.behalf.pages.pageobject.topnavigation.impl.TopNavigationImpl;
import com.betamedia.atom.core.dsl.pages.factory.AbstractPageFactory;
import com.betamedia.atom.core.dsl.type.ProductType;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * @author Maksym Tsybulskyy
 *         Date: 9/11/17.
 */

public class BehalfPageFactoryImpl extends AbstractPageFactory implements BehalfPageFactory {

    @Override
    public ProductType getType() {
        return ProductType.BEHALF;
    }

    @Override
    public TopNavigation topNavigation() {
        return creator.getPage(TopNavigationImpl.class);
    }
}
