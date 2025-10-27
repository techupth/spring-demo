package com.techup.spring_demo.controller;

import com.techup.spring_demo.entity.Note;          // ใช้เป็นโครงสร้างข้อมูล (Entity)
import com.techup.spring_demo.service.NoteService;  // เรียก business logic จาก Service
import lombok.RequiredArgsConstructor;              // Lombok ช่วยสร้าง constructor ให้เอง
import org.springframework.web.bind.annotation.*;   // ใช้สำหรับ REST API (เช่น @GetMapping)
import java.util.List;                              // สำหรับเก็บข้อมูลหลาย record

@RestController // ✅ บอก Spring ว่าคลาสนี้จะ return JSON (เหมือน express.js ที่ส่ง res.json)
@RequestMapping("/api/notes") // ✅ ตั้ง path หลักสำหรับ endpoint ทั้งหมดในคลาสนี้
@RequiredArgsConstructor // ✅ ให้ Spring สร้าง constructor และ inject NoteService ให้อัตโนมัติ
public class NoteController {

  // ✅ final = เหมือน const ใน JS (ค่าคงที่ เปลี่ยน object reference ไม่ได้)
  private final NoteService noteService;

  // 🧩 GET /api/notes → ดึง Note ทั้งหมด
  @GetMapping
  public List<Note> getNotes() {
    return noteService.getAll(); // ✅ เรียก service ไปดึงข้อมูลจาก DB
  }

  // 🧱 POST /api/notes → สร้าง Note ใหม่
  @PostMapping
  public Note createNote(@RequestBody Note note) {
    // ✅ Spring จะ map JSON body → Note object ให้อัตโนมัติ
    return noteService.create(note); // ส่งต่อให้ service บันทึกลง DB
  }
}