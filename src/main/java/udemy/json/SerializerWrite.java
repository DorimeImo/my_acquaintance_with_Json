package udemy.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import udemy.json.domain.JsonEntityToSerialize;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class SerializerWrite {
    public static void main(String[] args) {
        JsonEntityToSerialize entity = new JsonEntityToSerialize();
        entity.setId(1);
        entity.setName("First");
        entity.setDate(new Date());

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(entity));
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File("C:\\projects\\json\\theFileYouAreLookingFor.json"), entity);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            JsonEntityToSerialize entity1 = objectMapper.readValue(new File("C:\\projects\\json\\theFileYouAreLookingFor.json")
                    , JsonEntityToSerialize.class);

            System.out.println("entity1 "+ entity1.getId()+" !!!!!!!!!!!!!!!!!");
            System.out.println(entity1.getName());
            System.out.println(entity1.getDate());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
