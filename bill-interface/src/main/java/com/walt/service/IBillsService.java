package com.walt.service;


import com.walt.common.DataGridView;
import com.walt.domain.Bills;
import com.walt.vo.BillsVo;

/**
 * @author walt1012
 * @since 2020-01-09
 */
public interface IBillsService {

    //全查询
    public DataGridView queryAllBills(BillsVo billsVo);

    //添加
    public void addBills(Bills bills);
}
