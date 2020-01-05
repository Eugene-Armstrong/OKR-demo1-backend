package com.okr.wx.practice.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwiperItemDTO implements Serializable {
  private Long id;
  private String updateBy;
  private ZonedDateTime updateTime = ZonedDateTime.now();;
  private String title;
  private String coverUrl;
}
