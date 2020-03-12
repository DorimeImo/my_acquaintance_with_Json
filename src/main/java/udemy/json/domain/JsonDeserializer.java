package udemy.json.domain;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class JsonDeserializer extends com.fasterxml.jackson.databind.JsonDeserializer<JsonEntityToSerialize> {
    public JsonEntityToSerialize deserialize(JsonParser jsonParser
            , DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);

        JsonEntityToSerialize entity = new JsonEntityToSerialize();
        try {
        entity.setId(Long.parseLong(node.get("jsonEntityToSerialize id").asText().replace("custom prefix ","")));
        entity.setName(node.get("jsonEntityToSerialize name").asText());
        entity.setDate(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH).parse(node.get("jsonEntityToSerialize date").asText()
                .replace("custom prefix ","")) );
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return entity;
    }
}
