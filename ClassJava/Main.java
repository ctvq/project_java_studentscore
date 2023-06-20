package src.Manager_Score.ClassJava;

import src.Manager_Score.HandleSQL.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        List<users> userList = new ArrayList<>();
        List<course> coursesList = new ArrayList<>();

        AnswerDAO handle_answer = new AnswerDAO();
        CourseDAO handle_course = new CourseDAO();
        Examination_nn_QuestionDAO handle_exnnqs =new  Examination_nn_QuestionDAO();
        ExaminationDAO handle_examination=new ExaminationDAO();
        QuestionDAO handle_question = new QuestionDAO();
        Users_nn_CourseDAO handle_unnc = new  Users_nn_CourseDAO();
        Users_ReplyDAO handle_ur = new Users_ReplyDAO();
        UsersDAO handle_users = new UsersDAO();

        Random random = new Random();
        List<Integer> answer_idl = new ArrayList<>();
        int random_answer_idl =1;
        List<Integer> course_idl = new ArrayList<>();
        int random_course_idl =1;
        List<Integer> examination_idl = new ArrayList<>();
        int random_examination_idl =1;
        List<Integer> question_idl = new ArrayList<>();
        int random_question_idl =1;
        List<Integer> users_reply_idl = new ArrayList<>();
        int random_users_reply_idl =1;
        List<Integer> users_idl = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int chose = 100;
        int choseloop=0;
        int chosecn = 0;

        while (chose != 0) {
            System.out.println("OPTION FUNCTIONS" +
                    "\n1." + "\"" + "insert" + "\"" + " information into the table " +
                    "\n2." + "\"" + "update" + "\"" + " information into the table " +
                    "\n3." + "\"" + "delete" + "\"" + " information into the table " +
                    "\n0." + "\"" + "stop" + "\"" + " to exist program");
            System.out.print("You select number function :");
            chose = sc.nextInt();sc.nextLine();
            if (chose == 1) {
                int chose1 = 0;
                do {
                    System.out.print(" The table name that you want to insert date is : ");
                    String tableName = sc.nextLine();

                    System.out.println(" Chọn 1 Bạn muốn nhập tự động ( Tự tăng các thông số ) " +
                            "\n  Chọn 2 Thêm dữ liệu cụ thể ");
                    int chose_function = sc.nextInt();
                    sc.nextLine();

                    if (chose_function == 1) {
                        System.out.print("Số dòng mà bạn muốn thêm là :");
                        int numberofline = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Mã bắt đầu là từ :");
                        int id_start = sc.nextInt();
                        for (int i = 0; i < numberofline; i++) {

                            if (tableName.equals("users")) {
                                users users1 = new users((id_start + i), "quyet " + i, "1" + i, (21 + i), "nam " + i, "vu van quyet" + i);
                                userList.add(users1);
                                handle_users.insert(users1);
                                users_idl.add((id_start + i));
                            }
                            int randomu = 1;
                            System.out.println(users_idl.size());
                            if (users_idl.size()<=0) {
                                int random_users_idl = random.nextInt(users_idl.size());
                                randomu = users_idl.get(random_users_idl);
                            }
                            else {}

                            if (tableName.equals("course")) {
                                course course = new course("mon hoc so " + 1, (id_start + i));
                                handle_course.insert(course);
                                course_idl.add(course.getCourse_id());
                            }
                            Integer randomc = 1;

                            if (tableName.equals("examination")) {
                                examination examination = new examination((id_start + i), "ky thi " + (i + 1), "2023-12-24 1" + i + ":30:00", "" + i, 1);
                                handle_examination.insert(examination);
                                examination_idl.add(examination.getExamination_id());
                            }
                            random_examination_idl = random.nextInt(examination_idl.size());
                            Integer randome = examination_idl.get(random_examination_idl);
                            if (tableName.equals("question")) {
                                question question = new question((id_start + i), "1" + "+" + i, 10);
                                handle_question.insert(question);
                                question_idl.add(question.getQuestion_id());
                            }
                            random_question_idl = random.nextInt(question_idl.size());
                            Integer radomq = question_idl.get(random_question_idl);

                            if (tableName.equals("answer")) {
                                answer answer = new answer((id_start + i), "1" + i, "dung", (1 + i));
                                handle_answer.insert(answer);
                                answer_idl.add(answer.getAnswer_id());
                            }
                            if (tableName.equals("users_reply")) {
                                users_reply ur = new users_reply((id_start + i), (1 + i), (1 + i), (1 + i));
                                handle_ur.insert(ur);
                                users_reply_idl.add(ur.getUsers_reply_id());
                            }
                            if (tableName.equals("examination_nn_question")) {
                                examination_nn_question exnnq = new examination_nn_question((id_start + i), (i + 1));
                                handle_exnnqs.insert(exnnq);
                            }
                            if (tableName.equals("users_nn_course")) {
                                if (!course_idl.isEmpty() && !users_idl.isEmpty()) {
                                    users_nn_course unc = new users_nn_course((id_start + i), randomu, randomc);
                                    handle_unnc.insert(unc);
                                }
                            }
                        }
                    }


                    else {
                        if (tableName.equals("users")) {

                            System.out.print("users_id :");
                                int users_id = sc.nextInt();
                                sc.nextLine();
                            System.out.print("users_name :");
                                String users_name = sc.nextLine();
                            System.out.print("users_password :");
                                String users_password = sc.nextLine();
                            System.out.println("users_age :");
                                int users_age = sc.nextInt();
                                sc.nextLine();
                            System.out.println("users_gender :");
                                String users_gender = sc.nextLine();
                            System.out.println("users_fullname :");
                                String users_fullname = sc.nextLine();

                            users users1 = new users(users_id, users_name, users_password, users_age, users_gender, users_fullname);
                            handle_users.insert(users1);
                        }
                        else if (tableName.equals("course")) {
                            System.out.print("course_name :");
                            String course_name = sc.nextLine();
                            System.out.print("course_id :");
                            int course_id = sc.nextInt();
                            course course = new course(course_name,course_id);
                            handle_course.insert(course);
                        }
                        //
                        else if(tableName.equals("answer")){
                            System.out.print("answer_id :");
                            int answer_id = sc.nextInt();sc.nextLine();
                            System.out.print("answer_replycontent :");
                            String answer_replycontent = sc.nextLine();
                            System.out.print("answer_yesno :");
                            String answer_yesno = sc.nextLine();
                            System.out.print("question_id :");
                            int question_id = sc.nextInt();
                            answer answer = new answer(answer_id,answer_replycontent,answer_yesno,question_id);
                            handle_answer.insert(answer);
                        }
                        else if(tableName.equals("examination")){
                            System.out.print("examination_id :");
                            int examination_id = sc.nextInt();sc.nextLine();
                            System.out.print("examination_name :");
                            String examination_name = sc.nextLine();
                            System.out.print("examination_starttime :");
                            String examination_starttime = sc.nextLine();
                            System.out.print("examination_duration :");
                            String examination_duration = sc.nextLine();
                            System.out.print("course_id :");
                            int course_id = sc.nextInt();
                            examination examination = new examination(examination_id,examination_name
                                    , examination_starttime, examination_duration,course_id);
                            handle_examination.insert(examination);

                        }
                        else if(tableName.equals("examination_nn_question")){
                            System.out.print("question_id :");
                            int question_id = sc.nextInt();sc.nextLine();
                            System.out.print("examination_id :");
                            int examination_id = sc.nextInt();
                            examination_nn_question exnnq =new examination_nn_question(question_id,examination_id);
                            handle_exnnqs.insert(exnnq);

                        }
                        else if(tableName.equals("question")){
                            System.out.print("question_id :");
                            int question_id = sc.nextInt();sc.nextLine();
                            System.out.print("question_content :");
                            String question_content = sc.nextLine();
                            System.out.print("question_point :");
                            float question_point = sc.nextFloat();
                            question question = new question(question_id,question_content,question_point);
                            handle_question.insert(question);
                        }
                        else if(tableName.equals("users_nn_course")){
                            System.out.print("users_id_nn_course :");
                            int users_id_nn_course = sc.nextInt();
                            System.out.print("users_id_nn :");
                            int users_id_nn = sc.nextInt();
                            System.out.print("course_id_nn :");
                            int course_id_nn = sc.nextInt();
                            users_nn_course unc = new users_nn_course(users_id_nn_course,users_id_nn,course_id_nn);
                            handle_unnc.insert(unc);
                        }
                        else if(tableName.equals("users_reply")){
                            System.out.print("users_reply_id :");
                            int users_reply_id = sc.nextInt();
                            System.out.print("users_id :");
                            int users_id = sc.nextInt();
                            System.out.print("question_id :");
                            int question_id = sc.nextInt();
                            System.out.print("answer_id :");
                            int answer_id = sc.nextInt();
                            users_reply ur = new users_reply(users_reply_id,users_id,question_id,answer_id);
                            handle_ur.insert(ur);
                        }

                    }
                    System.out.println("Do you want to insert data to another table ? " +
                            "\n Chose 1.Yes            2.No");
                    System.out.print("You select to number function ");
                    chose1 = sc.nextInt();
                    sc.nextLine();
                }while (chose1 == 1);
            }
        }
//
        }
}
