package sda.lukaszs.jsonls.makejson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MakeJSON {
    //tworzy plik json z obiektu określonej klasy
    public static <T> void makeJSONFile(String filename, T object){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String p1JsonString = mapper.writeValueAsString(object);
            Files.write(Paths.get(filename),p1JsonString.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
