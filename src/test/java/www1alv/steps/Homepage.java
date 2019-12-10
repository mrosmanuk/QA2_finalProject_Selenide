package www1alv.steps;

import com.codeborne.selenide.Configuration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class Homepage {

    private By fullScreenBanner = byXpath("//a[@class='close-button animated']");
    private By getFullScreenBannerFrame = By.xpath("//*[@id='mt-65cf2a318dbd5e21']");
    private By advSlider = By.xpath("//div[@class='close-button-slider desktop']");
    private By advSliderFrame2 = By.xpath("//*[@id='mt-5db6e4c3ca16efa9']");
    private By advSliderFrame = By.xpath("//*[@id='mt-d8736f517de4c467']");
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

    @And("I check for 1st slider banner, closing it if found")
    public void closeBottomBanner() throws InterruptedException {
         Thread.sleep(4000);
         try{
             if($(advSliderFrame).isDisplayed()){
                 switchTo().frame("mt-d8736f517de4c467");
                 $(advSlider).click();}
             else{
                 System.out.println("bottom slider not found");}}
         catch(Exception ignored){}}

    @And("I check for 2nd slider banner, closing it if found")
    public void closeBottomBanner2() throws InterruptedException {
         Thread.sleep(4000);
         try{
            if($(advSliderFrame2).isDisplayed()){
                switchTo().frame("mt-5db6e4c3ca16efa9");
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
