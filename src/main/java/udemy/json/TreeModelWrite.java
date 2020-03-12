package udemy.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TreeModelWrite {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode= objectMapper
                    .readTree(new File("C:\\projects\\json\\theFileYouAreLookingFor.json"));
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
