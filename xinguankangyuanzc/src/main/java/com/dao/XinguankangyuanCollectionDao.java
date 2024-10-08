package com.dao;

import com.entity.XinguankangyuanCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XinguankangyuanCollectionView;

/**
 * 新冠抗原收藏 Dao 接口
 *
 * @author 
 */
public interface XinguankangyuanCollectionDao extends BaseMapper<XinguankangyuanCollectionEntity> {

   List<XinguankangyuanCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
