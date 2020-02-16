package com.atguigu.gmall.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;
import com.atguigu.gmall.manager.mapper.PmsBaseAttrInfoMapper;
import com.atguigu.gmall.manager.mapper.PmsBaseAttrValueMapper;
import com.atguigu.gmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@EnableDubbo
public class AttrServiceImpl implements AttrService {

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;


    /**
     * AttrInfo表的增 删 改 查
     */
    @Override
    public int insertAttrInfo(PmsBaseAttrInfo attrInfo) {
//        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
////      pmsBaseAttrInfo.setId(attrInfo.getId());
//        pmsBaseAttrInfo.setAttrName(attrInfo.getAttrName());
//        pmsBaseAttrInfo.setCatalog3Id(attrInfo.getCatalog3Id());
        int insertLines = pmsBaseAttrInfoMapper.insert(attrInfo);
        for (PmsBaseAttrValue info:attrInfo.getAttrValueList()) {
            info.setAttrId(attrInfo.getId());
            pmsBaseAttrValueMapper.insertSelective(info);
        }

        //sql: INSERT INTO pms_base_attr_info ( id,attr_name,catalog3_id,is_enabled ) VALUES( ?,?,?,? )
        //id为主键，不写id会默认自增
        return insertLines;
    }

    @Override
    public int deleteAttrInfoById(String id) {
        int deleteLines = pmsBaseAttrInfoMapper.deleteByPrimaryKey(id);
        return deleteLines;
    }

    @Override
    public int updateAttrInfoById(PmsBaseAttrInfo pmsBaseAttrInfo) {
        PmsBaseAttrInfo updateAttrInfo = new PmsBaseAttrInfo();
        updateAttrInfo.setId(pmsBaseAttrInfo.getId());
        updateAttrInfo.setAttrName(pmsBaseAttrInfo.getAttrName());
        updateAttrInfo.setCatalog3Id(pmsBaseAttrInfo.getCatalog3Id());
        int updateLines = pmsBaseAttrInfoMapper.updateByPrimaryKeySelective(updateAttrInfo);
        //sql语句：UPDATE pms_base_attr_info SET attr_name = ?,catalog3_id = ? WHERE id = ?
        return updateLines;
    }

    @Override
    public List<PmsBaseAttrInfo> getAttrInfoByCatalog3Id(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> attrInfos = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
        return attrInfos;
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueByAttrId(String attrId) {
        PmsBaseAttrValue attrValue = new PmsBaseAttrValue();
        attrValue.setAttrId(attrId);
        List<PmsBaseAttrValue> attrValues = pmsBaseAttrValueMapper.select(attrValue);
        return attrValues;
    }


}
