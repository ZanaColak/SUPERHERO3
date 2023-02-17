package com.example.superherospring.controller;

import com.example.superherospring.model.Superhero;
import com.example.superherospring.services.SuperheltService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("superhelte")
public class SuperheltController {
    private final SuperheltService superheltService;
    public SuperheltController(SuperheltService superheltService){
        this.superheltService = superheltService;
    }
    @GetMapping(path = "welcome")
    //Denne metode viser alle Superheltene (Indlæsning)
    public ResponseEntity<List<Superhero>> getSupes(){
        List supelist = superheltService.getSuperHero();
        return new ResponseEntity<List<Superhero>>(supelist, HttpStatus.OK);
    }
    @GetMapping(path = "supes/{id}")
    public ResponseEntity<String> getSupes2(@PathVariable int id){
        //Denne metode udskriver kun en enkelt superhelt (valgt kun at udskrive superheltens navn) - (indlæsning)
        Superhero superhero = superheltService.getSuperheroes(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "text/html");
        return new ResponseEntity<>("<html><body><h1>" + superhero.getName() + "</h1></body></html>", httpHeaders, HttpStatus.OK);
    }
    @PostMapping(path = "supes/save")
    //saves
    public ResponseEntity<Superhero> postSupe(@RequestBody Superhero superhero){
        Superhero returnSupe = superheltService.postSuperhero(superhero);
        return new ResponseEntity<>(returnSupe, HttpStatus.OK);
    }
    @PutMapping(path = "supes/update")
    //updates
    public ResponseEntity<Superhero> putSupe(@RequestBody Superhero superhero){
        Superhero returnSupe = superheltService.putSuperhero(superhero);
        return new ResponseEntity<>(returnSupe, HttpStatus.OK);
    }
    @DeleteMapping(path = "supes/delete")
    public ResponseEntity<Superhero> deleteSupe(@PathVariable ("id") int id){
        Superhero returnSupe = superheltService.deleteSuperhero((id));
        return new ResponseEntity<>(returnSupe, HttpStatus.OK);
    }

}
