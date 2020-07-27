package com.chan.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chan.spring.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
