package com.stempien.bazaDanychCzyCos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * modyfikuj
 * usun
 * znajdzWszystkie
 */

@Service
public class BazaDanychCzyCosService {
    private final StudentRepository studentRepository;

    public BazaDanychCzyCosService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    void add(String firstName,String lastName,Integer age,Boolean isMale){
        Student student = new Student(firstName,lastName,age,isMale);
        studentRepository.save(student);
    }

    Optional<Student> findById(Integer id){
       return studentRepository.findById(id);
    }

  void delete(Integer id){
        studentRepository.deleteById(id);
    }

    void modify(Integer id,String firstName,String lastName,Integer age,Boolean isMale){
        delete(id);
        add(firstName,lastName,age,isMale);
    }
    String findAll(){
        List<Student> students= (List<Student>) studentRepository.findAll();
        return students.stream().map(elem -> String.format("%s %s", elem.firstName, elem.lastName)).collect(Collectors.joining("<br>"));
    }
}
