package com.okr.wx.practice.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
public class SwiperItem extends BaseEntity {
  private static final long serialVersionUID = -3894079727069874921L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false, updatable = false)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String coverUrl = "../../static/defaultCover.jpg";
}
