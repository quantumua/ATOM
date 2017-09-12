package com.betamedia.atom.core.behalf.pages.pageobject.topnavigation.impl;

import com.betamedia.atom.core.behalf.pages.pageobject.topnavigation.BFTopNavigation;
import com.betamedia.atom.core.dsl.pages.AbstractPageObject;
import com.betamedia.atom.core.dsl.pages.annotation.StoredId;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Maksym Tsybulskyy
 *         Date: 9/11/17.
 */
public class BFTopNavigationImpl extends AbstractPageObject implements BFTopNavigation {

    @StoredId
    private By signIn;


    public BFTopNavigationImpl(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void signIn() {
        waitUntilDisplayed(signIn).click();
        waitUntilPageLoad();
    }
}
