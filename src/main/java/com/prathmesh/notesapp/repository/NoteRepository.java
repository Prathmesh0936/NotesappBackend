package com.prathmesh.notesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prathmesh.notesapp.entity.Notes;

@Repository
public interface NoteRepository extends JpaRepository<Notes, Long> {

}
