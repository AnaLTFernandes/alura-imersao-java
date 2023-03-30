package com.imersao.languagesapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.imersao.languagesapi.models.Language;

public interface LanguageRepository extends MongoRepository<Language, String> {
}