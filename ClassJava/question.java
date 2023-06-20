package src.Manager_Score.ClassJava;

public class question {
    public int question_id;
    public String question_content;
    public float question_point;

    public int getQuestion_id() {
        return question_id;
    }
    public question(int question_id, String question_content, float question_point) {
        this.question_id = question_id;
        this.question_content = question_content;
        this.question_point = question_point;
    }
    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public void setQuestion_content(String question_content) {
        this.question_content = question_content;
    }

    public float getQuestion_point() {
        return question_point;
    }

    public void setQuestion_point(float question_point) {
        this.question_point = question_point;
    }


}
