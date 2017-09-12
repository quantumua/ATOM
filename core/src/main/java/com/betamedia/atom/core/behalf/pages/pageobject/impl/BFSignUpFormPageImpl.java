package com.betamedia.atom.core.behalf.pages.pageobject.impl;

import com.betamedia.atom.core.behalf.pages.pageobject.BFSignUpFormPage;
import com.betamedia.atom.core.dsl.pages.AbstractPageObject;
import com.betamedia.atom.core.dsl.pages.annotation.StoredId;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Nir Shukrun
 *         Date: 9/09/17.
 */
public class BFSignUpFormPageImpl extends AbstractPageObject implements BFSignUpFormPage {

    @StoredId("signUpFormFirstName")
    private By firstNameField;
    @StoredId("signUpFormLastName")
    private By lastNameField;
    @StoredId("signUpFormCompany")
    private By companyNameField;
    @StoredId("signUpFormEmail")
    private By emailField;
    @StoredId("signUpFormPassword")
    private By passwordField;
    @StoredId("signUpFormBtn")
    private By signUpButton;

    public BFSignUpFormPageImpl(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void signUp(String firstName, String lastName, String companyname, String email, String password){
        waitUntilDisplayed(signUpButton);
        find(firstNameField).sendKeys(firstName);
        find(lastNameField).sendKeys(lastName);
        find(companyNameField).sendKeys(companyname);
        find(emailField).sendKeys(email);
        find(passwordField).sendKeys(password);
        find(signUpButton).click();
    }

	@Override
	public boolean isSignUpBtnExists() {
		return waitUntilDisplayed(signUpButton) != null;
	}
}
