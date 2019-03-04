package com.guolei.aigou.service;

import com.baomidou.mybatisplus.service.IService;
import com.guolei.aigou.domain.ProductType;

import java.util.List;

/**
 * <p>
 * 商品目录 服务类
 * </p>
 *
 * @author Taurus
 * @since 2019-02-28
 */
public interface IProductTypeService extends IService<ProductType> {

    List<ProductType> getTreeData();

}
