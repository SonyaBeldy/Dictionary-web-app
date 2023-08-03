package ru.sonyabeldy.dictionary.dictionarywebapp.services;

import org.springframework.stereotype.Service;
import ru.sonyabeldy.dictionary.dictionarywebapp.models.Person;
import ru.sonyabeldy.dictionary.dictionarywebapp.models.RuEngTranslation;
import ru.sonyabeldy.dictionary.dictionarywebapp.repositories.RuEngRepository;

import java.util.*;

@Service
public class RuEngService {

    private final RuEngRepository repository;

    public RuEngService(RuEngRepository repository) {
        this.repository = repository;
    }

    public boolean isFound(int id) {
        return repository.existsById(id);
    }

    public List<RuEngTranslation> findAll() {
        return repository.findAll();
    }

    public List<RuEngTranslation> findAllByOwner(Person owner) {
        return repository.findAllByOwner(owner);
    }

    public List<RuEngTranslation> shuffle(List<RuEngTranslation> translations) { //translations origin snd translation shuffle

        Collections.shuffle(translations);
        return translations;
    }

    public Optional<RuEngTranslation> findById(int id) {
        return repository.findById(id);
    }

    public void remove(int[] id) {
        for (int i : id) {
            repository.deleteById(i);
        }
    }
}
