package com.betamedia.atom.testslibrary.behalf.web;

import com.betamedia.atom.core.behalf.BFClientTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Nir Shukrun
 *         Date: 9/09/17.
 */
public class BFNavigationTest extends BFClientTest {

    
    @Test
    public void bfSignInTest() {
        pages().topNavigation().signIn();
        pages().signInFormPage().signIn("sanitytestn@mailinator.com", "!MYbehalf123123");
        Assert.assertTrue(pages().signInFormPage().isLoginFormBtnExists());
    }
	
}
