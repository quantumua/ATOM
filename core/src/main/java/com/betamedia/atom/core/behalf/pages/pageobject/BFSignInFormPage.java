package com.betamedia.atom.core.behalf.pages.pageobject;

/**
 * @author Nir Shukrun
 *         Date: 9/09/17.
 */
public interface BFSignInFormPage {
    void signIn(String signInEmail, String signInPassword);

    boolean isLoginFormBtnExists();

    void signUp();
}
