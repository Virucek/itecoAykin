package pages;

import org.openqa.selenium.WebDriver;

public class ModalWindowSearchTableAsset extends ModalWindowSearchTableAccount {

    public ModalWindowSearchTableAsset(WebDriver driver){
        super(driver);
    }

    public String getTitle(){
        return "assetsList";
    }
}
