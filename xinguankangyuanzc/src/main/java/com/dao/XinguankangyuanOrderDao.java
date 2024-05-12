package com.dao;

import com.entity.XinguankangyuanOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XinguankangyuanOrderView;

/**
 * 新冠抗原订单 Dao 接口
 *
 * @author 
 */
public interface XinguankangyuanOrderDao extends BaseMapper<XinguankangyuanOrderEntity> {

   List<XinguankangyuanOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
