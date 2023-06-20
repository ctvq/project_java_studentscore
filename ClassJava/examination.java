package src.Manager_Score.ClassJava;

public class examination {
    public int examination_id;
    public String examination_name;
    public String examination_starttime ;
    public String examination_duration;
    public int course_id;

    public examination(int examination_id, String examination_name, String examination_starttime, String examination_duration, int course_id) {
        this.examination_id = examination_id;
        this.examination_name = examination_name;
        this.examination_starttime = examination_starttime;
        this.examination_duration = examination_duration;
        this.course_id = course_id;
    }

    public int getExamination_id() {
        return examination_id;
    }

    public void setExamination_id(int examination_id) {
        this.examination_id = examination_id;
    }

    public String getExamination_name() {
        return examination_name;
    }

    public void setExamination_name(String examination_name) {
        this.examination_name = examination_name;
    }

    public String getExamination_starttime() {
        return examination_starttime;
    }

    public void setExamination_starttime(String examination_starttime) {
        this.examination_starttime = examination_starttime;
    }

    public String getExamination_duration() {
        return examination_duration;
    }

    public void setExamination_duration(String examination_duration) {
        this.examination_duration = examination_duration;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
}
