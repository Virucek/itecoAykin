package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class TableReferenceBook extends Base{

    public TableReferenceBook(WebDriver driver){
        super(driver);
    }

    public String getTitle() {
        return "dictionaryList";
    }

    @FindBy(how = How.XPATH,using = "//ol[@class='breadcrumb']//*")
    public WebElement formTitle;

    /*@FindBy(how = How.XPATH, using = "//form[@name='listForm']//div")
    public WebElement column;*/

    @FindBy(how = How.XPATH, using = "//td[@role='gridcell']/a[contains(@href, 'dictionary')]")
    public List<WebElement> references;

    public void checkElementPage(String elemText) throws InterruptedException {
        checkElement(formTitle, elemText);
    }

    public void clickReferenceInColumn(String elemText){
        clickOnListOfElementsBreak(references, elemText);
    }
}
