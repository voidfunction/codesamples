package my.sample.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.util.*;

/**
 * Created by ltian on 6/3/2017.
 */
public class MyObjectMapper {
    private static JsonFactory jsonFactory = new JsonFactory();
    private static ObjectMapper objectMapper = new ObjectMapper(jsonFactory);
    private static XmlMapper xmlMapper = new XmlMapper();
    //List<Application> apps =
    // objectMapper.readValue(json, TypeFactory.defaultInstance().constructType(List.class, Application.class));
    public static  <T> Optional<T> convertJsonToObject(String str, Class<T> tClass) {
        try {
            return Optional.ofNullable(objectMapper.readValue(str, tClass));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static <T> String convertObjectToString(Class<T> tClass) {
//        String res = objectMapper.writeValueAsString();
        return "a";
    }


    public static void main(String[] args) {
        Map<String, String> maps = new HashMap<>();
        maps.put("abc", "def");
        try {
            List<MyObject> myObjectList = new ArrayList<>();
            myObjectList.add(new MyObject("a1","def"));
            myObjectList.add(new MyObject("a2","def"));
            MyObjectContainer container = new MyObjectContainer();
            container.setMyApps(myObjectList);
            container.getMyApps().addAll(myObjectList);
            String res = objectMapper.writeValueAsString(container);
            int a = 1;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static <T> Optional<T> convertXmlToObject(String url, Class<T> tClass) {
        T info = null;
        try {
            info = xmlMapper.readValue(url, tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(info);
    }
}
