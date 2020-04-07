package com.leyou.item.controller;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("brand")
@Api(tags = "品牌管理")
public class BrandController {

    @Autowired
    private BrandService brandService;
    /**
     * 根据查询条件分页并排序查询品牌信息
     * @param key
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    @GetMapping("page")
    @ApiOperation(value = "分页查询品牌")
    public ResponseEntity<PageResult<Brand>> queryBrandsByPage(
           @ApiParam(name = "key" , value = "根据name模糊查询" ) @RequestParam(value = "key" , required = false ) String key,
           @ApiParam(name = "page" , value = "页码" ) @RequestParam(value = "page", defaultValue = "1")Integer page,
           @ApiParam(name = "rows" , value = "每页显示几条数据" ) @RequestParam(value = "rows", defaultValue = "5")Integer rows,
           @ApiParam(name = "sortBy" , value = "排序条件" ) @RequestParam(value = "sortBy", required = false)String sortBy,
           @ApiParam(name = "desc" , value = "是否排序" ) @RequestParam(value = "desc", required = false)Boolean desc
    ){
        PageResult<Brand> brandPageResult = this.brandService.queryBrandsByPage(key, page, rows, sortBy, desc);
        if(CollectionUtils.isEmpty(brandPageResult.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(brandPageResult);
    }


    /**
     * 新增品牌
     *
     * @param brand
     * @param cids
     */
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam("cids") List<Long> cids){
        this.brandService.saveBrand(brand, cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * @Author huangcf
     * @根据商品分类id，查询对应品牌
     * @Date  2020/3/26 10:39
     */
    @GetMapping("cid/{cid}")
    public ResponseEntity<List<Brand>> queryBrandsByCid(@PathVariable("cid")Long cid){
        List<Brand> brands = this.brandService.queryBrandsByCid(cid);
        if (CollectionUtils.isEmpty(brands)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(brands);
    }

    /*
     * @Author huangcf
     * @根据商品分类id，查询对应品牌
     * @Date  2020/3/26 10:39
     * @Param
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<Brand> queryBrandsById(@PathVariable("id") Long id) {

        Brand brand = this.brandService.queryBrandById(id);
        if(brand == null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(brand);
    }
}
