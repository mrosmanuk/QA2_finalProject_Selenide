package www1alv.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;

public class Homepage {

    private By fullScreenBanner = byXpath("/html/body/div[1]/div/div/a");
    private By getFullScreenBannerFrame = By.xpath("//*[@id=\"mt-65cf2a318dbd5e21\"]");
    private By advSlider = By.xpath("//div[@class='close-button-slider desktop']");
    private By advSliderFrame = By.xpath("//*[@id=\"mt-b832a55b5fb34368\"]");
    private By cookieButton = By.xpath("//a[@class='c-button-inverse']");
    private By phoneCategory = By.xpath("//a[contains(@href,'telefoni_plansetdatori')]");
    private By sortBySelector = By.xpath("//a[@class='select-opener select-add-info']");
    private By sortByStars = By.xpath("//li[@rel='4']");
    private By selectProduct = By.xpath("//section[@class='product ']//img");

    @Given("I open website")
    public void iOpenWebsite(){
        Configuration.startMaximized=true;
        open("https://www.1a.lv/");}

    @And("I check for fullscreen banner, closing it if found")
    public void closeFullscreenBanner() throws InterruptedException {
        Thread.sleep(4000);
        try{
            if($(getFullScreenBannerFrame).isDisplayed()){
                switchTo().frame("mt-65cf2a318dbd5e21");
                $(fullScreenBanner).click();}
            else{
                System.out.println("fullscreen frame not found");}}
        catch(Exception ignored){}}

    @And("I check for slider banner, closing it if found")
    public void closeBottomBanner() throws InterruptedException {
         Thread.sleep(4000);
         try{
             if($(advSliderFrame).isDisplayed()){
                 switchTo().frame("mt-b832a55b5fb34368");
                 $(advSlider).click();}
             else{
                 System.out.println("bottom slider not found");}}
         catch(Exception ignored){}}

    @And("I accept cookies")
    public void acceptCookies() throws InterruptedException {
        Thread.sleep(2000);
        $(cookieButton).click();}

    @When("I open mobile devices category")
    public void navigateToPhone(){
        $(phoneCategory).click();}

    @And("^I navigate to brand (.*)$")
    public void navigateToBrand(String brand){
        $(byXpath("//img[@alt='"+brand+"']")).scrollTo().click();
    }

    @And("I sort products by *star* highest")
    public void sortByStars() throws InterruptedException {
        $(sortBySelector).scrollTo().click();
        $(sortByStars).click();
        Thread.sleep(4000);}

    @When("I select product with highest *star* rating and proceed to product page")
    public void selectProduct() {
        $(selectProduct).scrollTo().click();}
}
