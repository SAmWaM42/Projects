//note to self use dependancy managment software
package com.example.shopping_app_demo;


import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.awt.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import okhttp3.OkHttpClient;
import org.openqa.selenium.chrome.ChromeOptions;
public class Data{

    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Users/samue/Downloads/chromedriver/chromedriver-win64/chromedriver.exe"); // Replace with the actual path
        ChromeOptions options = new ChromeOptions();
        options.setCapability("webdriver.http.factory", "okhttp3.OkHttpClient$Factory");

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
            Elements productNames = doc.select("a[href]"); // Replace with the correct selector

            System.out.println(productNames.isEmpty());
            System.out.println(productNames.size());

            for (Element productName : productNames) {
                System.out.println(productName.attr("href"));
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

class item {
    public item(String name, String brand, String descrip, String cat, int price) {
        this.name = name;
        this.brand = brand;
        this.descrip = descrip;
        this.price = price;
        this.category = cat;

    }

    public item() {

    }

    public String category;
    public String name;
    public String brand;
    public String descrip;
    public int price;
}

class shoppinglist_item {
    public item items = new item();
    private int quantity;
    private int final_price;

    public shoppinglist_item(item Item, int quantity) {
        this.items = Item;
        this.quantity = quantity;
        set_final_price();

    }

    private void set_final_price() {
        final_price = items.price * quantity;
    }

    public int get_final_price() {

        return final_price;
    }

}

class shoppinglist 
{


    private ArrayList<shoppinglist_item> items = new ArrayList<shoppinglist_item>();
    public int end_price;
    JPanel list=new JPanel();

    public int get_end_price() {
        int ans = 0;
        for (int i = 0; i < this.items.size(); i++) {
            ans += items.get(i).get_final_price();
        }
        return ans;
    }

    public void add_item(shoppinglist_item a) {
        this.items.add(a);

    }

    public void remove_item(String name) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).items.name == name) {
                if (this.items.get(i).items.name == name) {
                    this.items.remove(this.items.get(i));
                }
            }

        }

    }
    public void display_items()
    {
    
    }
}
class shelf implements ItemListener
{
    private ArrayList<item> items = new ArrayList<item>();
    JComboBox<String> box=new JComboBox<String>();
    JTextField txtInput = new JTextField("Set quantity");
    private ArrayList<String> compare_list = new ArrayList<String>();
    shoppinglist list=new shoppinglist();

    public shelf()
    {
    }
    public void shelf_item(item a)
    {
        this.items.add(a);
        String value=a.name.concat(a.brand).concat(a.descrip); 
        this.box.addItem(value);
        compare_list.add(value);
        }
@Override
public void itemStateChanged(ItemEvent e)
{

    Object obj=e.getSource();
    if(obj==this.box)
    {
       
    int amount=Integer.valueOf(txtInput.getText());
    String item_name=this.box.getSelectedItem().toString();
    int actual_item=0;
    for(int i=0;i<compare_list.size();i++)
    {
        if(compare_list.get(i)==item_name)
        {
           actual_item=i;
        }
    }
     shoppinglist_item  new_item=new shoppinglist_item(items.get(actual_item),amount);
     list.add_item(new_item);

    }

    
}
   


}

class controller  {

}
