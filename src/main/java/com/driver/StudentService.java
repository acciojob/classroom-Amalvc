package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudentService(Student student){
        studentRepository.addStudentDb(student);


    }


    public  void addTeacherService(Teacher teacher){

        studentRepository.addTeacherDb(teacher);

    }


    public void addStudentTeacherService(String student,String teacher){
        studentRepository.addStudentTeacherDb(student,teacher);
    }


    public Student getStudentByNameService(String name){
       Student s=studentRepository.getStudentByNameDb(name);
       return s;
    }


    public  Teacher getTeacherByNameService(String name){
        return studentRepository.getTeacherByNameDb(name);
    }


    public List<String> getStudentByTeacherNameService(String teacher){
            return studentRepository.getStudentByTeacherDb(teacher);
    }


    public List<String> getAllStudentsService(){
        return studentRepository.getAllStudentsDb();
    }


    public void deleteTeacherByNameService(String teacher){
        studentRepository.deleteTeacherByNameDb(teacher);
    }

    public void deleteAllTeacherService(){
        studentRepository.deleteAllTeacherDb();
    }
}
