package com.betamedia.atom.core.behalf;

import com.betamedia.atom.core.behalf.pages.factory.impl.BFPageFactoryImpl;
import com.betamedia.atom.core.dsl.type.EnvironmentType;
import com.betamedia.atom.core.dsl.type.ProductType;
import com.betamedia.atom.core.holders.AppContextHolder;
import com.betamedia.atom.core.testingtype.annotations.TestConfigurationProperties;
import com.betamedia.atom.core.testingtype.base.AbstractClientTest;
import org.openqa.selenium.remote.BrowserType;

/**
 * @author Maksym Tsybulskyy
 *         Date: 9/11/17.
 */
@TestConfigurationProperties(
        //TODO refactor envInitialier to use original poduct type
        productType = ProductType.TP,
        environment = EnvironmentType.QA,
        environmentUrl = "https://www.behalf.com/",
        browserType = BrowserType.FIREFOX)
public class BFClientTest extends AbstractClientTest<BFPageFactoryImpl> {
    @Override
    public BFPageFactoryImpl getPageFactory() {
        return AppContextHolder.getBean(BFPageFactoryImpl.class);
    }
}
