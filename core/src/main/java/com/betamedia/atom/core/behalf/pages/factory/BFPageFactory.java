package com.betamedia.atom.core.behalf.pages.factory;

import com.betamedia.atom.core.behalf.pages.pageobject.BFSignInFormPage;
import com.betamedia.atom.core.behalf.pages.pageobject.BFSignUpFormPage;
import com.betamedia.atom.core.behalf.pages.pageobject.BFSignUpPage;
import com.betamedia.atom.core.behalf.pages.pageobject.topnavigation.BFTopNavigation;

/**
 * @author Maksym Tsybulskyy
 *         Date: 9/11/17.
 */
public interface BFPageFactory {

    BFTopNavigation topNavigation();

    BFSignInFormPage signInFormPage();

    BFSignUpPage signUpPage();

    BFSignUpFormPage signUpFormPage();

}
