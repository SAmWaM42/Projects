import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Data{

    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Users/samue/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe"); // Replace with the actual path
        System.setProperty("webdriver.http.factory", "okhttp3.OkHttpClient$Factory");
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the Carrefour Kenya website
            driver.get("https://www.carrefour.ke/mafken/en/");

            // Wait for the dynamic content to load (you might need to adjust the wait time)
            Thread.sleep(5000); // Wait for 5 seconds (adjust as needed)

            // Get the page source after JavaScript has executed
            String html = driver.getPageSource();

            // Parse the HTML with Jsoup
            Document doc = Jsoup.parse(html);

            // Extract product names and prices (replace with the correct selectors)
            Elements productNames = doc.select(".product-name"); // Replace with the correct selector
            for (Element productName : productNames) {
                System.out.println(productName.text());
            }

            Elements prices = doc.select(".product-price"); // Replace with the correct selector
            for (Element price : prices) {
                System.out.println(price.text());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
//scrap this and try to use python to get the data