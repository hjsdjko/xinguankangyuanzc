package com.dao;

import com.entity.JianceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JianceView;

/**
 * 检测记录 Dao 接口
 *
 * @author 
 */
public interface JianceDao extends BaseMapper<JianceEntity> {

   List<JianceView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
