package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PlaceOrderData {
    private WebDriver driver;
    public PlaceOrderData(WebDriver driver){
        this.driver = driver;
    }

    public String name, country, city, credit, month, year;

    public void UserData() throws IOException, ParseException {
        String src = System.getProperty("user.dir")+"/src/test/java/data/placeOrderData.json";
        File file = new File(src);

        JSONParser parser = new JSONParser();
        JSONArray jArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object object : jArray){
            JSONObject jsonObject = (JSONObject) object;

            name = (String) jsonObject.get("name");
            country = (String) jsonObject.get("country");
            city = (String) jsonObject.get("city");
            credit =(String) jsonObject.get("credit");
            month = (String) jsonObject.get("month");
            year = (String) jsonObject.get("year");
        }
    }
}
