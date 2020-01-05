package com.okr.wx.practice.demo.service.impl;

import com.okr.wx.practice.demo.converter.SwiperItemConverter;
import com.okr.wx.practice.demo.dto.SwiperItemDTO;
import com.okr.wx.practice.demo.entity.SwiperItem;
import com.okr.wx.practice.demo.repository.SwiperItemRepository;
import com.okr.wx.practice.demo.service.SwiperItemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class SwiperItemServiceImpl implements SwiperItemService {
  @Autowired SwiperItemRepository swiperItemRepository;
  @Autowired SwiperItemConverter swiperItemConverter;

  @Override
  public SwiperItemDTO getSwiperItemById(Long id) {
    return swiperItemConverter.convert2DTO(swiperItemRepository.getOne(id));
  }

  @Override
  public List<SwiperItemDTO> getAll() {
    return swiperItemRepository.findAll().stream()
        .map(swiperItem -> swiperItemConverter.convert2DTO(swiperItem))
        .collect(Collectors.toList());
  }

  @Override
  public void save(SwiperItemDTO swiperItemDTO) {
    SwiperItem swiperItem = swiperItemConverter.convert2Entity(swiperItemDTO);
    swiperItemRepository.save(swiperItem);
  }

  @Override
  public void update(SwiperItemDTO swiperItemDTO) {
    swiperItemRepository
        .findById(swiperItemDTO.getId())
        .ifPresent(
            dbSwiperItem -> {
              dbSwiperItem.setUpdateBy(swiperItemDTO.getUpdateBy());
              dbSwiperItem.setUpdateTime(ZonedDateTime.now());
              dbSwiperItem.setTitle(swiperItemDTO.getTitle());
              dbSwiperItem.setCoverUrl(swiperItemDTO.getCoverUrl());
            });
  }

  @Override
  public void delete(Long id) {
    swiperItemRepository.findById(id).ifPresent(swiperItem -> swiperItemRepository.deleteById(id));
  }
}
