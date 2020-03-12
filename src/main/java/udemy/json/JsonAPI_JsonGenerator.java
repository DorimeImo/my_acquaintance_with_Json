package udemy.json;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import udemy.json.domain.UdemyStudent;

import java.io.File;
import java.io.IOException;

public class JsonAPI_JsonGenerator {
    public static void main(String[] args) {
        try {

        ObjectMapper objectMapper = new ObjectMapper();

        JsonFactory jsonFactory = new JsonFactory();
        JsonGenerator jsonGenerator = jsonFactory
                .createGenerator(new File("C:\\projects\\json\\theFileYouAreLookingFor.json"), JsonEncoding.UTF8); //place to write
        jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
        jsonGenerator.setCodec(objectMapper);

        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("name");
        jsonGenerator.writeString("Diam");

            UdemyStudent student = new UdemyStudent();
            student.setName("Dimm");
            student.setLastname("HJil");

        jsonGenerator.writeFieldName("object");
        jsonGenerator.writeObject(student);

        jsonGenerator.writeEndObject();
        jsonGenerator.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
