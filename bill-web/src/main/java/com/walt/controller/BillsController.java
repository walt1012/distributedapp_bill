package com.walt.controller;


import com.walt.common.DataGridView;
import com.walt.common.ResultObj;
import com.walt.domain.Bills;
import com.walt.service.IBillsService;
import com.walt.vo.BillsVo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前端控制器
 *
 * @author walt1012
 * @since 2020-01-09
 */
@RestController
@RequestMapping("/bills")
public class BillsController {

    @Reference
    private IBillsService billsService;

    //分页查询账单
    @GetMapping("loadAllBills")
    public DataGridView loadAllBills(BillsVo billsVo) {
        return this.billsService.queryAllBills(billsVo);
    }

    //添加
    @PostMapping("addBills")
    public ResultObj addBills(Bills bills) {
        try {
            this.billsService.addBills(bills);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
}
