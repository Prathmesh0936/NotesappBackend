package com.prathmesh.notesapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prathmesh.notesapp.dao.addNotesDao;
import com.prathmesh.notesapp.dao.updateNotesDao;
import com.prathmesh.notesapp.service.NotesService;

@Controller
@CrossOrigin(origins = {"http://localhost:5173", "https://notesapp-xxdz.vercel.app"})
@RequestMapping("/notes")
public class NotesController {

	@Autowired
	NotesService notesService;
	
	@PostMapping("")
	public ResponseEntity<?> addNotes(@RequestBody addNotesDao addNotesDao){
		return ResponseEntity.ok(this.notesService.addNotes(addNotesDao));
	}
	
	@GetMapping("")
	public ResponseEntity<?> getAllNotes(){
		return ResponseEntity.ok(this.notesService.getAllNotes());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getNotesById(@PathVariable Long id){
		return ResponseEntity.ok(this.notesService.getById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteNotesById(@PathVariable Long id){
		return ResponseEntity.ok(this.notesService.deleteById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateNotesById(@PathVariable Long id, @RequestBody updateNotesDao updateNotesDao){
		return ResponseEntity.ok(this.notesService.updateById(id, updateNotesDao));
	}
}
