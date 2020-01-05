package com.okr.wx.practice.demo.repository;

import com.okr.wx.practice.demo.entity.SwiperItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SwiperItemRepository
    extends JpaRepository<SwiperItem, Long>, JpaSpecificationExecutor<SwiperItem> {}
