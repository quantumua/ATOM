package com.betamedia.atom.core.behalf.pages.pageobject.impl;

import com.betamedia.atom.core.behalf.pages.pageobject.BFSignUpPage;
import com.betamedia.atom.core.dsl.pages.AbstractPageObject;
import com.betamedia.atom.core.dsl.pages.annotation.StoredId;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Nir Shukrun
 *         Date: 9/09/17.
 */
public class BFSignUpPageImpl extends AbstractPageObject implements BFSignUpPage {

    @StoredId("signUpAsSMBBtn")
    private By signUpAsSMBButton;
    @StoredId("signUpAsSupplierBtn")
    private By signUpAsSupplierButton;
    

    public BFSignUpPageImpl(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void signUpAsSMB(){
        waitUntilDisplayed(signUpAsSMBButton);
        find(signUpAsSMBButton).click();
    }

    @Override
    public void signUpAsSupplier(){
        waitUntilDisplayed(signUpAsSupplierButton);
        find(signUpAsSupplierButton).click();
    }

	@Override
	public boolean isSignUpAsSMBBtnExists() {
		return waitUntilDisplayed(signUpAsSMBButton) != null;
	}

	@Override
	public boolean isSignUpAsSupplierBtnExists() {
		return waitUntilDisplayed(signUpAsSMBButton) != null;
	}
	
}
