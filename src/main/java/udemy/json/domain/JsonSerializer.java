package udemy.json.domain;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class JsonSerializer extends com.fasterxml.jackson.databind.JsonSerializer<JsonEntityToSerialize> {

    public void serialize(JsonEntityToSerialize jsonEntityToSerialize
            , JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
        jsonGenerator.writeStartObject();

        jsonGenerator.writeFieldName("custom serialize");
        jsonGenerator.writeString("udemy json");
        jsonGenerator.writeStringField("jsonEntityToSerialize id", "custom prefix " + jsonEntityToSerialize.getId());
        jsonGenerator.writeStringField("jsonEntityToSerialize name", "custom prefix " + jsonEntityToSerialize.getName());
        jsonGenerator.writeStringField("jsonEntityToSerialize date", "custom prefix " + jsonEntityToSerialize.getDate());
        jsonGenerator.writeEndObject();


    }
}
