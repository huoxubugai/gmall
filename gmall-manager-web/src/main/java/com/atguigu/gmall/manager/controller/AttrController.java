package com.atguigu.gmall.manager.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;
import com.atguigu.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AttrController {

    @Reference
    AttrService attrService;

    /**
     * AttrInfo表的增删改查
     */

    @RequestMapping("insertAttrInfo")
    @ResponseBody
    public int insertAttrInfo(@RequestBody  PmsBaseAttrInfo attrInfo) {
        int insertLines = attrService.insertAttrInfo(attrInfo);
        return insertLines;
    }

    @RequestMapping("deleteAttrInfoById")
    @ResponseBody
    public int deleteAttrInfoById(String id) {
        int deleteLines = attrService.deleteAttrInfoById(id);
        return deleteLines;
    }

    @RequestMapping("updateAttrInfoById")
    @ResponseBody
    //RequestBody接受json格式数据
    public int updateAttrInfoById(@RequestBody  PmsBaseAttrInfo pmsBaseAttrInfo) {
        int updateLines = attrService.updateAttrInfoById(pmsBaseAttrInfo);
        return updateLines;
    }

    @RequestMapping("getAttrInfoByCatalog3Id")
    @ResponseBody
    public List<PmsBaseAttrInfo> getAttrInfoByCatalog3Id(String catalog3Id) {
        List<PmsBaseAttrInfo> attrInfos = attrService.getAttrInfoByCatalog3Id(catalog3Id);
        return attrInfos;
    }

    @RequestMapping("getAttrValueByAttrId")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueByAttrId(String attrId) {
        List<PmsBaseAttrValue> pmsBaseAttrValues = attrService.getAttrValueByAttrId(attrId);
        return pmsBaseAttrValues;
    }
}
