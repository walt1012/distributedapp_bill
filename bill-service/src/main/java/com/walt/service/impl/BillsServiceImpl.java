package com.walt.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.walt.common.DataGridView;
import com.walt.domain.Bills;
import com.walt.domain.Billtype;
import com.walt.mapper.BillsMapper;
import com.walt.mapper.BilltypeMapper;
import com.walt.service.IBillsService;
import com.walt.vo.BillsVo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 服务实现类
 *
 * @author walt1012
 * @since 2020-01-09
 */
@Service
public class BillsServiceImpl implements IBillsService {

    @Autowired
    private BillsMapper billsMapper;

    @Autowired
    private BilltypeMapper billtypeMapper;

    @Override
    public DataGridView queryAllBills(BillsVo billsVo) {
        Page<Bills> billsPage = new Page<>(billsVo.getPage(), billsVo.getLimit());
        QueryWrapper<Bills> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(billsVo.getTypeid() != null, "typeid", billsVo.getTypeid());

        queryWrapper.ge(billsVo.getStartTime() != null, "billtime", billsVo.getStartTime());
        queryWrapper.le(billsVo.getEndTime() != null, "billtime", billsVo.getEndTime());
        queryWrapper.orderByDesc("billtime");
        List<Bills> records = billsMapper.selectPage(billsPage, queryWrapper).getRecords();
        records.forEach(bills -> {
            Billtype billtype = billtypeMapper.selectById(bills.getTypeid());
            bills.setTypename(billtype.getName());
        });
        return new DataGridView(billsPage.getTotal(), records);
    }

    @Override
    public void addBills(Bills bills) {
        bills.setBilltime(new Date());
        this.billsMapper.insert(bills);
    }
}
