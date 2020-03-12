package udemy.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import udemy.json.domain.UdemyLecture;
import udemy.json.domain.UdemyStudent;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataBindingWrite {

    public static void main(String [] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        UdemyLecture udemyLecture = new UdemyLecture();
        udemyLecture.setId(1);
        udemyLecture.setName("UdemyCourse");
        udemyLecture.setDescription("about JSON properties");
        udemyLecture.setEnabled(true);

        UdemyLecture.UdemyQuestion udemyQuestion = udemyLecture. new UdemyQuestion();
        udemyQuestion. setId(11);
        udemyQuestion.setQuestion("What is nature?");
        udemyQuestion.setAnswer("our home");

        udemyLecture.getListOfQuestions().add(udemyQuestion);
        udemyLecture.setFree_preview(UdemyLecture.FREE_PREVIEW.FREE_PREVIEW_ENABLED);

        try {
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(udemyLecture));
            objectMapper.writeValue(new File("C:\\projects\\json\\theFileYouAreLookingFor.json")
                    ,udemyLecture);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
