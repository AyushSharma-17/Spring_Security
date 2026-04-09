package Controller;

import java.util.*;

import Model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    
    private  List<Student> students= new ArrayList<>(
        List.of(
            new Student(1,"ayush",50),
            new Student(2,"ayu",40)
        ));
        @GetMapping("/students")
        public List<Student> getStudents(){
            return students;
        }
}
