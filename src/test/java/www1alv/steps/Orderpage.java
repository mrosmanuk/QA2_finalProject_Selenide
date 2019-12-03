package www1alv.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import www1alv.model.Product;
import www1alv.model.User;

import java.util.Arrays;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class Orderpage {
    private By nextStep1 = byXpath("//a[@class='ait-button ait-button-primary order-form-forward-button']");
    private By nextWithoutReg = byXpath("//a[@class='button btn-v2']");
    private By inputName = byXpath("//input[@id='order_main_data_name']");
    private By inputUserLastName = byXpath("//input[@id='order_main_data_surname']");
    private By inputEmail = byXpath("//input[@id='order_main_data_email']");
    private By inputPhoneNumber = byXpath("//input[@id='order_main_data_contact_phone_number']");
    private By spamAgreementSelector = byXpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']");
    private By noSpamOption = byXpath("//*[@id=\"ui-id-2\"]/li[2]");
    private By acceptTerms = byXpath("//input[@id='accept_purchase_agreement']");
    private By deliveryMethod = byXpath("//article[@data-delivery-type-id='9']");
    private By nextStep2 = byXpath("//a[@class='ait-button ait-button-primary order-form-forward-button']");
    private By contactMethod = byXpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']");
    private By contactMethodByEmail = byXpath("//a[contains(.,'E-past')]");
    private By nextStep3 = byXpath("//a[@class='ait-button ait-button-primary order-form-forward-button']");
    private By nameBeforeCheckout = byXpath("//div[@class='ait-cart-item-info']");
    private By priceBeforeCheckout = byXpath("//span[@class='ait-cart-total-count ait-cart-total-price']");

    private Product product = new Product();

    private SoftAssert softAssert = new SoftAssert();

    @And("I navigate to next page")
    public void nextStep1(){
        $(nextStep1).click();
    }

    @And("I navigate to next page via without registration path")
    public void nextStepWithoutReg(){
        $(nextWithoutReg).click();
    }

    @And("^I enter name: (.*), lastName: (.*), email: (.*), phone: (.*)$")
    public void enterUserInformation(String name, String lastName, String email, String phone){
        $(inputName).sendKeys(name);
        User.setUserName(name);
        $(inputUserLastName).sendKeys(lastName);
        User.setUserLastname(lastName);
        $(inputEmail).sendKeys(email);
        User.setEmail(email);
        $(inputPhoneNumber).sendKeys(phone);
        User.setPhoneNumber(phone);}

    @And("I refuse to receive spam")
    public void agreeOnNoSpam(){
        $(spamAgreementSelector).click();
        $(noSpamOption).click();}

    @And("I agree on terms of use")
    public void agreeOnTermsOfUse(){
        $(acceptTerms).click();
    }

    @And("I select delivery method")
    public void selectDeliveryMethod() throws InterruptedException {
        $(deliveryMethod).click();
        Thread.sleep(3000);}

    @And("I navigate to next page 2")
    public void nextStep2(){
        $(nextStep2).click();}

    @And("I select to contact me via email")
    public void userContactOption(){
        $(contactMethod).click();
        $(contactMethodByEmail).click();}

    @And("I navigate to next page 3")
    public void nextStep3(){
        $(nextStep3).click();}

    @And("I fetch and save product price and name before checkout")
    public void getNameBeforeCheckout(){
        product.setProductPriceBeforeCheckout($(priceBeforeCheckout).getText().split("[^\\S]+")[0]);
        System.out.println("product price before checkout: "+ Product.getProductPriceBeforeCheckout());
        product.setProductNameBeforeCheckout($(nameBeforeCheckout).getText());
        System.out.println("product name before checkout: "+ Product.getProductNameBeforeCheckout());}

    @And("I fetch user information before checkout")
    public void getUserInformation(){
        User.setCheckoutUserData($(byXpath("//*[@id=\"main\"]/div/div/form/div[2]/div/div[1]")).getText().split("[^\\S]+"));
        System.out.println(Arrays.toString(User.getCheckoutUserData()));}

    @Then("I compare product and user information")
    public void assertInfo(){
        softAssert.assertEquals(Product.getProductName(),Product.getProductNameBeforeCheckout());
        softAssert.assertEquals(Product.getProductPrice(),Product.getProductPriceBeforeCheckout());
        softAssert.assertEquals(User.getUserName(),User.getCheckoutUserData()[1]);
        softAssert.assertEquals(User.getUserLastname(),User.getCheckoutUserData()[2]);
        softAssert.assertEquals(User.getEmail(),User.getCheckoutUserData()[3]);
        softAssert.assertEquals(User.getPhoneNumber(),User.getCheckoutUserData()[4]);
        softAssert.assertAll();}
}
