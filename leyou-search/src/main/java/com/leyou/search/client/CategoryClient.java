package com.leyou.search.client;

import com.leyou.item.api.CategoryApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "item-service")
//@RequestMapping("category")
public interface CategoryClient extends CategoryApi {

        //也可以不继承 直接远程调用
        //@GetMapping("names")
        //public List<String> queryNamesByIds(@RequestParam("ids") List<Long> ids);

}
