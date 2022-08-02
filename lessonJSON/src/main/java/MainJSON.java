

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;


public class MainJSON {
    public static void main(String[] args) {

////        Чтение JSON файла
//        JSONParser parser = new JSONParser();
//        try {
//            Object obj = parser.parse(new FileReader("lessonJSON/src/main/resources/data.json"));
//            JSONObject jsonObject = (JSONObject) obj;
//            System.out.println(jsonObject);
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }


//        //json simple sub-objects
//        JSONParser parser = new JSONParser();
//        try {
//            Object obj = parser.parse(new FileReader("lessonJSON/src/main/resources/data.json"));
//            JSONObject jsonObject = (JSONObject) obj;
//
//            String lastname = (String) jsonObject.get("lastName");
//            System.out.println(lastname);
//
//            JSONObject address = (JSONObject) jsonObject.get("address");
//            String city = (String) address.get("streetAddress");
//            System.out.println(city);
//
//            JSONArray phoneNumber = (JSONArray) jsonObject.get("phoneNumbers");
//            for (Object number : phoneNumber) {
//                System.out.println(number);
//
//            }
//
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }


        //json simple write
        JSONObject obj = new JSONObject();
        obj.put("name", "mkyong.com");
        obj.put("age", 100);
        JSONObject inner = new JSONObject();
        inner.put("city", "New York");
        inner.put("zip", 10500);
        obj.put("address", inner);
        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");
        obj.put("messages", list);
        obj.put("boolean", false);
        obj.put("null", null);
        obj.put("double", 12.23);

        try (FileWriter file = new FileWriter("lessonJSON/src/main/resources/new_data.json")) {
            file.write(obj.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }






    }
}