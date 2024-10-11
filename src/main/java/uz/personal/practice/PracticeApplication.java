package uz.personal.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import uz.personal.practice.service.StudentService;

@SpringBootApplication
@EnableScheduling
public class PracticeApplication implements CommandLineRunner {

    @Autowired
    StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(PracticeApplication.class, args);
    }

    @Override
    public void run(String... args) {
//        studentService.checkStudentExistsInDTM();
//        studentService.checkStudentExistsInDTM2();
//        studentService.updateStudentHemis();
//        studentService.saveStudentHemis();
        studentService.checkStudentFoundInOrphan();
    }
}
