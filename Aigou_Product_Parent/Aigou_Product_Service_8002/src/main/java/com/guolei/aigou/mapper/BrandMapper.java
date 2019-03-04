package com.guolei.aigou.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.guolei.aigou.domain.Brand;
import com.guolei.aigou.query.BrandQuery;

import java.util.List;

/**
 * <p>
 * 品牌信息 Mapper 接口
 * </p>
 *
 * @author Taurus
 * @since 2019-02-28
 */
public interface BrandMapper extends BaseMapper<Brand> {

    List<Brand> selectPageList(Page<Brand> page, BrandQuery query);

    long queryPageCount(BrandQuery query);
}
