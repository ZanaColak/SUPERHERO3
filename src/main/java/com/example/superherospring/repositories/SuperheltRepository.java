package com.example.superherospring.repositories;

import com.example.superherospring.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class SuperheltRepository {
    private final List<Superhero> superheroes = new ArrayList<>(List.of(
            new Superhero("Batman", true, "Strength", 1989, 89),
            new Superhero("Homelander", false, "fly, laser-eyes etc.", 1880, 200)
    ));

    public List <Superhero> getSuperheroes(){
        return superheroes;
    }
    public Superhero getSuperhero(int id){
        return superheroes.get(id);
    }
    public Superhero addSuperhero(Superhero superhero){
        superheroes.add(superhero);
        return superhero;
    }
    public Superhero changeSuperhero(Superhero superhero){
        int i = 0;
        while (i < superheroes.size()){
            if (Objects.equals(superhero.getName(), superheroes.get(i).getName())){
                superheroes.set(i, superhero);
                return superhero;
            }
            i++;
        }
        return null;

    }
    public Superhero deleteHero(int heroToDelete) {

        int deleteOnIndex = heroToDelete - 1;

        superheroes.remove(deleteOnIndex);
        return null;
    }
}
