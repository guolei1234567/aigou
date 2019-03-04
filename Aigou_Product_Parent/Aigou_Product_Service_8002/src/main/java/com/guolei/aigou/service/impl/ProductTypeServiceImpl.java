package com.guolei.aigou.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.guolei.aigou.client.RedisClient;
import com.guolei.aigou.domain.ProductType;
import com.guolei.aigou.mapper.ProductTypeMapper;
import com.guolei.aigou.service.IProductTypeService;
import com.guolei.aigou.utils.constants.GlobelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品目录 服务实现类
 * </p>
 *
 * @author Taurus
 * @since 2019-02-28
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements IProductTypeService {
    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Autowired
    private RedisClient redisClient;

//递归
/*    @Override
    public List<ProductType> getTreeData() {
        return getTreeDataRecursion();
    }*/

    @Override
    public List<ProductType> getTreeData() {
        return treeDataLoop();
    }

    /**
     * 递归获取无限极数据
     * ①自己调用自己
     * ②要有出口
     *
     * @return
     */
    private List<ProductType> getTreeDataRecursion(Long id) {

        //0   每次都要发送sql
        List<ProductType> children = getAllChildren(id); //1 2
        //出口
        if (children == null || children.size()<1){
            return null;
        }
        for (ProductType productType : children) {
            //1 3 4 自己调用自己
            List<ProductType> children1 = getTreeDataRecursion(productType.getId());
            productType.setChildren(children1);
        }
        return children;

    }

    private List<ProductType> getAllChildren(Long pid){
        Wrapper wrapper = new EntityWrapper<ProductType>();
        wrapper.eq("pid", pid);
        return productTypeMapper.selectList(wrapper);
    }


    /**
     * 使用循环方式:
     *   我们期望发送一条sql,把所有的子子孙孙的结构搞出来,但是搞不出来的;
     *   但是我们可以发送一条sql:把所有的数据拿回来,存在内存中,我可以写代码组装他的结构(在内存中完成的).
     * @return
     */
    private List<ProductType> treeDataLoopq() {

        //1:获取所有的数据:
        List<ProductType> allProductType = productTypeMapper.selectList(null);

        //2:用于存在每一个对象和他的一个标识的 Long:id
        Map<Long,ProductType> map=new HashMap<>();
        for (ProductType productType : allProductType) {
            map.put(productType.getId(), productType);
        }

        //最终想要的结果:
        List<ProductType> result = new ArrayList<>();
        //3:遍历
        for (ProductType productType : allProductType) {
            //组装结构: productType:每一个对象:
            Long pid = productType.getPid();
            if(pid==0){
                result.add(productType);
            }else{
                // 找自己的老子,把自己添加到老子的儿子中
                ProductType parent=map.get(pid);// where id =pid
               //* //我老子的儿子
                List<ProductType> children = parent.getChildren();
                //把我自己放入老子的儿子中
                children.add(productType);//*
                parent.getChildren().add(productType);
            }
        }
        return result;
    }
    private List<ProductType> treeDataLoop() {


        //先根据key,从redis获取:我是producttype的服务提供者,我要调用公共服务的redis,则是redis的消费者:
        //java内部的服务的调用,就应该使用feign或者ribbon:选中feign:
        //feign的使用:是在消费者,注入接口,就象调用本地接口一样

        //判断是否有结果:有就直接返回,没有就从数据库获取,存入redis,并返回
        String jsonArrStr = redisClient.get(GlobelConstants.REDIS_PRODUCTTYPE_KEY);
        if(StringUtils.isEmpty(jsonArrStr)){
            //没有就从数据库获取,存入redis,并返回
            System.out.println("存入redis");
            List<ProductType> productTypes = treeDataLoopq();
            jsonArrStr= JSONArray.toJSONString(productTypes);
            //redis存入
            redisClient.set(GlobelConstants.REDIS_PRODUCTTYPE_KEY,jsonArrStr );
            System.out.println("from========db===============");
            return productTypes;
        }else{
            //有:有就直接返回wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            //json的数组字符串--->json数组
            System.out.println("from========cache===============");
            return JSONArray.parseArray(jsonArrStr, ProductType.class);
        }
    }
}
