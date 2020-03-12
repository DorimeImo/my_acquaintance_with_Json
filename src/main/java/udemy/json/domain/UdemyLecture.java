package udemy.json.domain;


import java.util.ArrayList;
import java.util.List;

public class UdemyLecture {
    private long id;
    private String name;

    private String description;
    private boolean enabled;
    private FREE_PREVIEW free_preview;

    public class UdemyQuestion{
        private long id;
        private String question;
        private String answer;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }
    }
    public enum FREE_PREVIEW {FREE_PREVIEW_ENABLED, FREE_PREVIEW_NOT_ENABLED};

    public List<UdemyQuestion> listOfQuestions = new ArrayList<UdemyQuestion>();

    public List<UdemyQuestion> getListOfQuestions() {
        return listOfQuestions;
    }

    public void setListOfQuestions(List<UdemyQuestion> listOfQuestions) {
        this.listOfQuestions = listOfQuestions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public FREE_PREVIEW getFree_preview() {
        return free_preview;
    }

    public void setFree_preview(FREE_PREVIEW free_preview) {
        this.free_preview = free_preview;
    }
}
