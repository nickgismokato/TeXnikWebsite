package com.nickgismokato.TeXnik.backend.Data.Repo;

import com.nickgismokato.TeXnik.backend.Data.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long>{
	//Item save(Item item);
	//public List<Item> findAll();
	//Optional<Item> findById(int id);
}