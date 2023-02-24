package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ContactUsData {
    private WebDriver driver;
    public ContactUsData(WebDriver driver){
        this.driver = driver;
    }

    public String email,userName,message;

    public void UserData() throws IOException, ParseException {
        String src = System.getProperty("user.dir")+"/src/test/java/data/contactUsData.json";
        File file = new File(src);

        JSONParser parser = new JSONParser();
        JSONArray jArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object object : jArray){
            JSONObject jsonObject = (JSONObject) object;

            email = (String) jsonObject.get("email");
            userName = (String) jsonObject.get("name");
            message = (String) jsonObject.get("message");
        }
}}
