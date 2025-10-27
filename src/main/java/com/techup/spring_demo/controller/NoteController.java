package com.techup.spring_demo.controller;

import com.techup.spring_demo.dto.NoteRequest;
import com.techup.spring_demo.dto.NoteResponse;
import com.techup.spring_demo.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

  private final NoteService noteService;

  // GET /api/notes → 200
  @GetMapping
  public ResponseEntity<List<NoteResponse>> getNotes() {
    return ResponseEntity.ok(noteService.getAll());
  }

  // GET /api/notes/{id} → 200 | 404
  @GetMapping("/{id}")
  public ResponseEntity<NoteResponse> getNote(@PathVariable Long id) {
    return ResponseEntity.ok(noteService.getById(id));
  }

  // POST /api/notes → 201 + Location header
  @PostMapping
  public ResponseEntity<NoteResponse> create(@RequestBody NoteRequest req) {
    NoteResponse created = noteService.create(req);
    URI location = URI.create("/api/notes/" + created.getId());
    return ResponseEntity.created(location).body(created);
  }

  // PUT /api/notes/{id} → 200 | 404
  @PutMapping("/{id}")
  public ResponseEntity<NoteResponse> update(@PathVariable Long id,
                                             @RequestBody NoteRequest req) {
    return ResponseEntity.ok(noteService.update(id, req));
  }

  // DELETE /api/notes/{id} → 204
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    noteService.delete(id);
    return ResponseEntity.noContent().build();
  }
}