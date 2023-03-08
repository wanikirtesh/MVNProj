package com.sbn.tests;

import com.sbn.pages.E3Page;
import org.testng.annotations.Test;

public class E3Test extends BaseTest {

    @Test(groups = {"regression"})
    public void validateInlineData(){
        E3Page e3Page = new E3Page(driver);
        e3Page.validateAllInlineRows();
    }

    @Test(groups = {"sanity"})
    public  void validatePopUpData(){
        E3Page e3Page = new E3Page(driver);
        e3Page.validateAllPopups();
    }



}
