package com.wkl.sell.controller;

import com.wkl.sell.VO.ProductInfoVO;
import com.wkl.sell.VO.ResultVO;

import com.wkl.sell.dataobject.ProductInfo;
import com.wkl.sell.service.ProductInfoService;
import com.wkl.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @RestController  返回json格式
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/list")
    public ResultVO list(){
        //查询所有商品

        List<ProductInfo> productInfoList = productInfoService.findAll();
        List<ProductInfoVO> productInfoVOList = new ArrayList<>();
        for (ProductInfo productInfo:productInfoList){
            ProductInfoVO productInfoVO = new ProductInfoVO();
            BeanUtils.copyProperties(productInfo,productInfoVO);
            productInfoVOList.add(productInfoVO);
        }

        return ResultVOUtil.success(productInfoVOList);
    }
}
