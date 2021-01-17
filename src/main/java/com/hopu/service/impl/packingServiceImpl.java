package com.hopu.service.impl;

import com.hopu.mapper.ExportMapper;
import com.hopu.mapper.packingMapper;
import com.hopu.model.Export;
import com.hopu.model.packing;
import com.hopu.service.packingService;
import com.hopu.util.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Service
public class packingServiceImpl implements packingService {
    @Autowired
    private packingMapper packingMapper;
    @Autowired
    private ExportMapper exportMapper;

    @Override
    public List<packing> find() {
        return packingMapper.find();
    }


    private packing spellString(packing packingList) {
        String _exportIds = "";
        String _exportNos = "";

        String[] _s = packingList.getEXPORT_IDS().split(",");        //id|no
        for (int i = 0; i < _s.length; i++) {
            String[] _tmp = _s[i].split("\\|");                        //正则表达式，转义
            _exportIds += _tmp[0] + "|";
            _exportNos += _tmp[1] + "|";
        }
        _exportIds = UtilFuns.delLastChar(_exportIds);
        _exportNos = UtilFuns.delLastChar(_exportNos);

        packingList.setEXPORT_IDS(_exportIds);
        packingList.setEXPORT_NOS(_exportNos);

        return packingList;
    }

    //拼接HTML片段
    public String getDivDataCreate(String[] exportIds) {
        StringBuffer sBuf = new StringBuffer();
        for (int i = 0; i < exportIds.length; i++) {

            Export export = exportMapper.selectbyid(exportIds[i]);

            sBuf.append("<input type='checkbox' id='EXPORT_IDS' name='EXPORT_IDS' checked value='").append(exportIds[i]).append("|").append(export.getCUSTOMER_CONTRACT()).append("'class='input'/>");

            sBuf.append(export.getCUSTOMER_CONTRACT()).append("  ");
        }

        return sBuf.toString();
    }

    @Override
    public int insert(packing packingList) {
        this.spellString(packingList);
        packingList.setPACKING_LIST_ID(UUID.randomUUID().toString());
        packingList.setSTATE(0);                    //0草稿1已上报
        return packingMapper.insert(packingList);
    }

    public String getDivDataUpdate(String[] exportIds, String[] exportNos) {
        StringBuffer sBuf = new StringBuffer();
        for (int i = 0; i < exportIds.length; i++) {
            sBuf.append("<input type='checkbox' id='EXPORT_IDS' name='EXPORT_IDS' checked value='").append(exportIds[i]).append("|").append(exportNos[i]).append("'class='input'/>");
            sBuf.append(exportNos[i]).append("  ");
        }

        return sBuf.toString();
    }

    public String getDivDataView(String[] exportNos) {
        StringBuffer sBuf = new StringBuffer();
        for (int i = 0; i < exportNos.length; i++) {
            sBuf.append(exportNos[i]).append("  ");
        }

        return sBuf.toString();
    }

    @Override
    public packing selectbyid(String i) {
        return packingMapper.selectbyid(i);
    }

    @Override
    public int update(packing packingList) {
        this.spellString(packingList);


        return packingMapper.update(packingList);
    }
}
