package sda.lukaszs.jsonls.readjson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadJSON {
    public static <T> T makeObjectFromJSON(File file, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        T output = null;
        try {
            output = mapper.readValue(file, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    //tworzy listę obiektów z dowolnego json'a o określonej klasie
    public static <T> List<T> makeObjectListFromJSON(File file, Class<T[]> clazz){
        ObjectMapper mapper = new ObjectMapper();
        List<T> output = new ArrayList<>();
        T[] outArray;
        try {
            outArray = mapper.readValue(file,clazz);
            output = Arrays.asList(outArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }
}
