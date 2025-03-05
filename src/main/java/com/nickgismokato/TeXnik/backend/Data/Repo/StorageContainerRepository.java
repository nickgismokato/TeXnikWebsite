package com.nickgismokato.TeXnik.backend.Data.Repo;

import com.nickgismokato.TeXnik.backend.Data.StorageContainer;

import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface StorageContainerRepository extends Repository<StorageContainer, Long> {
	StorageContainer save(StorageContainer storageContainer);
	Optional<StorageContainer> findById(Long id);
}
