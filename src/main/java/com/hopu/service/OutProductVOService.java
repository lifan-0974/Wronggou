package com.hopu.service;

import com.hopu.model.OutProductVO;

import java.util.List;

public interface OutProductVOService {
    List<OutProductVO> findout(String out);

    List<OutProductVO> selectfindout(String out);
}
