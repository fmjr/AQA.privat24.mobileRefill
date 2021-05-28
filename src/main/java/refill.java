import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class refill {

    @Test
    public void mobileRefillPB(){
        WebDriver driver = new ChromeDriver();

        driver.get("https://next.privat24.ua/mobile");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement phoneCode = driver.findElement(By.xpath("//button[@data-qa-node='phone-code']"));
        phoneCode.click();

        WebElement findCountryCode = driver.findElement(By.xpath("//input[@placeholder='Пошук']"));
        findCountryCode.sendKeys("+380");

        WebElement phoneCodeUkraine = driver.findElement(By.xpath("//button[@data-qa-node='phone-code-option']"));
        phoneCodeUkraine.click();

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@data-qa-node='phone-number']"));
        phoneNumber.sendKeys("969910470");

        WebElement amountHotSpot = driver.findElement(By.xpath("(//button[@data-qa-node='amount-hot-spot'])[3]"));
        amountHotSpot.click();

        WebElement cardNumber = driver.findElement(By.xpath("//input[@data-qa-node='numberdebitSource']"));
        cardNumber.sendKeys("4567739561253907");

        WebElement expiredDateFrom = driver.findElement(By.xpath("//input[@data-qa-node='expiredebitSource']"));
        expiredDateFrom.sendKeys("0323");

        WebElement cvvFrom = driver.findElement(By.xpath("//input[@data-qa-node='cvvdebitSource']"));
        cvvFrom.sendKeys("321");

        WebElement CardName = driver.findElement(By.xpath("//input[@data-qa-node='firstNamedebitSource']"));
        CardName.sendKeys("Max");

        WebElement CardSurname = driver.findElement(By.xpath("//input[@data-qa-node='lastNamedebitSource']"));
        CardSurname.sendKeys("Fil");

        WebElement continueButton = driver.findElement(By.xpath("//button[@data-qa-node='submit']"));
        continueButton.submit();

        By expectedPhone = By.xpath("//span[@data-qa-node='details']");
        Assert.assertEquals("Поповнення телефону. На номер +380969910470", driver.findElement(expectedPhone).getText());

        By expectedCard = By.xpath("//td[@data-qa-node='card']");
        Assert.assertEquals("4567 **** **** 3907", driver.findElement(expectedCard).getText());

        By expectedAmount = By.xpath("//div[@data-qa-node='total']");
        Assert.assertEquals("150 UAH", driver.findElement(expectedAmount).getText());

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='button' and contains(., 'Підтвердити')]"));
        submitButton.click();

    }
}
