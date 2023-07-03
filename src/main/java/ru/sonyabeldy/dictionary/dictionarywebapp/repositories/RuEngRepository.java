package ru.sonyabeldy.dictionary.dictionarywebapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sonyabeldy.dictionary.dictionarywebapp.models.RuEngTranslation;

@Repository
public interface RuEngRepository extends JpaRepository<RuEngTranslation, Integer> {
}
