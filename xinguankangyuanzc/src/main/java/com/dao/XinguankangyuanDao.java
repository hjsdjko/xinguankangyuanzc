package com.dao;

import com.entity.XinguankangyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XinguankangyuanView;

/**
 * 新冠抗原 Dao 接口
 *
 * @author 
 */
public interface XinguankangyuanDao extends BaseMapper<XinguankangyuanEntity> {

   List<XinguankangyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
