package com.okr.wx.practice.demo.converter;

import com.okr.wx.practice.demo.dto.SwiperItemDTO;
import com.okr.wx.practice.demo.entity.SwiperItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SwiperItemConverter {
  public SwiperItemDTO convert2DTO(SwiperItem swiperItem) {
    SwiperItemDTO swiperItemDTO = new SwiperItemDTO();
    BeanUtils.copyProperties(swiperItem, swiperItemDTO);
    return swiperItemDTO;
  }

  public SwiperItem convert2Entity(SwiperItemDTO swiperItemDTO) {
    SwiperItem swiperItem = new SwiperItem();
    BeanUtils.copyProperties(swiperItemDTO, swiperItem);
    return swiperItem;
  }
}
