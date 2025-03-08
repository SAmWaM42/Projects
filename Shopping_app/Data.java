import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Data {

    public static void main(String[] args) {
        String url[] = {
            "https://www.carrefour.ke/mafken/en/","https://www.carrefour.ke/mafken/en/c/FKEN21000000"

        
        }; // Replace with the product URL
    try{
        Document doc = Jsoup.connect(url[1]).get();
         

      
        Elements newsHeadlines = doc.select(".css-11qbfb");

        System.out.println(newsHeadlines.isEmpty());

        System.out.println(newsHeadlines.size());

       
        
       
        for (Element headline : newsHeadlines)
        {
            System.out.println(headline.text());
           
        
        }


    }
    
         catch (IOException e) {
            e.printStackTrace();
        }
    }
}
