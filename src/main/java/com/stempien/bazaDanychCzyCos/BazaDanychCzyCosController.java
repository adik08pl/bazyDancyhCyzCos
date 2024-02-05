package com.stempien.bazaDanychCzyCos;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class BazaDanychCzyCosController {
    private final BazaDanychCzyCosService bazaDanychCzyCosService;

    public BazaDanychCzyCosController(BazaDanychCzyCosService bazaDanychCzyCosService) {
        this.bazaDanychCzyCosService = bazaDanychCzyCosService;
    }

    @GetMapping("/add")
    @ResponseBody()
        void add(@RequestParam String imie , @RequestParam String nazwisko, @RequestParam Integer wiek, @RequestParam Boolean czyMezczyzna){
            bazaDanychCzyCosService.add(imie,nazwisko,wiek,czyMezczyzna);
        }
    @GetMapping("/find")
    @ResponseBody()
    String find(@RequestParam Integer id){
        Optional<Student> student = bazaDanychCzyCosService.findById(id);
        if (student.isEmpty())
            return "Nie ma studenta o id " + id;

        return student.get().firstName + " " + student.get().lastName;
    }
   @GetMapping("/delete")
    @ResponseBody()
    void delete(@RequestParam Integer id){
        bazaDanychCzyCosService.delete(id);
    }
    @GetMapping("/modify")
    @ResponseBody()
    void modify(@RequestParam Integer id,@RequestParam String imie , @RequestParam String nazwisko, @RequestParam Integer wiek, @RequestParam Boolean czyMezczyzna){
        bazaDanychCzyCosService.modify(id,imie,nazwisko,wiek,czyMezczyzna);
    }
    @GetMapping("/findAll")
    @ResponseBody()
    String findAll(){
        return bazaDanychCzyCosService.findAll();
    }
}
