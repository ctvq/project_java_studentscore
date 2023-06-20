package src.Manager_Score.ClassJava;

public class examination_nn_question {
    public int question_id;
    public int examination_id;

    public examination_nn_question(int question_id, int examination_id) {
        this.question_id = question_id;
        this.examination_id = examination_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getExamination_id() {
        return examination_id;
    }

    public void setExamination_id(int examination_id) {
        this.examination_id = examination_id;
    }
}
