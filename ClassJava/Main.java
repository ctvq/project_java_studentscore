package src.Manager_Score.ClassJava;

import src.Manager_Score.HandleSQL.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        AnswerDAO handle_answer = new AnswerDAO();
        CourseDAO handle_course = new CourseDAO();
        Examination_nn_QuestionDAO handle_exnnqs = new Examination_nn_QuestionDAO();
        ExaminationDAO handle_examination = new ExaminationDAO();
        QuestionDAO handle_question = new QuestionDAO();
        Users_nn_CourseDAO handle_unnc = new Users_nn_CourseDAO();
        Users_ReplyDAO handle_ur = new Users_ReplyDAO();
        UsersDAO handle_users = new UsersDAO();

        Random random = new Random();
        List<Integer> answer_idl = new ArrayList<>();
        List<Integer> course_idl = new ArrayList<>();
        List<Integer> examination_idl = new ArrayList<>();
        List<Integer> question_idl = new ArrayList<>();
        List<Integer> users_idl = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int chose = 100;
        int numberofline = 0;
        int increase_value = 1;

        int randomu = 1;
        int randomc = 1;
        int randome = 1;
        int randomq = 1;
        int randoma = 1;
        int i11 = 0;
        int a[] = new int[1000];
        int b[] = new int[1000];
        int c[] = new int[1000];
        int id_q[] = new int[1000];
        int nuberUsers = 0;
        int numberQuestion = 0;
        int x = 0, y = 0;
        int[][] arrays = new int[x][y];
        int dt = 0;
        while (chose != 0) {
            try {
                System.out.println("OPTION FUNCTIONS" +
                        "\n1." + "\"" + "insert" + "\"" + " information into the table " +
                        "\n2." + "\"" + "update" + "\"" + " information into the table " +
                        "\n3." + "\"" + "delete" + "\"" + " information into the table " +
                        "\n0." + "\"" + "stop" + "\"" + " to exist program");
                System.out.print("You select number function :");
                if (dt != 0) sc.nextLine();
                dt++;
                chose = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Lỗi cú pháp: ");
            }
            if (chose == 1) {
                int chose1 = 0;
                try {
                    do {
                        int chose_function = 0;
                        String tableName = "";


                        System.out.print(" The table name that you want to insert date is : ");
                        tableName = sc.nextLine();

                        System.out.println(" Chọn 1 Bạn muốn nhập tự động ( Tự tăng các thông số ) " +
                                "\n  Chọn 2 Thêm dữ liệu cụ thể ");
                        chose_function = sc.nextInt();
                        sc.nextLine();
                        if (chose_function == 1) {
                            if (tableName.equals("answer") == false && tableName.equals("users_reply") == false) {
                                System.out.print("Số dòng mà bạn muốn thêm là :");
                                numberofline = sc.nextInt();
                                sc.nextLine();
                            } else numberofline = 1;
                            System.out.print("Mã bắt đầu là từ :");
                            int id_start = sc.nextInt();
                            for (int i = 0; i < numberofline; i++) {

                                if (tableName.equals("users")) {
                                    List<String> gender = new ArrayList<>();
                                    gender.add("nam");
                                    gender.add("nữ");
                                    int s = random.nextInt(gender.size());
                                    String gender_rd = gender.get(s);
                                    int users_id = id_start + i;
                                    users users1 = new users(users_id, "quyet " + i, "1" + i, (21 + i), gender_rd, "vu van quyet" + i);
                                    handle_users.insert(users1);
                                    users_idl.add(users_id);
                                }

                                if (tableName.equals("course")) {
                                    course course = new course("mon hoc so " + 1, (id_start + i));
                                    handle_course.insert(course);
                                    course_idl.add(course.getCourse_id());
                                }
                                if (tableName.equals("examination")) {
                                    examination examination = new examination((id_start + i), "ky thi " + (i + 1), "2023-12-24 1" + i + ":30:00", "" + i, randomc);
                                    handle_examination.insert(examination);
                                    examination_idl.add(examination.getExamination_id());
                                }
                                if (!examination_idl.isEmpty()) {
                                    int random_e_index = random.nextInt(examination_idl.size());
                                    randome = examination_idl.get(random_e_index);
                                }

                                if (tableName.equals("question")) {
                                    question question = new question((id_start + i), "1" + "+" + i, 10);
                                    handle_question.insert(question);
                                    question_idl.add(question.getQuestion_id());
                                }

                                x = question_idl.size(); // Số lần lặp của vòng 1
                                y = 4; // Số lần lặp của vòng 2
                                String rd_vl = "";

                                if (tableName.equals("answer")) {
                                    arrays = new int[x][y];
                                    for (int idqr : question_idl) {
                                        //moi mã đó sẽ có 4 câu hỏi được thêm và chỉ có 1 đáp án đúng
                                        List<String> a1 = new ArrayList<>();
                                        a1.add("dung");
                                        a1.add("sai");
                                        int demrs = 0, demvl = 0;

                                        for (int j = 0; j < 4; j++) {
                                            // for
                                            int a11 = random.nextInt(a1.size());
                                            rd_vl = a1.get(a11);
                                            if (rd_vl.equals("dung") && demvl == 0) {
                                                answer answer = new answer((id_start + increase_value - 1), "1" + increase_value, "dung", idqr);
                                                handle_answer.insert(answer);
                                                answer_idl.add(answer.getAnswer_id());
                                                demvl++;
                                                arrays[i11][j] = id_start + increase_value - 1;
                                                increase_value++;
                                                continue;
                                            } else {
                                                answer answer = new answer((id_start + increase_value - 1), "1" + increase_value, "sai", idqr);
                                                handle_answer.insert(answer);
                                                answer_idl.add(answer.getAnswer_id());
                                                arrays[i11][j] = id_start + increase_value - 1;

                                                increase_value++;
                                                demrs++;
                                            }
                                            if (demrs == 3 && demvl == 0) {
                                                answer answer = new answer((id_start + increase_value - 1), "1" + increase_value, "dung", idqr);
                                                handle_answer.insert(answer);
                                                arrays[i11][j] = id_start + increase_value - 1;
                                                increase_value++;
                                                answer_idl.add(answer.getAnswer_id());
                                                break;
                                            }
                                        }
                                        i11++;
                                    }
                                }


                                if (!answer_idl.isEmpty()) {
                                    int random_a_index = random.nextInt(answer_idl.size());
                                    randoma = answer_idl.get(random_a_index);
                                }
                                // câu trả lời mỗi thí sinh phải trả lời 10 câu hỏi mỗi câu có 1 đáp án tương ứng
                                if (tableName.equals("users_reply")) {
                                    // Duyệt qua từng hàng
                                    for (int i1 = 0; i1 < 10; i1++) {
                                        // Duyệt qua từng cột trong hàng i
                                        for (int j1 = 0; j1 < 4; j1++) {
                                            System.out.print(arrays[i1][j1] + " ");
                                        }
                                        System.out.println(); // Xuống dòng sau khi in hết cột trong hàng i
                                    }
                                    // sử lý sao cho các chuỗi random không trùng nhau

                                    for (int usersl : users_idl) {
                                        int i2 = 0;
                                        for (int qsl : question_idl) {
                                            if (!users_idl.isEmpty() && !question_idl.isEmpty() && !answer_idl.isEmpty()) {
                                                int randomIndex = random.nextInt(arrays[i2].length);
                                                int randomElement = arrays[i2][randomIndex];
                                                users_reply ur = new users_reply((id_start + increase_value), usersl, qsl, randomElement);
                                                increase_value++;
                                                handle_ur.insert(ur);
                                            }
                                            i2++;

                                        }
                                    }
                                    if (tableName.equals("users_reply")) break;
                                }
                                if (tableName.equals("examination_nn_question")) {
                                    // sử lý sao cho các chuỗi random không trùng nhau
                                    System.out.println(numberofline);
                                    if (!examination_idl.isEmpty()) {
                                        int random_e_idl = random.nextInt(examination_idl.size());
                                        randome = examination_idl.get(random_e_idl);
                                        a[i] = randome;
                                    }
                                    if (!question_idl.isEmpty()) {
                                        int random_q_index = random.nextInt(question_idl.size());
                                        randomq = question_idl.get(random_q_index);
                                        b[i] = randomq;
                                    }
                                    System.out.println(b[i] + "-" + a[i]);

                                    if (i == 0) {
                                        if (!examination_idl.isEmpty() && !question_idl.isEmpty()) {
                                            examination_nn_question unc = new examination_nn_question(randomq, randome);
                                            handle_exnnqs.insert(unc);
                                        }
                                    } else {
                                        int dem = 0;
                                        for (int j = i - 1; j >= 0; j--) {
                                            if (i > 0) {
                                                if (a[i] != a[j] || b[i] != b[j]) {
                                                    dem++;
                                                } else {
                                                    System.out.print("số random bị trùng lặp");
                                                    break;
                                                }
                                                if (dem == i) {
                                                    if (!examination_idl.isEmpty() && !question_idl.isEmpty()) {
                                                        examination_nn_question exnnq = new examination_nn_question(randomq, randome);
                                                        handle_exnnqs.insert(exnnq);
                                                    }
                                                } else {
                                                }
                                            }
                                        }
                                    }
                                }
                                if (tableName.equals("users_nn_course")) {
                                    // sử lý sao cho các chuỗi random không trùng nhau
                                    System.out.println(numberofline);
                                    if (!users_idl.isEmpty()) {
                                        int random_users_idl = random.nextInt(users_idl.size());
                                        randomu = users_idl.get(random_users_idl);
                                        a[i] = randomu;
                                    }
                                    if (!course_idl.isEmpty()) {
                                        int random_c_index = random.nextInt(course_idl.size());
                                        randomc = course_idl.get(random_c_index);
                                        b[i] = randomc;
                                    }
                                    System.out.println(a[i] + "-" + b[i]);
                                    if (i == 0) {
                                        if (!course_idl.isEmpty() && !users_idl.isEmpty()) {
                                            users_nn_course unc = new users_nn_course((id_start + i), randomu, randomc);
                                            handle_unnc.insert(unc);
                                        }
                                    } else {
                                        int dem = 0;
                                        for (int j = i - 1; j >= 0; j--) {
                                            if (i > 0) {
                                                if (a[i] != a[j] || b[i] != b[j]) {
                                                    dem++;
                                                } else {
                                                    System.out.print("số random bị trùng lặp");
                                                    break;
                                                }
                                                if (dem == i) {
                                                    if (!users_idl.isEmpty() && !course_idl.isEmpty()) {
                                                        users_nn_course unc = new users_nn_course(id_start + increase_value, randomu, randomc);
                                                        handle_unnc.insert(unc);
                                                        increase_value++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            //
                        } else {
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
                                users_idl.add(users_id);
                            } else if (tableName.equals("course")) {
                                System.out.print("course_name :");
                                String course_name = sc.nextLine();
                                System.out.print("course_id :");
                                int course_id = sc.nextInt();
                                course course = new course(course_name, course_id);
                                handle_course.insert(course);
                                course_idl.add(course_id);
                            }
                            //
                            else if (tableName.equals("answer")) {
                                System.out.print("answer_id :");
                                int answer_id = sc.nextInt();
                                sc.nextLine();
                                System.out.print("answer_replycontent :");
                                String answer_replycontent = sc.nextLine();
                                System.out.print("answer_yesno :");
                                String answer_yesno = sc.nextLine();
                                System.out.print("question_id :");
                                int question_id = sc.nextInt();

                                answer answer = new answer(answer_id, answer_replycontent, answer_yesno, question_id);
                                handle_answer.insert(answer);
                                question_idl.add(question_id);
                            } else if (tableName.equals("examination")) {
                                System.out.print("examination_id :");
                                int examination_id = sc.nextInt();
                                sc.nextLine();
                                System.out.print("examination_name :");
                                String examination_name = sc.nextLine();
                                System.out.print("examination_starttime :");
                                String examination_starttime = sc.nextLine();
                                System.out.print("examination_duration :");
                                String examination_duration = sc.nextLine();
                                System.out.print("course_id :");
                                int course_id = sc.nextInt();
                                examination examination = new examination(examination_id, examination_name
                                        , examination_starttime, examination_duration, course_id);
                                handle_examination.insert(examination);
                                examination_idl.add(examination_id);

                            } else if (tableName.equals("question")) {
                                System.out.print("question_id :");
                                int question_id = sc.nextInt();
                                sc.nextLine();
                                System.out.print("question_content :");
                                String question_content = sc.nextLine();
                                System.out.print("question_point :");
                                float question_point = sc.nextFloat();
                                question question = new question(question_id, question_content, question_point);
                                handle_question.insert(question);
                                question_idl.add(question_id);
                            } else if (tableName.equals("examination_nn_question")) {
                                System.out.print("question_id :");
                                int question_id = sc.nextInt();
                                sc.nextLine();
                                System.out.print("examination_id :");
                                int examination_id = sc.nextInt();
                                examination_nn_question exnnq = new examination_nn_question(question_id, examination_id);
                                handle_exnnqs.insert(exnnq);
                            } else if (tableName.equals("users_nn_course")) {
                                System.out.print("users_id_nn_course :");
                                int users_id_nn_course = sc.nextInt();
                                System.out.print("users_id_nn :");
                                int users_id_nn = sc.nextInt();
                                System.out.print("course_id_nn :");
                                int course_id_nn = sc.nextInt();
                                users_nn_course unc = new users_nn_course(users_id_nn_course, users_id_nn, course_id_nn);
                                handle_unnc.insert(unc);
                            } else if (tableName.equals("users_reply")) {
                                System.out.print("users_reply_id :");
                                int users_reply_id = sc.nextInt();
                                System.out.print("users_id :");
                                int users_id = sc.nextInt();
                                System.out.print("question_id :");
                                int question_id = sc.nextInt();
                                System.out.print("answer_id :");
                                int answer_id = sc.nextInt();
                                users_reply ur = new users_reply(users_reply_id, users_id, question_id, answer_id);
                                handle_ur.insert(ur);
                            }
                        }
                        System.out.println("Do you want to insert data to another table ? " +
                                "\n Chose 1.Yes            2.No");
                        System.out.print("You select to number function ");
                        chose1 = sc.nextInt();
                        sc.nextLine();
                    } while (chose1 == 1);
                } catch (InputMismatchException e) {
                    System.out.print(e.getMessage());
                }

            }

        }
    }
}
