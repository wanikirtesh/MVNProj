package com.sbn.tests.travelyari;

import com.sbn.pages.travelyari.SearchPage;
import com.sbn.pages.travelyari.SearchResultPage;
import com.sbn.tests.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    @Test(dataProvider = "fromToData")
    public void validateIfResultPageShowsDataAsEnteredOnSearchPage(String from,String to){
        SearchPage searchPage = new SearchPage(driver);
        SearchResultPage searchResultPage = searchPage.search(from,to);
        searchResultPage.validateSearchCriteria();
    }


    @DataProvider(name = "fromToData")
    public Object[][] getFromTo(){
        String[][] fromTo = {{"Pune","Mumbai"},{"Pune","Latur"},{"Pune","Jalgaon"}};
        return fromTo;
    }


}
