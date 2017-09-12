package com.betamedia.atom.core.behalf.pages.pageobject;

/**
 * @author Nir Shukrun
 *         Date: 9/09/17.
 */
public interface BFSignUpPage {
	void signUpAsSMB();
	
	void signUpAsSupplier();
    
    boolean isSignUpAsSMBBtnExists();
	
	boolean isSignUpAsSupplierBtnExists();
}
