package com.walt.controller;


import com.walt.common.DataGridView;
import com.walt.service.IBilltypeService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前端控制器
 *
 * @author walt1012
 * @since 2020-01-09
 */
@RestController
@RequestMapping("/billtype")
public class BilltypeController {

    @Reference
    private IBilltypeService billtypeService;

    //查询所有类型
    @RequestMapping("loadAllBillType")
    public DataGridView loadAllBillType() {
        DataGridView dataGridView = this.billtypeService.queryAllBillType();
        return new DataGridView(dataGridView);
    }
}
