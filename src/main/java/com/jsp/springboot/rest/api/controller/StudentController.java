package com.jsp.springboot.rest.api.controller;

import com.jsp.springboot.rest.api.bean.Student;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "vara", "prasad");
        //   return new  ResponseEntity<>(student, HttpStatus.OK) ;
        //   return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header", "vara", "prasad")
                .header("manual header", "lohith")
                .body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "vara", "prasad"));
        students.add(new Student(2, "vara", "prasad"));
        students.add(new Student(3, "vara", "prasad"));

        return ResponseEntity.ok().body(students);
    }

    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> getStudentByPath(@PathVariable int id,
                                                    @PathVariable("first-name") String firstName,
                                                    @PathVariable("last-name") String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok().body(student);
    }

    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                                          @RequestParam String firstName,
                                                          @RequestParam String lastName) {
        Student student = new Student(id, "vara", "prasad");
        return ResponseEntity.ok().body(student);
    }

    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id) {

        System.out.println(student.getId());
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());

        return ResponseEntity.ok().body(student);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        return ResponseEntity.ok("student deleted successfully with id :" + id + "!");
    }
}
