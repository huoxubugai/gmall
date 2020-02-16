package com.atguigu.gmall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsBaseCatalog2;
import com.atguigu.gmall.bean.PmsBaseCatalog3;
import com.atguigu.gmall.service.CatalogService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CatalogController {

    @Reference
    CatalogService catalogService;

    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(){
        List<PmsBaseCatalog1> catalog1=catalogService.getCatalog1();
        return catalog1;
    }

    @RequestMapping("getCatalog2ByCatalog1Id")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2ByCatalog1Id( String catalog1Id){
        List<PmsBaseCatalog2> catalog2s = catalogService.getCatalog2ByCatalog1Id(catalog1Id);
        return catalog2s;
    }

    @RequestMapping("getCatalog3ByCatalog2Id")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3ByCatalog2Id(String catalog2Id){
        return catalogService.getCatalog3ByCatalog2Id(catalog2Id);
    }

}
