package com.dao;

import com.entity.XinguankangyuanLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XinguankangyuanLiuyanView;

/**
 * 新冠抗原留言 Dao 接口
 *
 * @author 
 */
public interface XinguankangyuanLiuyanDao extends BaseMapper<XinguankangyuanLiuyanEntity> {

   List<XinguankangyuanLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
