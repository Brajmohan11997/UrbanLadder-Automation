package homePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class stepDef {
    WebDriver driver;

    @Given("launch the browser")
    public void launch_the_browser(){
        driver = new ChromeDriver();
        driver.get("https://www.urbanladder.com/");
        driver.manage().window().maximize();
        String expectedURL = "https://www.urbanladder.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.equals(expectedURL), "We correct the home page");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @When("search the product")
    public void search_the_product(){
        WebElement searchInput = driver .findElement(By.xpath("//input[@placeholder=\"Search\"]"));
        searchInput.sendKeys("Sofa");
        searchInput.submit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement popClose = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"close-reveal-modal hide-mobile\"]")));
        popClose.click();
    }
    @And("filter search result")
    public void filter_search_result() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement category = driver.findElement(By.xpath("//div[contains(text(), \"Category\")]"));
        actions.moveToElement(category).perform();
        List<WebElement> brandCheckBox = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
        String valueToSelect = "Fabric Sofa Sets";
        for (WebElement checkBox : brandCheckBox) {
            if(!checkBox.isSelected()){
                if (checkBox.getAttribute("value").equals(valueToSelect)) {
                    checkBox.click();
                    System.out.println("This product is" + valueToSelect + " selected.");
                    break; // Exit the loop once the button is selected
                }
            }
        }
        actions.moveByOffset(0, -50).perform();
        Thread.sleep(3000);

    }

    @And("add a product to the cart")
    public void add_a_product_to_the_cart(){
        driver.findElement(By.xpath("(//a[@href=\"/products/walton-sofa-asphalt-grey?src=room\"])[1]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement addProduct = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        addProduct.click();
    }
    @Then("proceed to checkout")
    public void proceed_to_checkout() throws InterruptedException {
        driver.findElement(By.xpath("(//button[@class=\"action-button checkout-button\"])[1]")).click();
        WebElement email = driver.findElement(By.xpath("//input[@placeholder=\"Enter Email\"]"));
        email.sendKeys("john.doe@gmail.com");
        WebElement pinCode = driver.findElement(By.xpath("(//input[@placeholder=\"PIN Code\"])[1]"));
        pinCode.sendKeys("560008");
        WebElement address = driver.findElement(By.xpath("(//textarea[@placeholder=\"Address\"])[1]"));
        address.sendKeys("Bangalore karnataka");
        WebElement firstName = driver.findElement(By.xpath("(//input[@placeholder=\"First Name\"])[1]"));
        firstName.sendKeys("John");
        WebElement lastName = driver.findElement(By.xpath("(//input[@placeholder=\"Last Name\"])[1]"));
        lastName.sendKeys("Doe");
        WebElement phoneNo = driver.findElement(By.xpath("(//input[@placeholder=\"Enter 10 digit mobile number\"])[1]"));
        phoneNo.sendKeys("6262457851");
        driver.findElement(By.id("address-form-submit")).click();

        String expectedURL = "https://www.urbanladder.com/checkout/payment";
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.equals(expectedURL),"correct page of payment");

        Thread.sleep(5000);
        driver.quit();
    }
}
