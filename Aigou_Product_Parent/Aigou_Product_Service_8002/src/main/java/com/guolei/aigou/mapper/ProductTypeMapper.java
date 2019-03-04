package com.guolei.aigou.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.guolei.aigou.domain.ProductType;

import java.util.List;

/**
 * <p>
 * 商品目录 Mapper 接口
 * </p>
 *
 * @author Taurus
 * @since 2019-02-28
 */
public interface ProductTypeMapper extends BaseMapper<ProductType> {
   List<ProductType> get(Long id);
}
