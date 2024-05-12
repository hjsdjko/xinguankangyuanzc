package com.dao;

import com.entity.FanghuzhishiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FanghuzhishiCollectionView;

/**
 * 防护知识收藏 Dao 接口
 *
 * @author 
 */
public interface FanghuzhishiCollectionDao extends BaseMapper<FanghuzhishiCollectionEntity> {

   List<FanghuzhishiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
