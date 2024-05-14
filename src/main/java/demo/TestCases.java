package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");
        String url = driver.getCurrentUrl();
        if(url.contains("leetcode")){
            System.out.println("The Home page contains Leetcode");
        }
        else
            System.out.println("The Home page doesn't contains Leetcode");
        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        driver.findElement(By.xpath("//p[text()='View Questions ']")).click();
        String url = driver.getCurrentUrl();
        if(url.contains("problemset")){
            System.out.println("The Home page contains problemset");
        }
        else
            System.out.println("The Home page doesn't contains problemset");

        List<WebElement> titles = driver.findElements(By.xpath("//a[@class = 'h-5 hover:text-blue-s dark:hover:text-dark-blue-s']"));
        Thread.sleep(5000);
        for(int i = 1; i <= 5; i++){
            String titleName = titles.get(i).getText();
            System.out.println(titleName);

            }
        System.out.println("end Test case: testCase02");
        }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        driver.findElement(By.xpath("(//a[@class ='h-5 hover:text-blue-s dark:hover:text-dark-blue-s'])[2]")).click();
        Thread.sleep(5000);
        String url = driver.getCurrentUrl();
        if (url.contains("two-sum")) {
            System.out.println("The url of the problem contains two-sum");
        } else
            System.out.println("The url of the problem doesn't contains two-sum");
        System.out.println("end Test case: testCase03");
        }

    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase04");
        driver.findElement(By.xpath("//div[@class='normal absolute left-0 top-0 whitespace-nowrap font-normal' and text()='Submissions']")).click();
        Thread.sleep(5000);
        //boolean result = driver.findElement(By.xpath("//a[text()='Register or Sign In']")).isDisplayed();
        //boolean result = driver.findElement(By.xpath("//span[contains(text(),'need')]")).isDisplayed();
        boolean result = driver.findElement((By.xpath("//a[contains(text(),'Register or Sign In')]"))).isDisplayed();

        if(result){
            System.out.println("Register or Sign In is displayed");
        }
        else
            System.out.println("Register or Sign In is Not displayed");
        System.out.println("end Test case: testCase04");
    }
}


