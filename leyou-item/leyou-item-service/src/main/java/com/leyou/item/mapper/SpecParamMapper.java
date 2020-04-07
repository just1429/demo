package com.leyou.item.mapper;

import com.leyou.item.pojo.SpecParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface SpecParamMapper extends Mapper<SpecParam> {
    @Delete("delete from tb_spec_param where id = #{id}")
    void deleteParamById(@Param("id") Long id);

    @Insert("insert into tb_spec_param(cid,group_id,name,`numeric`,unit,generic,searching,segments)" +
            "values(#{cid},#{groupId},#{name},#{numeric},#{unit},#{generic},#{searching},#{segments})")
    void saveParam(@Param("cid") Long cid, @Param("groupId")Long groupId, @Param("name")String name,
                         @Param("numeric")Boolean numeric, @Param("unit")String unit, @Param("generic")Boolean generic,
                         @Param("searching")Boolean searching, @Param("segments")String segments);
}
