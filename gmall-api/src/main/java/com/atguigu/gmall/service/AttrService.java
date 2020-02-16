package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;

import java.util.List;

public interface AttrService {
    List<PmsBaseAttrInfo> getAttrInfoByCatalog3Id(String catalog3Id);

    List<PmsBaseAttrValue> getAttrValueByAttrId(String attrId);

    int insertAttrInfo(PmsBaseAttrInfo attrInfo);

    int deleteAttrInfoById(String id);

    int updateAttrInfoById(PmsBaseAttrInfo pmsBaseAttrInfo);
}
