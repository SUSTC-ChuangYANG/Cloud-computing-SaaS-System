package springboot.login;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.login.controller.TeacherController;
import springboot.login.dao.*;
import springboot.login.domain.*;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class databaseTest {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private AdminRepository adminRepository;



//    public List<Student> getCourseStudent(Course course){
//
//    }

    public Teacher addTeacher(String name, String password,String email, String phone_num){
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setPassword(password);
        teacher.setPhone_num(phone_num);
        teacher.setEmail(email);
        return teacher;
    }

    public Course addCourse(String name, int size, String course_code){
        Course course = new Course();
        course.setName(name);
        course.setCourse_code(course_code);
        course.setSize(size);
        return course;
    }

    public Teacher queryTeacherByCourse(Course c){
        return c.getTeacher();
    }


    @Test
    public void addStudent(){
        Student student = new Student();
        student.setName("YangChuang");
        student.setEmail("11510080@mail.sustc.edu.cn");
        student.setPhone_num("18126237321");
        student.setSid(11510080);
        student.setId(1);
        student.setPassword("123456789");

        studentRepository.save(student);

    }


//    @Test
//    public void alterStudent(long id){
//        id = 1;
//        studentRepository.findById(id);
//    }


    public void createTeacher(){
        Teacher t1 = addTeacher("zhangsan","123456789","zhangsan@gmail.com","18126217321");
        Teacher t2 = addTeacher("lisi","123456789","lisi@gmail.com","181262173212");
        Teacher t3 = addTeacher("wangmazi","123456789","wangmazi@gmail.com","18126217323");
        Teacher t4 = addTeacher("Bob","123456789","Bob@gmail.com","18126217324");
        Teacher t5 = addTeacher("John","123456789","John@gmail.com","18126217325");
        Teacher t6 = addTeacher("Lisa","123456789","Lisa@gmail.com","18126217326");
        teacherRepository.save(t1);
        teacherRepository.save(t2);
        teacherRepository.save(t3);
        teacherRepository.save(t4);
        teacherRepository.save(t5);
        teacherRepository.save(t6);

    }


    public void creatCourse(){
        Course c1 = addCourse("Operation System",100,"CS302");
        Course c2 = addCourse("Cloud Computing",50,"CS306");
        Course c3 = addCourse("Data Structure and Algorithms Analysis",50,"CS203");
        Teacher t1 = teacherRepository.findById(1);
        Teacher t2 = teacherRepository.findById(2);
        c1.setTeacher(t1);
        c2.setTeacher(t2);
        c3.setTeacher(t1);
        courseRepository.save(c1);
        courseRepository.save(c2);
        courseRepository.save(c3);
        t1.getCourseList().add(c1);
        t1.getCourseList().add(c3);
        t2.getCourseList().add(c2);
        teacherRepository.save(t1);
        teacherRepository.save(t2);

    }



    @Test
    public void queryTeacherUseCourse(){
        Course c1 = courseRepository.findById(1);
        System.out.println(c1.getTeacher().getName());
//        teacherRepository.findById(c1.getTeacher().getId())

    }

    @Test
    public void addTeacherCourse(){
        Teacher t1 = teacherRepository.findById(1);
//        TeacherController t2 = teacherRepository.findById(2);
        Course c3 = addCourse("Data Structure and Algorithms Analysis",50,"CS203");
        c3.setTeacher(t1);

        courseRepository.save(c3);
//        Course c1= courseRepository.findById(1);
//        Course c2= courseRepository.findById(2);
//        c3.setTeacher(t1);
//       t1.getCourseList().add(c3);
//        t1.getCourseList().add(c1);
//        t2.getCourseList().add(c2);

    }

//    @Test
//    public void myDouble(){
//        TeacherController t1 = teacherRepository.findById(1);
//        Course c4 = addCourse("Data Structure and Algorithms Analysis",50,"CS203");
//        c4.setId(5);
//        c4.setTeacher(t1);
//        int i=800;
//        Student student = new Student();
//        String name = "student"+(i+1);
//        String email = (11510000+i)+"@mail.sustc.edu.cn";
//        String phone_num = "1812600"+(1000+i);
//        String password = "1151"+(i*i+10000);
//        student.setName(name);
//        student.setSid(11510000+i);
//        student.setEmail(email);
//        student.setPhone_num(phone_num);
//        student.setPassword(password);
//        student.setId(i);
//        StudentCourse sc = new StudentCourse();
//        sc.setStudent(student);
//        sc.setCourse(c4);
//        studentCourseRepository.save(sc);
//
//
//
////        TeacherController t7 = addTeacher("Lisaa","123456789","Lisaa@gmail.com","18126217327");
////        t7.setId(10000);
//
//    }

    @Test
    public void testpk(){

       /* TeacherController t1 = addTeacher("zhangsan","123456789","zhangsan@gmail.com","18126217321");
        teacherRepository.save(t1);

        Course c1 = addCourse("Operation System",100,"CS302");

        c1.setTeacher(t1);

        courseRepository.save(c1);*/
        int i=8;

        Student student = new Student();
        String name = "student"+(i+1);
        String email = (11510000+i)+"@mail.sustc.edu.cn";
        String phone_num = "1812600"+(1000+i);
        String password = "1151"+(i*i+10000);
        student.setName(name);
        student.setSid(11510000+i);
        student.setEmail(email);
        student.setPhone_num(phone_num);
        student.setPassword(password);
        student.setId(i);
        studentRepository.save(student);

    }

    @Test
    public void testkkk(){
//        Student s= studentRepository.findById(10);
//        Course c = courseRepository.findById(1);
//        StudentCoursePk pk =new StudentCoursePk(3,1);
//        Score score = new Score(pk);
//        score.setScore(80);
//        scoreRepository.save(score);
        List<Score> scoreList = scoreRepository.findByPkCourseId(1);
        Student s = scoreList.get(0).getStudent();
        s.setName("chuang");
        studentRepository.save(s);
//        System.out.println(scoreList.get(0).getStudent().setName());
//        System.out.println(scoreList.get(1).getStudent().getName());

    }

    @Test
    public void creatStudent(){
        for(int i = 1;i<100;i++){
            Student student = new Student();
            String name = "student"+(i+1);
            String email = (11510000+i)+"@mail.sustc.edu.cn";
            String phone_num = "1812600"+(1000+i);
            String password = "1151"+(i*i+10000);
            student.setName(name);
            student.setSid(11510000+i);
            student.setEmail(email);
            student.setPhone_num(phone_num);
            student.setPassword(password);
            student.setId(i);
            studentRepository.save(student);

        }
    }


//    @Test
//    public void autoCombinStudentCourse(){
//        Course c1 = courseRepository.findById(1);
////        Course c2 = courseRepository.findById(2);
////        Course c3 = courseRepository.findById(3);
//        for(int i = 1;i<100;i++){
//            Student student = studentRepository.findById(i);
//            StudentCourse sc = new StudentCourse();
//            sc.setStudent(student);
//            sc.setCourse(c1);
//            studentCourseRepository.save(sc);
//        }
//    }

    @Test
    public void queryTeachersCourse(){
        Teacher t1 = teacherRepository.findById(1);
        Teacher t2 = teacherRepository.findById(2);
        List<Course> courseList = t1.getCourseList();
        System.out.println(courseList.size());
        for( Course c:courseList){
            System.out.println(c.getName());


        }
    }



    public void combineStudentWithCourse(){
//        TeacherController t1 = addTeacher("zhangsan","123456789","zhangsan@gmail.com","18126217321");
//        TeacherController t2 = addTeacher("lisi","123456789","lisi@gmail.com","181262173212");
//        TeacherController t3 = addTeacher("wangmazi","123456789","wangmazi@gmail.com","18126217323");
//        TeacherController t4 = addTeacher("Bob","123456789","Bob@gmail.com","18126217324");
//        TeacherController t5 = addTeacher("John","123456789","John@gmail.com","18126217325");
//        TeacherController t6 = addTeacher("Lisa","123456789","Lisa@gmail.com","18126217326");
////
////
//        Course c1 = addCourse("Operation System",100,"CS302");
//        Course c2 = addCourse("Cloud Computing",50,"CS306");
//        Course c3 = addCourse("Data Structure and Algorithms Analysis",50,"CS203");
////        t1.getCourseList().add(c1);
////        t1.getCourseList().add(c1);
////        t2.getCourseList().add(c2);
//        teacherRepository.save(t1);
//        teacherRepository.save(t2);
//        teacherRepository.save(t3);
//        teacherRepository.save(t4);
//        teacherRepository.save(t5);
//        teacherRepository.save(t6);
//        c1.setTeacher(t1);
//        c2.setTeacher(t2);
//        c3.setTeacher(t1);
//
//        courseRepository.save(c1);
//        courseRepository.save(c2);
//        courseRepository.save(c3);
//
//
//

        Course c1 = courseRepository.findById(1);
        Course c2 = courseRepository.findById(2);
        Course c3 = courseRepository.findById(3);
        for(int i = 1;i<100;i++){
            Student student = new Student();
            String name = "student"+(i+1);
            String email = (11510000+i)+"@mail.sustc.edu.cn";
            String phone_num = "1812600"+(1000+i);
            String password = "1151"+(i*i+10000);
            student.setName(name);
            student.setSid(11510000+i);
            student.setEmail(email);
            student.setPhone_num(phone_num);
            student.setPassword(password);
            student.setId(i);
            studentRepository.save(student);




            if(i<33){
                StudentCoursePk pk =new StudentCoursePk(student.getId(),c1.getId());
                Score score1 = new Score(pk);
                score1.setScore((int) (Math.random() * 100) );
                scoreRepository.save(score1);
                StudentCoursePk pk1 =new StudentCoursePk(student.getId(),c2.getId());
                Score score2 = new Score(pk1);
                score2.setScore((int) (Math.random() * 100) );
                scoreRepository.save(score2);
            }
            else if(i>=33&&i<=66){
                StudentCoursePk pk =new StudentCoursePk(student.getId(),c2.getId());
                Score score1 = new Score(pk);
                score1.setScore((int) (Math.random() * 100) );
                scoreRepository.save(score1);
                StudentCoursePk pk1 =new StudentCoursePk(student.getId(),c3.getId());
                Score score2 = new Score(pk1);
                score2.setScore((int) (Math.random() * 100) );
                scoreRepository.save(score2);
            }else{
                StudentCoursePk pk =new StudentCoursePk(student.getId(),c1.getId());
                Score score1 = new Score(pk);
                score1.setScore((int) (Math.random() * 100) );
                scoreRepository.save(score1);
                StudentCoursePk pk1 =new StudentCoursePk(student.getId(),c3.getId());
                Score score2 = new Score(pk1);
                score2.setScore((int) (Math.random() * 100) );
                scoreRepository.save(score2);
            }



//            System.out.println(name+ " "+email+" "+phone_num+" "+password);
//            student.setName("name");
        }
    }

    @Test
    public void queryTeachersStudent(){
        Teacher t1 = teacherRepository.findById(1);

        List<Course> courseList = t1.getCourseList();
        System.out.println(courseList.size());
        for( Course c:courseList){

            List<Score> scoreList = scoreRepository.findByPkCourseId(c.getId());
            for(Score s :scoreList){
                System.out.println(s.getStudent().toString()+" "+s.getScore());
            }


        }

    }

    @Test
    public void createStudent(){

    }

    @Test
    public void createAdmin(){
        Admin admin = new Admin();
        admin.setEmail("admin1@sustc.edu.cn");
        admin.setPassword("123456789");
        admin.setName("superAdmin");
        adminRepository.save(admin);
    }

    @Test
    public void createTestData(){
        createAdmin();
        createTeacher();
        creatCourse();
        combineStudentWithCourse();
    }




}
