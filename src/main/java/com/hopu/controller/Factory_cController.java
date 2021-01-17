package com.hopu.controller;

import com.hopu.model.*;
import com.hopu.service.*;
import com.hopu.util.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class Factory_cController {
    @Autowired
    private SqlDao sqlao;
    @Autowired
    private ExtEproductService extEproductService;
    @Autowired
    private packingService packingService;
    @Autowired
    private ExportService exportService;
    @Autowired
    private ExportproductService exportproductService;
    @Autowired
    private OutProductVOService outProductVOService;
    @Autowired
    private Factory_cService factory_cService;
    @Autowired
    private Ext_cproduct_CService ext_cproduct_cService;
    @Autowired
    private Contract_cService contract_cService;
    @Autowired
    private Contract_ProductService contract_productService;

    @RequestMapping("/")
    public String index() {
        return "table1";
    }

    @RequestMapping("/index")
    public String indexx() {
        return "table1";
    }

    @RequestMapping("/indexx")
    public String indexxx() {
        return "table2";
    }

    @RequestMapping("/goexportRMupdate")
    public String goexportRMupdate() {
        return "exportRMupdate";
    }

    @RequestMapping("/goexportRMupdate1")
    public String goexportRMupdate1() {
        return "exportRMupdate1";
    }

    @RequestMapping("/gopackinginsert")
    public String gopackinginsert(String ids, Model model) {
        model.addAttribute("userList", ids);
        return "packinginsert";
    }

    @RequestMapping("/packing")
    public String packing() {
        return "packing";
    }

    @RequestMapping("/indexxx")
    public String indexxxx() {
        return "contandfactinsert1";
    }

    @RequestMapping("/goinsert")
    public String goinsert() {
        return "insert";
    }

    @RequestMapping("/goupdate")
    public String goupdate() {
        return "update";
    }

    @RequestMapping("/gocontupdate")
    public String gocontupdate() {
        return "updatecont";
    }

    @RequestMapping("/gocontinsert")
    public String gocontinsert() {
        return "continsert";
    }


    @RequestMapping("/gocontandfactupdate")
    public String gocontandfactupdate() {
        return "contandfactupdate";
    }

    @RequestMapping("/goselectext")
    public String goselectext() {
        return "selectthree";
    }

    @RequestMapping("/goupdatethree")
    public String goupdatethree() {
        return "updatethree";
    }

    @RequestMapping("/gooutProductVO")
    public String gooutProductVO() {
        return "outProductVO";
    }

    @RequestMapping("/exportRM")
    public String exportRM() {
        return "exportRM";
    }


    @RequestMapping("/selectcontract")
    public String selectcontract() {
        return "contractall";
    }

    @RequestMapping("/selectcontandfactinsert")
    @ResponseBody
    public R selectcontandfactinsert(String CONTRACT_ID) {
        List<Factory_c> factory_cs = factory_cService.selectAll();
        Contract_c selectcontbyid = contract_cService.selectcontbyid(CONTRACT_ID);
        List<CONTRACT_PRODUCT_C> selecttwo = contract_productService.selecttwo(CONTRACT_ID);
        Map<String, Object> map = new HashMap<>();
        map.put("factory_cs", factory_cs);
        map.put("selectcontbyid", selectcontbyid);
        map.put("selecttwo", selecttwo);
        return R.ok().data(map);
    }

    @RequestMapping("/selectthree")
    @ResponseBody
    public R selectthree(String CONTRACT_PRODUCT_ID) {
        List<Factory_c> factory_cs = factory_cService.selectAll();
        List<Ext_cproduct_C> selectthree = ext_cproduct_cService.selectthree(CONTRACT_PRODUCT_ID);
        Map<String, Object> map = new HashMap<>();
        map.put("factory_cs", factory_cs);
        map.put("selectthree", selectthree);
        return R.ok().data(map);
    }

    @RequestMapping("/insertthree")
    @ResponseBody
    public R insertthree(Ext_cproduct_C ext_cproduct_c) {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        ext_cproduct_c.setEXT_CPRODUCT_ID(s);
        int i = ext_cproduct_cService.insertthree(ext_cproduct_c);
        if (i != 0) {
            return R.ok().message("添加成功");
        } else {
            return R.error().message("添加失败");
        }

    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public R selectAll() {
        List<Factory_c> factory_cs = factory_cService.selectAll();
        if (factory_cs != null) {
            return R.ok().data("factory_cs", factory_cs);
        } else {
            return R.error().message("查询失败");
        }

    }

    @RequestMapping("/selectbyid")
    @ResponseBody
    public R selectbyid(Factory_c fa) {
        Factory_c selectbyid = factory_cService.selectbyid(fa);
        if (selectbyid != null) {
            return R.ok().data("selectbyid", selectbyid);
        } else {
            return R.error().message("查询失败");
        }

    }

    @RequestMapping("/insert")
    @ResponseBody
    public R insert(Factory_c factory_c) {
        int i = factory_cService.insert(factory_c);
        if (i != 0) {
            return R.ok().message("添加成功");
        } else {
            return R.error().message("添加失败");
        }

    }

    @RequestMapping("/update")
    @ResponseBody
    public R update(Factory_c factory_c) {
        int i = factory_cService.update(factory_c);
        if (i != 0) {
            return R.ok().message("修改成功");
        } else {
            return R.error().message("修改失败");
        }

    }

    @RequestMapping("/delete")
    @ResponseBody
    public R delete(String userList) {
        String[] strs = userList.split(",");
        for (int i = 0; i < strs.length; i++) {
            factory_cService.delete(Integer.parseInt(strs[i]));
        }


        return R.ok().message("删除成功");
    }

    @RequestMapping("/deletethreee")
    @ResponseBody
    public R deletethreee(String userList) {
        String[] strs = userList.split(",");
        for (int i = 0; i < strs.length; i++) {
            ext_cproduct_cService.deletethreee(strs[i]);
        }


        return R.ok().message("删除成功");
    }


    @RequestMapping("/updatestate1")
    @ResponseBody
    public R updatestate1(Factory_c factory_c) {
        Factory_c selectbyid = factory_cService.selectbyid(factory_c);
        selectbyid.setSTATE("2");
        factory_cService.update(selectbyid);
        if (selectbyid != null) {
            return R.ok().message("停用成功");
        } else {
            return R.error().message("停用失败");
        }

    }


    @RequestMapping("/updatestate2")
    @ResponseBody
    public R updatestate2(Factory_c factory_c) {
        Factory_c selectbyid = factory_cService.selectbyid(factory_c);
        selectbyid.setSTATE("1");
        factory_cService.update(selectbyid);
        if (selectbyid != null) {
            return R.ok().message("启用成功");
        } else {
            return R.error().message("停用失败");
        }

    }

    @RequestMapping("/selectconall")
    @ResponseBody
    public R selectconall() {
        List<Contract_c> contract_cs = contract_cService.selectconall();
        if (contract_cs != null) {
            return R.ok().data("contract_cs", contract_cs);
        } else {
            return R.error().message("查询失败");
        }

    }

    @RequestMapping("/insertcont")
    @ResponseBody
    public R insertcont(Contract_c contract_c) {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        contract_c.setCONTRACT_ID(s);
        contract_c.setSTATE("1");
        int i = contract_cService.insertcont(contract_c);
        if (i != 0) {
            return R.ok().message("添加成功");
        } else {
            return R.error().message("添加失败");
        }

    }

    @RequestMapping("/deletecont")
    @ResponseBody
    public R deletecont(String userList) {
        String[] strs = userList.split(",");

        for (int i = 0; i < strs.length; i++) {
            List<CONTRACT_PRODUCT_C> selecttwo = contract_productService.selecttwo(strs[i]);
            for (int j = 0; j < selecttwo.size(); j++) {

                ext_cproduct_cService.deleteByCONTRACT_PRODUCT_ID(selecttwo.get(j).getCONTRACT_PRODUCT_ID());
            }
            contract_productService.deleteByContractId(strs[i]);
            contract_cService.deletecont(strs[i]);
        }


        return R.ok().message("删除成功");
    }

    @RequestMapping("/selectcontbyid")
    @ResponseBody
    public R selectcontbyid(String CONTRACT_ID) {
        Contract_c selectcontbyid = contract_cService.selectcontbyid(CONTRACT_ID);
        if (selectcontbyid != null) {
            return R.ok().data("selectcontbyid", selectcontbyid);
        } else {
            return R.error().message("查询失败");
        }

    }

    @RequestMapping("/updatestate11")
    @ResponseBody
    public R updatestate11(String CONTRACT_ID) {

        int updatecont = contract_cService.updatesatet(CONTRACT_ID);
        if (updatecont != 0) {
            return R.ok().message("停用成功");
        } else {
            return R.error().message("停用失败");
        }

    }


    @RequestMapping("/updatestate22")
    @ResponseBody
    public R updatestate22(String CONTRACT_ID) {
        int updatecont = contract_cService.updatesatet1(CONTRACT_ID);
        if (updatecont != 0) {
            return R.ok().message("上报成功");
        } else {
            return R.error().message("上报失败");
        }

    }

    @RequestMapping("/updatecont")
    @ResponseBody
    public R updatecont(Contract_c contract_c) {
        int i = contract_cService.updatecont(contract_c);
        if (i != 0) {
            return R.ok().message("修改成功");
        } else {
            return R.error().message("修改失败");
        }

    }

    /*
    @RequestMapping("/selectcontandprodAll")
    @ResponseBody
    public R selectcontandprodAll(){
        List<CONTRACT_PRODUCT_C> selecttwo = contract_productService.selecttwo();
        if (selecttwo!=null){
            return R.ok().data("selecttwo",selecttwo);
        }else {
            return  R.error().message("查询失败");
        }

    }
    */
    @RequestMapping("/contandfactinsert")
    @ResponseBody
    public R contandfactinsert(CONTRACT_PRODUCT_C contract_product_c) {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        contract_product_c.setCONTRACT_PRODUCT_ID(s);
        int i = contract_productService.insertcontandfact(contract_product_c);
        if (i != 0) {
            return R.ok().message("添加成功");
        } else {
            return R.error().message("添加失败");
        }

    }

    @RequestMapping("/deletecontandfact")
    @ResponseBody
    public R deletecontandfact(String userList) {
        String[] strs = userList.split(",");
        for (int i = 0; i < strs.length; i++) {
            contract_productService.deletecontandfact(strs[i]);
        }


        return R.ok().message("删除成功");
    }

    @RequestMapping("/selecttwobyid")
    @ResponseBody
    public R selecttwobyid(CONTRACT_PRODUCT_C c) {

        CONTRACT_PRODUCT_C selecttwobyid = contract_productService.selecttwobyid(c);
        List<Factory_c> factory_cs = factory_cService.selectAll();

        Map<String, Object> map = new HashMap<>();
        map.put("factory_cs", factory_cs);
        map.put("selecttwobyid", selecttwobyid);
        return R.ok().data(map);


    }

    @RequestMapping("/selectthreebyid")
    @ResponseBody
    public R selectthreebyid(String ext_CPRODUCT_ID) {

        Ext_cproduct_C selectthreebyid = ext_cproduct_cService.selectthreebyid(ext_CPRODUCT_ID);
        List<Factory_c> factory_cs = factory_cService.selectAll();

        Map<String, Object> map = new HashMap<>();
        map.put("factory_cs", factory_cs);
        map.put("selecttwobyid", selectthreebyid);
        return R.ok().data(map);


    }

    @RequestMapping("/updatecontandfact")
    @ResponseBody
    public R updatecontandfact(CONTRACT_PRODUCT_C CONTRACT_PRODUCT_ID) {

        int updatecont = contract_productService.updatecontandfact(CONTRACT_PRODUCT_ID);
        if (updatecont != 0) {
            return R.ok().message("修改成功");
        } else {
            return R.error().message("修改失败");
        }

    }

    @RequestMapping("/updatethree")
    @ResponseBody
    public R updatethree(Ext_cproduct_C ext_cproduct_c) {

        int updatethree = ext_cproduct_cService.updatethree(ext_cproduct_c);
        if (updatethree != 0) {
            return R.ok().message("修改成功");
        } else {
            return R.error().message("修改失败");
        }

    }

    @RequestMapping("/outProductVO")
    @ResponseBody
    public void outProductVO(String shipTime, HttpServletResponse response) throws IOException {


        Workbook wb = new HSSFWorkbook();        //创建一个工作簿
        Sheet sheet = wb.createSheet();            //创建一个工作表
        Row nRow = null;
        Cell nCell = null;
        int rowNo = 0;                            //行号
        int colNo = 1;                            //列号：从第2列开始

        //创建样式和字体对象
        CellStyle curStyle = wb.createCellStyle();
        Font curFont = wb.createFont();

        sheet.setColumnWidth(0, 1 * 278); // 设置列宽 278，BUG，精度不够，总是差一点
        sheet.setColumnWidth(1, 26 * 278);
        sheet.setColumnWidth(2, 12 * 278);
        sheet.setColumnWidth(3, 29 * 278);
        sheet.setColumnWidth(4, 10 * 278);
        sheet.setColumnWidth(5, 12 * 278);
        sheet.setColumnWidth(6, 8 * 278);
        sheet.setColumnWidth(7, 10 * 278);
        sheet.setColumnWidth(8, 10 * 278);
        sheet.setColumnWidth(9, 8 * 278);

        //处理大标题	sheet.addMergedRegion(new CellRangeAddress(开始行，结束行，开始列，结束列));
        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 8));

        //合并单元格的内容是写在合并前第一个单元格
        nRow = sheet.createRow(rowNo++);
        nRow.setHeightInPoints(36);

        nCell = nRow.createCell(1);
        nCell.setCellStyle(bigTitleStyle(wb));

        nCell.setCellValue(shipTime.replaceFirst("-0", "-").replaceFirst("-", "年") + "月份出货表");        //yyyy-MM

        //处理标题。标题数组
        String[] title = new String[]{"客户", "订单号", "货号", "数量", "工厂", "船期"};
        nRow = sheet.createRow(rowNo++);
        nRow.setHeightInPoints(26);

        for (int i = 0; i < title.length; i++) {
            nCell = nRow.createCell(i + 1);
            nCell.setCellValue(title[i]);
            nCell.setCellStyle(this.titleStyle(wb));
        }

        //处理内容
        List<OutProductVO> dataList = outProductVOService.findout(shipTime);

        for (int j = 0; j < dataList.size(); j++) {
            colNo = 1;                //初始化
            OutProductVO op = dataList.get(j);

            nRow = sheet.createRow(rowNo++);
            nRow.setHeightInPoints(24);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getCustomName());
            nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getContractNo());
            nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getProductNo());
            nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getCnumber());
            nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));


            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getDeliveryPeriod());
            nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getShipTime());
            nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));


        }

        OutputStream os = new FileOutputStream("d:\\outproduct.xls");
        wb.write(os);

        os.flush();
        os.close();

//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        wb.write(os);
//
//        //直接弹出下载框，用户可以打开，可以保存
//        DownloadUtil downloadUtil = new DownloadUtil();
//        downloadUtil.download(os, response, "出货表.xls");
//
//        os.flush();
//        os.close();
    }

    //模板开发
    @RequestMapping("/outProductVO1")
    @ResponseBody
    public void outProductVO1(String shipTime, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // linux下jdk1.8 方法获取时，不会拼接自己写的目录
        String path = request.getSession().getServletContext().getRealPath("/") + "/make/xlsprint/";
        InputStream is = new FileInputStream(new File(path + "tOUTPRODUCT.xls"));

        Workbook wb = new HSSFWorkbook(is); // 打开一个模板文件，工作簿
        Sheet sheet = wb.getSheetAt(0); // 获取到第一个工作表

        Row nRow = null;
        Cell nCell = null;
        int rowNo = 0; // 行号
        int colNo = 1; // 列号

        // 获取模板上的单元格样式
        nRow = sheet.getRow(2);

        // 客户的样式
        nCell = nRow.getCell(1);
        CellStyle customStyle = nCell.getCellStyle();

        // 订单号的样式
        nCell = nRow.getCell(2);
        CellStyle contractNoStyle = nCell.getCellStyle();

        // 货号的样式
        nCell = nRow.getCell(3);
        CellStyle productNoStyle = nCell.getCellStyle();

        // 数量的样式
        nCell = nRow.getCell(4);
        CellStyle numStyle = nCell.getCellStyle();

        // 生产厂家的样式
        nCell = nRow.getCell(5);
        CellStyle factoryStyle = nCell.getCellStyle();

        // 工厂交期的样式
        nCell = nRow.getCell(6);
        CellStyle dateStyle = nCell.getCellStyle();

        // 船期的样式和工厂交期的样式一样
        // nCell = nRow.getCell(7);
        // CellStyle shipStyle = nCell.getCellStyle();

        // 贸易条款的样式
        nCell = nRow.getCell(8);
        CellStyle tradeStyle = nCell.getCellStyle();

        // 处理大标题
        nRow = sheet.getRow(rowNo++); // 获取一个行对象
        nCell = nRow.getCell(colNo); // 获取一个单元格对象
        nCell.setCellValue(shipTime.replaceFirst("-0", "-").replaceFirst("-", "年") + "月份出货表"); // yyyy-MM

        rowNo++; // 跳过静态表格头

        // 处理内容
        List<OutProductVO> dataList = outProductVOService.findout(shipTime);
        for (int j = 0; j < dataList.size(); j++) {
            colNo = 1; // 初始化
            OutProductVO op = dataList.get(j);

            nRow = sheet.createRow(rowNo++);
            nRow.setHeightInPoints(24);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getCustomName());
            nCell.setCellStyle(customStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getContractNo());
            nCell.setCellStyle(contractNoStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getProductNo());
            nCell.setCellStyle(productNoStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getCnumber());
            nCell.setCellStyle(numStyle);


            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getDeliveryPeriod());
            nCell.setCellStyle(dateStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getShipTime());
            nCell.setCellStyle(dateStyle);

        }

        OutputStream os = new FileOutputStream("d:\\outproduct.xls");
        wb.write(os);

        os.flush();
        os.close();

//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        wb.write(os);
//
//        DownloadUtil downloadUtil = new DownloadUtil(); // 直接弹出下载框，用户可以打开，可以保存
//        downloadUtil.download(os, response, "出货表.xls");
//
//        os.flush();
//        os.close();
    }

    @RequestMapping("/outProductVO2")
    @ResponseBody
    public void outProductVO2(String shipTime, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // linux下jdk1.8 方法获取时，不会拼接自己写的目录
        String path = request.getSession().getServletContext().getRealPath("/") + "/make/xlsprint/";
        InputStream is = new FileInputStream(new File(path + "tOUTPRODUCT.xlsx"));

        Workbook wb = new XSSFWorkbook(is); // 打开一个模板文件，工作簿 2007以上版本
        Sheet sheet = wb.getSheetAt(0); // 获取到第一个工作表

        Row nRow = null;
        Cell nCell = null;
        int rowNo = 0; // 行号
        int colNo = 1; // 列号

        // 获取模板上的单元格样式
        nRow = sheet.getRow(2);

        // 客户的样式
        nCell = nRow.getCell(1);
        CellStyle customStyle = nCell.getCellStyle();

        // 订单号的样式
        nCell = nRow.getCell(2);
        CellStyle contractNoStyle = nCell.getCellStyle();

        // 货号的样式
        nCell = nRow.getCell(3);
        CellStyle productNoStyle = nCell.getCellStyle();

        // 数量的样式
        nCell = nRow.getCell(4);
        CellStyle numStyle = nCell.getCellStyle();

        // 生产厂家的样式
        nCell = nRow.getCell(5);
        CellStyle factoryStyle = nCell.getCellStyle();

        // 日期的样式
        nCell = nRow.getCell(6);
        CellStyle dateStyle = nCell.getCellStyle();

        // 贸易条款的样式
        nCell = nRow.getCell(8);
        CellStyle tradeStyle = nCell.getCellStyle();

        // 处理大标题
        nRow = sheet.getRow(rowNo++); // 获取一个行对象
        nCell = nRow.getCell(colNo); // 获取一个单元格对象
        nCell.setCellValue(shipTime.replaceFirst("-0", "-").replaceFirst("-", "年") + "月份出货表"); // yyyy-MM

        rowNo++; // 跳过静态表格头

        // 处理内容
        List<OutProductVO> dataList = outProductVOService.findout(shipTime);
        for (int j = 0; j < dataList.size(); j++) {
            colNo = 1; // 初始化
            OutProductVO op = dataList.get(j);

            nRow = sheet.createRow(rowNo++);
            nRow.setHeightInPoints(24);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getCustomName());
            nCell.setCellStyle(customStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getContractNo());
            nCell.setCellStyle(contractNoStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getProductNo());
            nCell.setCellStyle(productNoStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getCnumber());
            nCell.setCellStyle(numStyle);


            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getDeliveryPeriod());
            nCell.setCellStyle(dateStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getShipTime());
            nCell.setCellStyle(dateStyle);


        }

        OutputStream os = new FileOutputStream("d:\\outproduct.xls");
        wb.write(os);

        os.flush();
        os.close();
    }

    @RequestMapping("/outContrant")
    @ResponseBody
    public void outContrant(String contract_ID, HttpServletResponse response, HttpServletRequest request) throws IOException {
        List<Contract_c> selectcontractc = contract_cService.selectconall();
        for (Contract_c contractC : selectcontractc) {
            List<CONTRACT_PRODUCT_C> contractProductCS = contract_productService.selecttwo(contractC.getCONTRACT_ID());

            for (CONTRACT_PRODUCT_C contractProductC : contractProductCS) {
                List<Ext_cproduct_C> selectextpc = ext_cproduct_cService.selectthree(contractProductC.getCONTRACT_PRODUCT_ID());


            }
        }
        //创建excel文件

        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet也

        HSSFSheet sheet = wb.createSheet("客户信息表");

        //合并的单元格样式
        HSSFCellStyle Style = wb.createCellStyle();

        //创建标题行
        HSSFRow hr = sheet.createRow(0);
        hr.createCell(0).setCellValue("序号");
        hr.createCell(1).setCellValue("客户名称");
        hr.createCell(2).setCellValue("货物数/附件数");
        hr.createCell(3).setCellValue("签单日期");
        hr.createCell(4).setCellValue("制单人");
        hr.createCell(5).setCellValue("审单人");
        hr.createCell(6).setCellValue("验货员");
        hr.createCell(7).setCellValue("船期");
        hr.createCell(8).setCellValue("交货期限");
        hr.createCell(9).setCellValue("打印版式");
        hr.createCell(10).setCellValue("总金额");
        hr.createCell(11).setCellValue("状态");
        hr.createCell(12).setCellValue("合同号");
        int excl_id = 0;

        for (Contract_c contractCVo : selectcontractc) {
            excl_id++;
            HSSFRow datarow = sheet.createRow(sheet.getLastRowNum() + 1);
            datarow.createCell(0).setCellValue(excl_id);
            datarow.createCell(1).setCellValue(contractCVo.getCUSTOM_NAME());
            datarow.createCell(3).setCellValue(contractCVo.getSIGNING_DATE());
            datarow.createCell(4).setCellValue(contractCVo.getINPUT_BY());
            datarow.createCell(5).setCellValue(contractCVo.getCHECK_BY());
            datarow.createCell(6).setCellValue(contractCVo.getINPUT_BY());
            datarow.createCell(7).setCellValue(contractCVo.getSHIP_TIME());
            datarow.createCell(8).setCellValue(contractCVo.getDELIVERY_PERIOD());
            datarow.createCell(9).setCellValue(contractCVo.getPRINT_STYLE());
            datarow.createCell(10).setCellValue(contractCVo.getTOTAL_AMOUNT());
            datarow.createCell(11).setCellValue(contractCVo.getSTATE());
            datarow.createCell(12).setCellValue(contractCVo.getCONTRACT_NO());


            OutputStream os = new FileOutputStream("d:\\outproduct.xls");
            wb.write(os);

            os.flush();
            os.close();

        }

    }

    private HSSFCellStyle leftStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        curStyle.setWrapText(true);                        //换行
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置
        //fTitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	//加粗
        curFont.setFontHeightInPoints((short) 10);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        curStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);                //实线右边框
        curStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);                //实线右边框

        return curStyle;
    }

    private HSSFCellStyle headStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("Comic Sans MS");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        curFont.setItalic(true);
        curFont.setFontHeightInPoints((short) 16);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    private HSSFCellStyle tipStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("Georgia");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);    //加粗
        curFont.setFontHeightInPoints((short) 28);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    private HSSFCellStyle addressStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("宋体");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        //fTitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	//加粗
        curFont.setFontHeightInPoints((short) 10);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    private HSSFCellStyle ltdStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("Times New Roman");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);    //加粗
        curFont.setItalic(true);
        curFont.setFontHeightInPoints((short) 16);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    private HSSFCellStyle telStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("宋体");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        //fTitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	//加粗
        curFont.setFontHeightInPoints((short) 9);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    private HSSFCellStyle titleStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("黑体");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);    //加粗
        curFont.setFontHeightInPoints((short) 18);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    private HSSFCellStyle requestStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        curStyle.setWrapText(true);                        //换行
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("宋体");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        curFont.setFontHeightInPoints((short) 10);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    private HSSFCellStyle dutyStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("黑体");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);    //加粗
        curFont.setFontHeightInPoints((short) 16);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    private HSSFCellStyle noteStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("宋体");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);    //加粗
        curFont.setFontHeightInPoints((short) 12);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    public HSSFCellStyle thStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("宋体");
        curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);    //加粗
        curFont.setFontHeightInPoints((short) 12);
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        curStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);                //实线右边框
        curStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);                //实线右边框
        curStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);            //实线右边框
        curStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);                //实线右边框

        curStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    public HSSFCellStyle bcv12(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                        //设置字体
        curFont.setFontName("Times New Roman");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);            //设置中文字体，那必须还要再对单元格进行编码设置

        curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);        //加粗
        curFont.setFontHeightInPoints((short) 12);
        curStyle.setFont(curFont);

        curStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);                //实线
        curStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);            //粗实线
        curStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);            //实线
        curStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);                //实线

        curStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    //大标题样式
    private CellStyle bigTitleStyle(Workbook wb) {
        CellStyle curStyle = wb.createCellStyle();
        Font curFont = wb.createFont();

        curFont.setFontName("宋体");
        curFont.setFontHeightInPoints((short) 16);
        curFont.setBoldweight(Font.BOLDWEIGHT_BOLD); // 字体加粗

        curStyle.setFont(curFont); // 绑定字体

        curStyle.setAlignment(CellStyle.ALIGN_CENTER); // 横向居中
        curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 纵向居中

        return curStyle;
    }


    // 小标题样式
    private CellStyle titleStyle(Workbook wb) {
        CellStyle curStyle = wb.createCellStyle();
        Font curFont = wb.createFont();

        curFont.setFontName("黑体");
        curFont.setFontHeightInPoints((short) 12);

        curStyle.setFont(curFont); // 绑定字体

        curStyle.setAlignment(CellStyle.ALIGN_CENTER); // 横向居中
        curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 纵向居中

        curStyle.setBorderTop(CellStyle.BORDER_THIN); // 设置四周边线，细线
        curStyle.setBorderBottom(CellStyle.BORDER_THIN);
        curStyle.setBorderLeft(CellStyle.BORDER_THIN);
        curStyle.setBorderRight(CellStyle.BORDER_THIN);

        return curStyle;
    }

    // 文字样式
    private CellStyle textStyle(Workbook wb, CellStyle curStyle, Font curFont) {

        curFont.setFontName("Times New Roman");
        curFont.setFontHeightInPoints((short) 10);

        curStyle.setFont(curFont); // 绑定字体

        curStyle.setAlignment(CellStyle.ALIGN_LEFT); // 横向居左
        curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 纵向居中

        curStyle.setBorderTop(CellStyle.BORDER_THIN); // 设置四周边线，细线
        curStyle.setBorderBottom(CellStyle.BORDER_THIN);
        curStyle.setBorderLeft(CellStyle.BORDER_THIN);
        curStyle.setBorderRight(CellStyle.BORDER_THIN);

        return curStyle;
    }

    @RequestMapping("/selectexportRM")
    @ResponseBody
    public R selectexportRM() {
        List<Export> exports = exportService.find();
        if (exports != null) {
            return R.ok().data("exports", exports);
        } else {
            return R.error().message("查询失败");
        }

    }

    @RequestMapping("/insertexport")
    @ResponseBody
    public R insertexport(String userList) {
        String[] strs = userList.split(",");
        String contractNos = "";
        for (int i = 0; i < strs.length; i++) {
            Contract_c selectcontbyid = contract_cService.selectcontbyid(strs[i]);
            contractNos += selectcontbyid.getCONTRACT_NO() + " ";
        }
        contractNos = UtilFuns.delLastChar(contractNos);

        Export export = new Export();
        export.setEXPORT_ID(UUID.randomUUID().toString());
        export.setCONTRACT_IDS(UtilFuns.joinStr(userList, ","));
        export.setCUSTOMER_CONTRACT(contractNos);

        export.setSTATE(0);
        exportService.insertexport(export);

        for (int i = 0; i < strs.length; i++) {
            Contract_c selectcontbyid = contract_cService.selectcontbyid(strs[i]);
            List<CONTRACT_PRODUCT_C> selecttwo = contract_productService.selecttwo(selectcontbyid.getCONTRACT_ID());
            for (int j = 0; j < selecttwo.size(); j++) {
                Exportproduct ep = new Exportproduct();
                ep.setEXPORT_PRODUCT_ID(UUID.randomUUID().toString());
                ep.setEXPORT_ID(export.getEXPORT_ID());


                ep.setPRODUCT_NO(selecttwo.get(j).getPRODUCT_NO());
                ep.setPACKING_UNIT(selecttwo.get(j).getPACKING_UNIT());
                ep.setCNUMBER(selecttwo.get(j).getCNUMBER());
                ep.setBOX_NUM(selecttwo.get(j).getBOX_NUM());
                ep.setPRICE(selecttwo.get(j).getPRICE());
                exportproductService.insertexport(ep);
                List<Ext_cproduct_C> selectthree = ext_cproduct_cService.selectthree(selecttwo.get(j).getCONTRACT_PRODUCT_ID());
                for (int k = 0; k < selectthree.size(); k++) {
                    ExtEproduct extep = new ExtEproduct();
                    extep.setEXT_EPRODUCT_ID(UUID.randomUUID().toString());
                    extep.setEXPORT_PRODUCT_ID(ep.getEXPORT_PRODUCT_ID());

                    extep.setFACTORY_ID(selectthree.get(k).getFactory_c().getFACTORY_ID().toString());
                    extEproductService.insertexe(extep);
                }
            }
        }

        return R.ok().message("添加成功");

    }

    @RequestMapping("/selectpacking")
    @ResponseBody
    public R selectpacking() {
        List<packing> packings = packingService.find();
        if (packings != null) {
            return R.ok().data("packings", packings);
        } else {
            return R.error().message("查询失败");
        }

    }

    @RequestMapping("/selectpackbyid")
    @ResponseBody
    public R selectpackbyid(String userList, HttpServletRequest request) {
        String[] strs = userList.split(",");

        String divDataCreate = packingService.getDivDataCreate(strs);


        return R.ok().data("divDataCreate", divDataCreate);


    }

    @RequestMapping("/selectpackbyidss")
    @ResponseBody
    public R selectpackbyidss(String packing_LIST_ID) {
        packing selectbyid = packingService.selectbyid(packing_LIST_ID);
        String divDataUpdate = packingService.getDivDataUpdate(selectbyid.getEXPORT_IDS().split("\\|"), selectbyid.getEXPORT_NOS().split("\\|"));
        Map<String, Object> map = new HashMap<>();
        map.put("selectbyid", selectbyid);
        map.put("divData", divDataUpdate);

        return R.ok().data(map);


    }

    @RequestMapping("/selectpackbyidss1")
    @ResponseBody
    public R selectpackbyidss1(String packing_LIST_ID) {
        packing selectbyid = packingService.selectbyid(packing_LIST_ID);
        String divDataUpdate = packingService.getDivDataView(selectbyid.getEXPORT_NOS().split("\\|"));
        Map<String, Object> map = new HashMap<>();
        map.put("selectbyid", selectbyid);
        map.put("divData", divDataUpdate);

        return R.ok().data(map);


    }

    @RequestMapping("/packinsert")
    @ResponseBody
    public R packinsert(packing packing) {
        int insert = packingService.insert(packing);
        if (insert != 0) {
            return R.ok().message("添加成功");
        } else {
            return R.error().message("添加失败");
        }

    }

    @RequestMapping("/packupdate")
    @ResponseBody
    public R packupdate(packing packing) {
        int insert = packingService.update(packing);
        if (insert != 0) {
            return R.ok().message("修改成功");
        } else {
            return R.error().message("修改失败");
        }

    }

    @RequestMapping("/sefactoryall")
    public String sefactoryall(HttpServletRequest request, Model model) throws FileNotFoundException {
        //真实路径
        String path = request.getSession().getServletContext().getRealPath("/");

        //1、组织数据源
        String sql = "SELECT f.factory_name,cp.countnum FROM (SELECT factory_id,factory_name FROM factory_c) f RIGHT JOIN (SELECT factory_id,COUNT(*) AS countnum FROM contract_product_c GROUP BY factory_id ) cp ON f.factory_id=cp.factory_id";
        //List<String>
        List<String> dataList = sqlao.executeSQL(sql);
        System.out.println(dataList.size());
        //2、拼接成xml
        //拼接数据为一个xml字符串
        StringBuffer sBuf = new StringBuffer();
        sBuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sBuf.append("<pie>");
        for (int i = 0; i < dataList.size(); ) {
            // 在for循环内部控制当前记录标识
            sBuf.append("  <slice title=\"").append(dataList.get(i++)).append("\">").append(dataList.get(i++)).append("</slice>");
        }
        sBuf.append("</pie>");

        //3、创建一个文件txt格式，xml 工具类
        //输出文件，如果目录下没有文件，直接创建；如果目录下文件存在，覆盖。
        FileUtil fu = new FileUtil();
        fu.createTxt(path + "/stat/chart/factorysale", "data.xml", sBuf.toString(), "utf-8");
        model.addAttribute("forword", "/stat/chart/factorysale");
        return "sefactoryall";
    }

    //    @RequestMapping("/factorysale")
//    public String factorysale(){
//        return "/stat/chart/factorysale/index";
//    }
    @RequestMapping("/productSaleall")
    public String productSaleall(HttpServletRequest request, Model model) throws FileNotFoundException {
        // 真实路径
        String path = request.getSession().getServletContext().getRealPath("/");

        //mysql
        //String sql = "SELECT product_no,SUM(cnumber) AS sumnum FROM contract_product_c GROUP BY product_no ORDER BY SUM(cnumber)  DESC LIMIT 15";

        //oracle
        String sql = "select t.* from(select product_no,sum(cnumber) as sumnum from contract_product_c group by product_no order by sum(cnumber) desc) t where rownum<=15";
        List<String> dataList = sqlao.executeSQL(sql);
        System.out.println(dataList.size());

        StringBuffer sBuf = new StringBuffer();
        sBuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sBuf.append("<chart>");
        sBuf.append("<series>");

        int xid = 0;            //对应标识
        for (int i = 0; i < dataList.size(); ) {
            sBuf.append("<value xid=\"").append(xid++).append("\">").append(dataList.get(i++)).append("</value>");
            i++;        //skip
        }
        sBuf.append("</series>");
        sBuf.append("<graphs>");
        sBuf.append("<graph gid=\"30\" color=\"#FFCC00\" gradient_fill_colors=\"#111111, #1A897C\">");

        xid = 0;//重新初始化
        for (int i = 0; i < dataList.size(); ) {
            i++;        //skip
            sBuf.append("<value xid=\"").append(xid++).append("\">").append(dataList.get(i++)).append("</value>");
        }

        sBuf.append("</graph>");
        sBuf.append("</graphs>");
        sBuf.append("</chart>");

        FileUtil fu = new FileUtil();
        fu.createTxt(path + "/stat/chart/productsale", "data.xml", sBuf.toString(), "utf-8");


        model.addAttribute("forword", "/stat/chart/productsale");

        return "sefactoryall";
    }

    @RequestMapping("/onlineInfo")
    public String onlineInfo(HttpServletRequest request, Model model) throws FileNotFoundException {
        String path = request.getSession().getServletContext().getRealPath("/");

        //mysql
        String sql = "SELECT t.a1,p.countnum FROM (SELECT a1 FROM online_t) t LEFT JOIN (SELECT SUBSTR(login_time,12,2) AS a1,COUNT(*) AS countnum FROM login_log_p GROUP BY SUBSTR(login_time,12,2)) p ON t.a1=p.a1";
        List<String> dataList = sqlao.executeSQL(sql);

        StringBuffer sBuf = new StringBuffer();
        sBuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sBuf.append("<chart>");
        sBuf.append("<series>");

        int xid = 0;            //对应标识
        for (int i = 0; i < dataList.size(); ) {
            sBuf.append("<value xid=\"").append(xid++).append("\">").append(dataList.get(i++)).append("</value>");
            i++;        //skip
        }
        sBuf.append("</series>");
        sBuf.append("<graphs>");
        sBuf.append("<graph gid=\"30\" color=\"#FFCC00\" gradient_fill_colors=\"#111111, #1A897C\">");

        xid = 0;//重新初始化
        for (int i = 0; i < dataList.size(); ) {
            i++;        //skip
            sBuf.append("<value xid=\"").append(xid++).append("\">").append(dataList.get(i++)).append("</value>");
        }

        sBuf.append("</graph>");
        sBuf.append("</graphs>");
        sBuf.append("</chart>");

        FileUtil fu = new FileUtil();
        fu.createTxt(path + "/stat/chart/onlineinfo", "data.xml", sBuf.toString(), "utf-8");

        model.addAttribute("forword", "/stat/chart/onlineinfo");

        return "sefactoryall";
    }
}
