package com.betamedia.atom.core.behalf.pages.factory.impl;

import com.betamedia.atom.core.behalf.pages.factory.BFPageFactory;
import com.betamedia.atom.core.behalf.pages.pageobject.BFSignInFormPage;
import com.betamedia.atom.core.behalf.pages.pageobject.BFSignUpFormPage;
import com.betamedia.atom.core.behalf.pages.pageobject.BFSignUpPage;
import com.betamedia.atom.core.behalf.pages.pageobject.impl.BFSignInFormPageImpl;
import com.betamedia.atom.core.behalf.pages.pageobject.impl.BFSignUpFormPageImpl;
import com.betamedia.atom.core.behalf.pages.pageobject.impl.BFSignUpPageImpl;
import com.betamedia.atom.core.behalf.pages.pageobject.topnavigation.BFTopNavigation;
import com.betamedia.atom.core.behalf.pages.pageobject.topnavigation.impl.BFTopNavigationImpl;
import com.betamedia.atom.core.dsl.pages.annotation.PageFactory;
import com.betamedia.atom.core.dsl.pages.factory.AbstractPageFactory;
import com.betamedia.atom.core.dsl.type.ProductType;

/**
 * @author Maksym Tsybulskyy
 *         Date: 9/11/17.
 */
@PageFactory
public class BFPageFactoryImpl extends AbstractPageFactory implements BFPageFactory {

    @Override
    public ProductType getType() {
        return ProductType.BEHALF;
    }

    @Override
    public BFTopNavigation topNavigation() {
        return creator.getPage(BFTopNavigationImpl.class);
    }

    @Override
    public BFSignInFormPage signInFormPage() {
        return creator.getPage((BFSignInFormPageImpl.class));
    }

    @Override
    public BFSignUpPage signUpPage() {
        return creator.getPage(BFSignUpPageImpl.class);
    }

    @Override
    public BFSignUpFormPage signUpFormPage() {
        return creator.getPage(BFSignUpFormPageImpl.class);
    }
}
