package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface BrandMapper extends Mapper<Brand> {
    @Insert(" insert into tb_category_brand(category_id,brand_id) values( #{cid} , #{bid}) ")
    void insertCategoryAndBrand( @Param("cid") Long cid, @Param("bid") Long bid);

    //根据商品分类id，查询对应品牌
    @Select("SELECT b.* from tb_brand b INNER JOIN tb_category_brand cb on b.id=cb.brand_id where cb.category_id=#{cid}")
    List<Brand> selectBrandByCid(Long cid);

    //根据商品id，查询对应品牌
    @Select("select t.* from tb_brand t where t.id= #{id}")
    Brand queryBrandById(@Param("id") Long id);
}
