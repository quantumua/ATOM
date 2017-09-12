package com.betamedia.atom.core.behalf.pages.pageobject;

/**
 * @author Nir Shukrun
 *         Date: 9/09/17.
 */
public interface BFSignUpFormPage {
    void signUp(String firstName, String lastName, String companyName, String email, String password);
    
    boolean isSignUpBtnExists();
}
