package com.walt.vo;

import com.walt.domain.Bills;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @FileName: bill-parent
 * @Author: wushang
 * @Description: TODO
 * @Date: 2020/1/9 8:59 下午
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class BillsVo extends Bills {

    private static final long serialVersionUID = 1L;

    private Integer page;

    private Integer limit;

    private Date startTime;

    private Date endTime;

}
