package com.walt.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @FileName: bill-parent
 * @Author: wushang
 * @Description: TODO
 * @Date: 2020/1/8 10:21 下午
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DataGridView implements Serializable {
    private Integer code = 0;
    private String msg = "";
    private Long count;
    private Object data;

    private static final long serialVersionUID = 1L;

    public DataGridView(Long count, Object data) {
        this.count = count;
        this.data = data;
    }

    public DataGridView(Object data) {
        this.data = data;
    }
}
