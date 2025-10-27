package com.techup.spring_demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // รวม getter/setter/toString/equals/hashCode
@NoArgsConstructor // Constructor ว่าง
@AllArgsConstructor // Constructor ทุก field

public class Note {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String content;
}