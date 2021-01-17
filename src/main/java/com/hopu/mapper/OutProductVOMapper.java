package com.hopu.mapper;

import com.hopu.model.OutProductVO;

import java.util.List;

public interface OutProductVOMapper {
    List<OutProductVO> findout(String out);

    List<OutProductVO> selectfindout(String out);


}
