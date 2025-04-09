package com.nickgismokato.TeXnik.backend.Data.Controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nickgismokato.TeXnik.backend.Data.Item;
import com.nickgismokato.TeXnik.backend.Data.Repo.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1")
public class ItemController {
	@Autowired
	private ItemRepository itemRepository;

	@GetMapping("/items")
	public List<Item> GetAllItems() {
		return itemRepository.findAll();
	}
	@PostMapping("/items")
	public Item CreateItem(@Valid @RequestBody Item item) {
		return ItemRepository.save(item);
	}

}
