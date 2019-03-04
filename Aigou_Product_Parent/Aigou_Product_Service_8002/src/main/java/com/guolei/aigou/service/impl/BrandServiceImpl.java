package com.guolei.aigou.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.guolei.aigou.domain.Brand;
import com.guolei.aigou.mapper.BrandMapper;
import com.guolei.aigou.query.BrandQuery;
import com.guolei.aigou.service.IBrandService;
import com.guolei.aigou.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 品牌信息 服务实现类
 * </p>
 *
 * @author Taurus
 * @since 2019-02-28
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public PageList<Brand> productTypePage(BrandQuery query) {

        Page<Brand> page = new Page<>(query.getPage(), query.getRows());
        //当我们传入Page,表示要做分页查询,会把查询总数设置在Page的total

        System.out.println("=========query======="+query);
        System.out.println("==========page==========="+page);
        List<Brand> rows = brandMapper.selectPageList(page,query);
        System.out.println("==========rows==========="+rows);
        //PageList total,rows
        long total = page.getTotal();
        System.out.println("===========total==========="+total);

        return new PageList<>(total,rows);

        //分页查询: 以前在分页查询的时候:需要两个请求:总的条数和当前分页的数据
        //1:设置总的页数
/*        PageList<Brand> pageList = new PageList<>();
        long totalcount = brandMapper.queryPageCount(query);
        if (totalcount > 0) {
            pageList.setTotal(totalcount);
            //2:设置当前分页数据:
            // Mapper.xml中查询的是分页的数据:rows
            List<Brand> brands = brandMapper.selectPageList(query);
            System.out.println(brands);
            pageList.setRows(brands);
        }

        return pageList;*/
    }
}
