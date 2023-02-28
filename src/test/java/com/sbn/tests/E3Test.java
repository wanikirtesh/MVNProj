package com.sbn.tests;

import com.sbn.pages.E3Page;
import org.testng.annotations.Test;
import util.TestConfigReader;
public class E3Test extends BaseTest {

    @Test
    public void validateInlineData(){
        E3Page e3Page = new E3Page(driver);
        e3Page.validateAllInlineRows();
    }

    @Test
    public  void validatePopUpData(){
        E3Page e3Page = new E3Page(driver);
        e3Page.validateAllPopups();
    }



}
