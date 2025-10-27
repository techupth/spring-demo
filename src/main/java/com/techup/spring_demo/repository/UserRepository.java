package com.techup.spring_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.techup.spring_demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // ไม่ต้องเขียนโค้ดเพิ่ม Spring จะสร้าง CRUD ให้ทั้งหมด
}