package udemy.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import udemy.json.domain.UdemyStudent;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class DataBindingRead {
    public static void main(String [] args){
        ObjectMapper objectMapper = new ObjectMapper();

        String udemyStudentString = "{"+
            "\"id\" : 1,"+
            "\"name\" : \"Dimos\","+
            "\"lastname\" : \"Baranyos\""+
        "}";

        try {
            Map<String, Object> mapJson= objectMapper.readValue(new File("C:\\projects\\json\\theFileYouAreLookingFor.json"),
                    new TypeReference<Map<String,Object>>() {
                    }
            );
            System.out.println(mapJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
