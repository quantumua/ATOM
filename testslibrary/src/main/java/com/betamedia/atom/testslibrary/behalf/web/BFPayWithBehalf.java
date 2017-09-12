package com.betamedia.atom.testslibrary.behalf.web;

import com.betamedia.atom.core.behalf.BFClientTest;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author Nir Shukrun
 *         Date: 9/09/17.
 */
public class BFPayWithBehalf extends BFClientTest {

    @Test
    @Parameters({"firstName", "lastName", "companyName", "email", "password"})
    public void bfSignUpSMBTest(@Optional("Sanity") String firstName, @Optional("Test") String lastName,
                                @Optional("ATOM Sanity Test") String companyName, @Optional("SanityTestS@mailinator.com") String email,
                                @Optional("!MYbehalf123123") String password) {
        pages().topNavigation().signIn();
        pages().signInFormPage().signUp();
        pages().signUpPage().signUpAsSMB();
        pages().signUpFormPage().signUp(firstName, lastName, companyName, email, password);
        Assert.assertTrue(pages().signUpFormPage().isSignUpBtnExists());
    }
}
