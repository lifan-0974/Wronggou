package com.hopu.service.impl;

import com.hopu.mapper.OutProductVOMapper;
import com.hopu.model.OutProductVO;
import com.hopu.service.OutProductVOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutProductVOServiceImpl implements OutProductVOService {
    @Autowired
    private OutProductVOMapper outProductVOMapper;

    @Override
    public List<OutProductVO> findout(String out) {
        return outProductVOMapper.findout(out);
    }

    @Override
    public List<OutProductVO> selectfindout(String out) {
        return outProductVOMapper.selectfindout(out);
    }


}
