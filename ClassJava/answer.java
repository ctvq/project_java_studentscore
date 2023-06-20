package src.Manager_Score.ClassJava;

public class answer {
    public int answer_id;
    public String answer_replycontent;
    public String answer_yesno;
    public int question_id ;

    public answer(int answer_id, String answer_replycontent, String answer_yesno, int question_id) {
        this.answer_id = answer_id;
        this.answer_replycontent = answer_replycontent;
        this.answer_yesno = answer_yesno;
        this.question_id = question_id;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public String getAnswer_replycontent() {
        return answer_replycontent;
    }

    public void setAnswer_replycontent(String answer_replycontent) {
        this.answer_replycontent = answer_replycontent;
    }

    public String getAnswer_yesno() {
        return answer_yesno;
    }

    public void setAnswer_yesno(String answer_yesno) {
        this.answer_yesno = answer_yesno;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }
}
