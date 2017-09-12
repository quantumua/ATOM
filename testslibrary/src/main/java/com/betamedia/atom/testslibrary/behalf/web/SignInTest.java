package com.betamedia.atom.testslibrary.behalf.web;

import com.betamedia.atom.core.behalf.BFClientTest;
import org.testng.annotations.Test;

/**
 * @author Maksym Tsybulskyy
 *         Date: 9/11/17.
 */
public class SignInTest extends BFClientTest {

    @Test
    public void signIn(){
        pages().topNavigation().signIn();
    }
}
