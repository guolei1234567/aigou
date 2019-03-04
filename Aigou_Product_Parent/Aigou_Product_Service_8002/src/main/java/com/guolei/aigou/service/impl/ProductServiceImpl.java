package com.guolei.aigou.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.guolei.aigou.domain.Product;
import com.guolei.aigou.mapper.ProductMapper;
import com.guolei.aigou.service.IProductService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author Taurus
 * @since 2019-02-28
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {


}
