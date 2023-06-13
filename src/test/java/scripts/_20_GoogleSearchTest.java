package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;
import pages.GoogleSearchResultPage;

public class _20_GoogleSearchTest extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("http://www.google.com");
        googleSearchPage = new GoogleSearchPage();
        googleSearchResultPage = new GoogleSearchResultPage();
    }

    @Test(priority = 1, description = "Validate The Google search")
    public void validateTheGoogleSearchResult(){
       googleSearchPage.search("canvas painting");

        Assert.assertTrue(googleSearchResultPage.resultStat.isDisplayed());
        String resultTag = googleSearchResultPage.resultStat.getText();

        Assert.assertTrue(Integer.parseInt(resultTag.replaceAll("[^0-9]", "").substring(0,1)) > 0);

    }

    @Test(priority = 2, description = "Validate the Google search", dataProvider = "searchKeys")
    public void validateTheSearch(String key){
        googleSearchPage.search(key);

        Assert.assertTrue(googleSearchResultPage.resultStat.isDisplayed());
        String resultTag = googleSearchResultPage.resultStat.getText();

        Assert.assertTrue(Integer.parseInt(resultTag.replaceAll("[^0-9]", "").substring(0,1)) > 0);
    }

    @DataProvider
    public Object[] searchKeys(){
        return new Object[]{"Tesla", "Apple", "Microsoft", "Oracle"};
    }

}
