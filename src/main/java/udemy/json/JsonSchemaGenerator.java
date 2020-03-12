package udemy.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import udemy.json.domain.UdemySchemaLecture;
import com.github.fge.jsonschema.main.JsonSchema;

import java.io.File;
import java.io.IOException;

public class JsonSchemaGenerator {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        //GENERATE
        SchemaFactoryWrapper wrapper = new SchemaFactoryWrapper();
//        try {
//            //creating schema out of UdemySchemaLecture.class
//            objectMapper.acceptJsonFormatVisitor(objectMapper.constructType(UdemySchemaLecture.class), wrapper);
//            JsonSchema schema = wrapper.finalSchema();
//
//            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema));
//            objectMapper.writerWithDefaultPrettyPrinter()
//                    .writeValue(new File("C:\\projects\\json\\theFileYouAreLookingFor.json"),schema);
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        }

        //VALIDATE
        UdemySchemaLecture lecture = new UdemySchemaLecture();
        lecture.setId(1);
        lecture.setName("Schema to Validate");
        lecture.setDescription("The same as the name");
        lecture.setEnabled(true);

        objectMapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("C:\\projects\\json\\theFileYouAreLookingFor.json"),lecture);

        JsonNode rootSchema = objectMapper
                .readTree(new File ("C:\\projects\\json\\theFileYouAreLookingFor.json"));

        JsonSchemaFactory factory = JsonSchemaFactory.newBuilder().freeze();
        try {
            JsonSchema schema = factory.getJsonSchema(rootSchema);
        } catch (ProcessingException e) {
            e.printStackTrace();
        }
    }
}
