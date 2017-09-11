package com.betamedia.atom.testslibrary.behalf.web;

import com.betamedia.atom.core.behalf.BehalfClientTest;
import org.junit.Test;

/**
 * @author Maksym Tsybulskyy
 *         Date: 9/11/17.
 */
public class SignInTest extends BehalfClientTest {

    @Test
    public void signIn(){
        pages().topNavigation().signIn();
    }
}
