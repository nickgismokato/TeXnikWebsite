package com.nickgismokato.TeXnik.backend.Data.Repo;

import com.nickgismokato.TeXnik.backend.Data.Item;

import com.nickgismokato.TeXnik.backend.Data.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>{
	// Find items by name
    List<Item> findByName(String name);

    // Find items by category ID
    List<Item> findByCatID(int catID);

    // Custom query to find items with amount greater than a specific value
    @Query("SELECT i FROM Item i WHERE i.amount > :amount")
    List<Item> findItemsWithAmountGreaterThan(@Param("amount") int amount);
}