package src.Manager_Score.ClassJava;

public class users_nn_course {
   public int users_id_nn_course;
   public int users_id_nn;
   public int course_id_nn;

    public users_nn_course(int users_id_nn_course, int users_id_nn, int course_id_nn) {
        this.users_id_nn_course = users_id_nn_course;
        this.users_id_nn = users_id_nn;
        this.course_id_nn = course_id_nn;
    }

    public int getUsers_id_nn_course() {
        return users_id_nn_course;
    }

    public void setUsers_id_nn_course(int users_id_nn_course) {
        this.users_id_nn_course = users_id_nn_course;
    }

    public int getUsers_id_nn() {
        return users_id_nn;
    }
    public void setUsers_id_nn(int users_id_nn) {
        this.users_id_nn = users_id_nn;
    }
    public int getCourse_id_nn() {
        return course_id_nn;
    }

    public void setCourse_id_nn(int course_id_nn) {
        this.course_id_nn = course_id_nn;
    }
}
