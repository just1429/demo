package com.leyou.goods.client;

import com.leyou.item.api.CategoryApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "item-service")
//@RequestMapping("category")
public interface CategoryClient extends CategoryApi {

        //也可以不继承 直接远程调用
        //@GetMapping("names")
        //public List<String> queryNamesByIds(@RequestParam("ids") List<Long> ids);

}
