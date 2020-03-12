package udemy.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import udemy.json.domain.UdemyStudent;

import java.io.File;
import java.io.IOException;

public class TreeModelRead {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode= objectMapper
                    .readTree(new File("C:\\projects\\json\\theFileYouAreLookingFor.json"));
            System.out.println(jsonNode.get("id").asText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
