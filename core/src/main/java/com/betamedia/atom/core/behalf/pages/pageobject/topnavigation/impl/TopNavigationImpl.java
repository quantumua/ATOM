package com.betamedia.atom.core.behalf.pages.pageobject.topnavigation.impl;

import com.betamedia.atom.core.behalf.pages.pageobject.topnavigation.TopNavigation;
import com.betamedia.atom.core.dsl.pages.AbstractPageObject;
import com.betamedia.atom.core.dsl.pages.annotation.StoredId;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Maksym Tsybulskyy
 *         Date: 9/11/17.
 */
public class TopNavigationImpl extends AbstractPageObject implements TopNavigation {

    @StoredId
    private By signIn;


    protected TopNavigationImpl(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void signIn() {
        waitUntilDisplayed(signIn).click();
        waitUntilPageLoad();
    }
}
