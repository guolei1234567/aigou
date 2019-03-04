package com.guolei.aigou.mapper;

import com.guolei.aigou.domain.Product;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.guolei.aigou.domain.ProductType;
import com.guolei.aigou.query.ProductTypeQuery;
import com.guolei.aigou.utils.PageList;

/**
 * <p>
 * 商品 Mapper 接口
 * </p>
 *
 * @author Taurus
 * @since 2019-02-28
 */
public interface ProductMapper extends BaseMapper<Product> {

    PageList<ProductType> productTypePage(ProductTypeQuery query);
}
