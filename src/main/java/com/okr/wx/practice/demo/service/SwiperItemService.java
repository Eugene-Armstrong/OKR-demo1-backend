package com.okr.wx.practice.demo.service;

import com.okr.wx.practice.demo.dto.SwiperItemDTO;

import java.util.List;

public interface SwiperItemService {
  SwiperItemDTO getSwiperItemById(Long id);

  List<SwiperItemDTO> getAll();

  void save(SwiperItemDTO swiperItemDTO);

  void update(SwiperItemDTO swiperItemDTO);

  void delete(Long id);
}
