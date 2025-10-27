package com.techup.spring_demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // บอก Spring ว่าคลาสนี้จะถูก map เป็นตารางใน Database
@Data // สร้าง getter/setter/toString/equals/hashCode ให้อัตโนมัติ
@NoArgsConstructor // Constructor ว่าง (จำเป็นสำหรับ JPA)
@AllArgsConstructor // Constructor ที่มีทุก field
@Builder // ใช้สร้าง object แบบ chain
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key

    @Column(nullable = false, unique = true) // ห้ามซ้ำ ห้ามว่าง
    private String email;

    @Column(nullable = false)
    private String password;
}