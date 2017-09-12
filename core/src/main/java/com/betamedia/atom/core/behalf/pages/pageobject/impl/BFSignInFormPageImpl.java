package com.betamedia.atom.core.behalf.pages.pageobject.impl;

import com.betamedia.atom.core.behalf.pages.pageobject.BFSignInFormPage;
import com.betamedia.atom.core.dsl.pages.AbstractPageObject;
import com.betamedia.atom.core.dsl.pages.annotation.StoredId;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Nir Shukrun
 *         Date: 9/09/17.
 */
public class BFSignInFormPageImpl extends AbstractPageObject implements BFSignInFormPage {

    @StoredId("loginFormEmail")
    private By emailField;
    @StoredId("loginFormPassword")
    private By passwordField;
    @StoredId("loginFormBtn")
    private By loginButton;
    @StoredId
    private By signUpLink;

    public BFSignInFormPageImpl(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void signIn(String signInEmail, String signInPassword) {
        waitUntilDisplayed(loginButton);
        find(emailField).sendKeys(signInEmail);
        find(passwordField).sendKeys(signInPassword);
        find(loginButton).click();
    }

	@Override
	public boolean isLoginFormBtnExists() {
		return waitUntilDisplayed(loginButton) != null;
	}

    @Override
    public void signUp() {
        waitUntilDisplayed(signUpLink).click();
        waitUntilPageLoad();
    }
}
