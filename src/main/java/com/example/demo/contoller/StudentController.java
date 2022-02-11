package com.example.demo.contoller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Access;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    //display list of employee
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listStudents",studentService.getAllEmployees());
        return "index";
    }
    // display add a new student form
    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model){
        //create a model attribute to  bind form data
        Student student=new Student();
        model.addAttribute("student",student);
        return "new_student";

    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student){
        // save student to the database
        studentService.saveStudent(student);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") Long id, Model model){
        //get student from the service
        Student student=studentService.getStudentByI(id);

        //set student as a model attribute to pre-populate the form
        model.addAttribute("student",student);
        return "update_student";
    }
    @GetMapping("deleteStudent/{id}")
    public String deleteStudent(@PathVariable (value = "id")Long id){
        //call delete student method
        this.studentService.deleteStudentById(id);
        return "redirect:/";


    }

}
