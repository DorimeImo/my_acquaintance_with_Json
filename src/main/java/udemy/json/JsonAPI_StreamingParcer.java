package udemy.json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;

public class JsonAPI_StreamingParcer {
    public static void main(String[] args) {

        JsonFactory factory = new JsonFactory();
        try {
            JsonParser parser = factory.createParser(new File("C:\\projects\\json\\theFileYouAreLookingFor.json"));
            while (parser.nextToken()!=null){
                JsonToken token = parser.getCurrentToken();
                System.out.println(token);
            }
            parser.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
