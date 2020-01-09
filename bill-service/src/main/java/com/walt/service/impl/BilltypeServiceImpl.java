package com.walt.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.walt.common.DataGridView;
import com.walt.domain.Billtype;
import com.walt.mapper.BilltypeMapper;
import com.walt.service.IBilltypeService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * 服务实现类
 *
 * @author walt1012
 * @since 2020-01-09
 */
@Service
public class BilltypeServiceImpl implements IBilltypeService {

    @Resource
    private BilltypeMapper billtypeMapper;

    @Override
    public DataGridView queryAllBillType() {
        List<Billtype> list = billtypeMapper.selectList(null);
        return new DataGridView(Long.valueOf(list.size()), list);
    }
}
