package com.site.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.site.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

    public TestBase(){ // this is the main constructor of this class. The "super" keyword from child classes will allow them to call this constructor (i.e. to ensure prop is accessible)

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    "src\\main\\java\\com\\site\\config\\config.properties");
            prop.load(ip);
        } catch (IOException e){
            System.out.println("** Can't find the config.properties file... **");
            e.printStackTrace();
        }
    }

    protected static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

    /************** INITIALIZE BROWSERS *********************/

    public static void initialization(){
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            DesiredCapabilities cp = new DesiredCapabilities();
            cp.setCapability(ChromeOptions.CAPABILITY, options);
            options.merge(cp);
            driver = new ChromeDriver(options);
        }
        else if (browserName.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

        driver.get(prop.getProperty("url"));
    }

    /************** EXTENT REPORTS *********************/

    public static final ExtentReports extentReports = new ExtentReports();
    public static final ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentSparkReport.html");
    public static final File file = new File("ExtentSparkReport.html");
    public static void initializeExtentReports(){
        extentReports.attachReporter(sparkReporter);
    }

    public static void flushExtentReports() throws IOException {
        extentReports.flush();
//        Desktop.getDesktop().browse(new File("ExtentSparkReport.html").toURI()); //To automatically open  the report once the test has finished.
    }
}
