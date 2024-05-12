package com.dao;

import com.entity.FanghuzhishiLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FanghuzhishiLiuyanView;

/**
 * 防护知识留言 Dao 接口
 *
 * @author 
 */
public interface FanghuzhishiLiuyanDao extends BaseMapper<FanghuzhishiLiuyanEntity> {

   List<FanghuzhishiLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
