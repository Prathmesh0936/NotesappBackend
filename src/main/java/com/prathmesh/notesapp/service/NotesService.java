package com.prathmesh.notesapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prathmesh.notesapp.dao.addNotesDao;
import com.prathmesh.notesapp.dao.updateNotesDao;
import com.prathmesh.notesapp.entity.Notes;
import com.prathmesh.notesapp.repository.NoteRepository;

@Service
public class NotesService {

	@Autowired
	NoteRepository noteRepository;
	
	public Notes addNotes(addNotesDao addNotesDao) {
		
		Notes notes = new Notes();
		
		notes.setTitle(addNotesDao.getTitle());
		
		notes.setContent(addNotesDao.getContent());
		
		notes = this.noteRepository.save(notes);
		
		return notes;
	}
	
	public List<Notes> getAllNotes(){
		
		List<Notes> notes = new ArrayList<Notes>();
		
		notes = this.noteRepository.findAll();
		
		return notes;
		
	}
	
	public Notes getById(Long id) {
		
		Notes notes = new Notes();
		
		notes = this.noteRepository.findById(id).orElse(null);
		
		return notes;
	}
	
	public String deleteById(Long id) {
		
		this.noteRepository.deleteById(id);
		
		return "Notes Data Deleted Successfully";
	}
	
	public Notes updateById(Long id, updateNotesDao updateNotesDao) {
		
		Notes notes = new Notes();
		
		notes = this.getById(id);
		
		if(updateNotesDao.getTitle() != null) {
			notes.setTitle(updateNotesDao.getTitle());
		}
		
		if(updateNotesDao.getContent() != null) {
			notes.setContent(updateNotesDao.getContent());
		}
		
		this.noteRepository.save(notes);
			
			return notes;
	}
}
