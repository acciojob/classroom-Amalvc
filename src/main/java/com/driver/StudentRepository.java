package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
    private HashMap<String,Student>smap;
    private HashMap<String,Teacher>tmap;
    private HashMap<String,List<String>>stmap;

    public StudentRepository(){
        this.smap=new HashMap<String,Student>();
        this.tmap=new HashMap<String,Teacher>();
        this.stmap=new HashMap<String,List<String>>();
    }


    public void addStudentDb(Student student){

        smap.put(student.getName(),student);

    }


    public  void addTeacherDb(Teacher teacher){

       tmap.put(teacher.getName(),teacher);

    }


    public void addStudentTeacherDb(String student,String teacher){
        if(smap.containsKey(student) && tmap.containsKey(teacher)){
            if(stmap.containsKey(teacher)){
                stmap.get(teacher).add(student);
            }
            else{
                List<String>arr=new ArrayList<>();
                arr.add(student);
                stmap.put(teacher,arr);
            }
        }
    }


    public Student getStudentByNameDb(String name){
       return smap.get(name);
    }


    public Teacher getTeacherByNameDb(String name){
        return tmap.get(name);
    }


    public List<String> getStudentByTeacherDb(String teacher){
        List<String>a=new ArrayList<>();
        if(stmap.containsKey(teacher)){
            a=stmap.get(teacher);
        }
        return a;
    }


    public List<String> getAllStudentsDb(){
        return new ArrayList<>(smap.keySet());
    }


    public void deleteTeacherByNameDb(String teacher){
       List<String>list=new ArrayList<>();
       if(stmap.containsKey(teacher)){
           list=stmap.get(teacher);
           for(String d:list){
               if(smap.containsKey(d)){
                   smap.remove(d);
               }
           }
           stmap.remove(teacher);
       }
       if(tmap.containsKey(teacher)){
           tmap.remove(teacher);
       }
    }

    public void deleteAllTeacherDb(){
        HashSet<String>hs=new HashSet<>();
        tmap=new HashMap<>();
        for(String teacher:stmap.keySet()){
            for(String student:stmap.get(teacher)){
                hs.add(student);
            }
        }
        for(String student:hs){
            if(smap.containsKey(student)){
                smap.remove(student);
            }
        }
        stmap=new HashMap<>();
    }
}
