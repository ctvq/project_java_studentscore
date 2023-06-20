package src.Manager_Score.ClassJava;

public class users_reply {
    public int users_reply_id;
    public int users_id;
    public int question_id;
    public int answer_id;

    public users_reply(int users_reply_id, int users_id, int question_id, int answer_id) {
        this.users_reply_id = users_reply_id;
        this.users_id = users_id;
        this.question_id = question_id;
        this.answer_id = answer_id;
    }

    public int getUsers_reply_id() {
        return users_reply_id;
    }

    public void setUsers_reply_id(int users_reply_id) {
        this.users_reply_id = users_reply_id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }
}
