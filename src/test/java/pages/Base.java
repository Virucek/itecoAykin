package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static stepDefinition.InitialSteps.getDriver;

public class Base {

    WebDriver driver = getDriver();
    String name;

    public String getTitle() {
        return name;
    }

    public Base(WebDriver driver){
        PageFactory.initElements(driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public <TPage extends Base> TPage GetInstance(Class<TPage> pageClass)throws Throwable {
        try{
            return PageFactory.initElements(driver,pageClass);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public void checkElement(WebElement element, String elemText) throws InterruptedException {
        waitUntilElementPresent(element, 30);
        assertTrue(element.getText().contains(elemText));
        Thread.sleep(2000);
    }

    public void checkElementIgnoreCase(WebElement element, String elemText) throws InterruptedException {
        waitUntilElementPresent(element, 30);
        assertTrue(element.getText().equalsIgnoreCase(elemText));
        Thread.sleep(2000);
    }

    public void checkListOfElements(List<WebElement> elements, String elemText) throws InterruptedException{
        for(WebElement element: elements){
            waitUntilElementPresent(element, 10);
            if (element.getText().contains(elemText)){
                assertTrue(element.getText().contains(elemText));
            }
        }
    }

    public void checkClosedElement(WebElement element, String elemText)throws Throwable{
        Thread.sleep(1000);
        assertFalse(element.getText().equals(elemText));
    }

    public void inputEnterData(List<WebElement> elements, String elemText, String value) throws InterruptedException{
        waitUntilElementPresent(elements, 30);
        for (WebElement el : elements){
            if (el.getAttribute("placeholder").equals(elemText)){
                el.sendKeys(value);
                System.out.println(el.getAttribute("placeholder"));
            }
        }
    }

    public void clickButton(WebElement element, String elemText){
        waitUntilElementPresent(element, 10);
        if (element.getText().equalsIgnoreCase(elemText)){
            element.click();
        }
    }

    public void clickElement(List<WebElement> elements, String elemText){
        waitUntilElementPresent(elements, 30);
        for(WebElement element: elements) {
            if (element.getAttribute("title").equals(elemText)) {
                element.click();
            }
        }
    }

    public void clickOnListOfElements(List<WebElement> elements, String elemText){
        waitUntilElementPresent(elements, 30);
        for(WebElement element:elements){
            if (element.getText().contains(elemText)){
                element.click();
            }
        }
    }

    public void clickOnListOfElementsStartWith(List<WebElement> elements, String elemText){
        for(WebElement element:elements){
            if (element.getText().startsWith(elemText)){
                waitUntilElementPresent(element, 30);
                element.click();
                break;
            }
        }
    }

    public void clickOnListOfElementsBreak(List<WebElement> elements, String elemText){
        waitUntilElementPresent(elements, 30);
        for(WebElement element:elements){
            if (element.getText().equals(elemText)){
                element.click();
                break;
            }
        }
    }

    public void checkElementTitle(WebElement element, String elemText){
        waitUntilElementPresent(element, 10);
        assertTrue(element.getAttribute("title").equals(elemText));
    }

    public void inputValue(WebElement element, String value){
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public void checkPresenceOfElements(List<WebElement> elements, String elemText){
        waitUntilElementPresent(elements, 20);
        for (WebElement element: elements){
            if(element.getText().startsWith(elemText)){
                if(elements.size() >= 1){

                }
            }
        }
    }

    public void checkElementIsDisabled(WebElement element){
        waitUntilElementPresent(element, 10);
        assertFalse(element.isEnabled());
    }


    public boolean waitUntilElementPresent(WebElement element, int timeout){
        try {
            Thread.sleep(1000);
            (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    public boolean waitUntilElementPresent(List<WebElement> elements, int timeout){
        try {
            Thread.sleep(1000);
            (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOfAllElements(elements));
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    public void clickKeyTab(WebElement element) throws  InterruptedException{
        element.sendKeys(Keys.TAB);
        Thread.sleep(3000);
    }

    public void getValue(WebElement element, WebElement element2){
        assertEquals(element.getAttribute("value"), element2.getAttribute("value"));
    }
}
