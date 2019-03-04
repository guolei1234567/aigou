package com.guolei.aigou.service;

import com.baomidou.mybatisplus.service.IService;
import com.guolei.aigou.domain.Brand;
import com.guolei.aigou.query.BrandQuery;
import com.guolei.aigou.utils.PageList;

/**
 * <p>
 * 品牌信息 服务类
 * </p>
 *
 * @author Taurus
 * @since 2019-02-28
 */
public interface IBrandService extends IService<Brand> {
    PageList<Brand> productTypePage(BrandQuery query);

}
