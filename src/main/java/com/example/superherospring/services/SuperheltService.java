package com.example.superherospring.services;

import com.example.superherospring.model.Superhero;
import com.example.superherospring.repositories.SuperheltRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperheltService {
    private final SuperheltRepository superheltRepository;

    public SuperheltService(SuperheltRepository superhero) {
        this.superheltRepository = new SuperheltRepository();
    }

    public List<Superhero> getSuperHero() {
        return superheltRepository.getSuperheroes();
    }

    public Superhero getSuperheroes(int id) {
        return superheltRepository.getSuperhero(id);
    }
    public Superhero postSuperhero(Superhero superhero){
        Superhero returnSuperhero = superheltRepository.addSuperhero(superhero);
        return superhero;
    }
    public Superhero putSuperhero(Superhero superhero){
        Superhero returnSuperhero = superheltRepository.changeSuperhero(superhero);
        return superhero;
    }
    public Superhero deleteSuperhero(int id){
        return superheltRepository.deleteHero(id);
    }
}

