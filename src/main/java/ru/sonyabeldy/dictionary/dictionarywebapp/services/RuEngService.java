package ru.sonyabeldy.dictionary.dictionarywebapp.services;

import org.springframework.stereotype.Service;
import ru.sonyabeldy.dictionary.dictionarywebapp.models.RuEngTranslation;
import ru.sonyabeldy.dictionary.dictionarywebapp.repositories.RuEngRepository;

import java.util.List;

@Service
public class RuEngService {

    private final RuEngRepository repository;

    public RuEngService(RuEngRepository repository) {
        this.repository = repository;
    }

    public List<RuEngTranslation> findAll() {
        return repository.findAll();
    }
}
