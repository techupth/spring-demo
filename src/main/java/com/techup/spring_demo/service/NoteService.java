package com.techup.spring_demo.service;

import com.techup.spring_demo.entity.Note;           // Entity ที่แทนตาราง notes
import com.techup.spring_demo.repository.NoteRepository; // ใช้คุยกับ Database
import lombok.RequiredArgsConstructor;               // ของ Lombok สำหรับสร้าง constructor อัตโนมัติ
import org.springframework.stereotype.Service;       // บอก Spring ว่าคลาสนี้เป็น Service
import java.util.List;                               // ใช้สำหรับเก็บ list ของข้อมูล Note

@Service  // ✅ บอก Spring ว่าคลาสนี้เป็น Service component
@RequiredArgsConstructor // ✅ Lombok สร้าง constructor อัตโนมัติให้สำหรับทุก field ที่เป็น final
public class NoteService {

  
  private final NoteRepository noteRepository; // final = ค่าคงที่, ปลอดภัยจากการแก้ไขภายหลัง

  public List<Note> getAll() {
    return noteRepository.findAll();
  }

  public Note create(Note note) {
    return noteRepository.save(note);
  }
}
