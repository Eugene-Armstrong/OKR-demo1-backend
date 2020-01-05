package com.okr.wx.practice.demo.controller;

import com.okr.wx.practice.demo.dto.SwiperItemDTO;
import com.okr.wx.practice.demo.service.SwiperItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/swiper-item")
public class SwiperItemController {

  @Autowired SwiperItemService swiperItemService;

  @GetMapping("/list")
  public List<SwiperItemDTO> getSwiperItemList() {
    return swiperItemService.getAll();
  }

  @GetMapping("/{id}")
  public SwiperItemDTO getSwiperItemById(@PathVariable("id") Long id) {
    return swiperItemService.getSwiperItemById(id);
  }

  @PostMapping
  public ResponseEntity addSwiperItem(@RequestBody SwiperItemDTO swiperItemDTO) {
    swiperItemService.save(swiperItemDTO);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping
  public ResponseEntity updateSwiperItem(@RequestBody SwiperItemDTO swiperItemDTO) {
    swiperItemService.update(swiperItemDTO);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteSwiperItem(@PathVariable("id") Long id) {
    swiperItemService.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
