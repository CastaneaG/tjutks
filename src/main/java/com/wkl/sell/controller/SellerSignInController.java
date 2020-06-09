package com.wkl.sell.controller;

import com.wkl.sell.dataobject.ProductInfo;
import com.wkl.sell.dataobject.SellerInfo;
import com.wkl.sell.enums.ResultEnum;
import com.wkl.sell.exception.SellException;
import com.wkl.sell.form.ProductForm;
import com.wkl.sell.form.UserForm;
import com.wkl.sell.service.SellerInfoService;
import com.wkl.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/seller/signin")
public class SellerSignInController {
    @Autowired
    private SellerInfoService sellerInfoService;

    @GetMapping("/main")
    public ModelAndView list(Map<String, Object> map) {

        return new ModelAndView("signin/main", map);
    }
    @PostMapping("/check")
    public ModelAndView save(@Valid UserForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/signin/main");
            return new ModelAndView("common/error", map);
        }
        System.out.println(form.getUsername());
        System.out.println(form.getPassword());
        SellerInfo sellerInfo = sellerInfoService.findByUsername(form.getUsername());
        if (sellerInfo == null){
            map.put("msg", ResultEnum.USER_NOT_EXIST.getMessage());
            map.put("url", "/sell/seller/signin/main");
            return new ModelAndView("common/error", map);
        }
        if(form.getPassword().equals(sellerInfo.getPassword())){
            if(sellerInfo.getPermission()==1){
                map.put("url", "/sell/seller/product/list");
                return new ModelAndView("common/success", map);
            }else{
                map.put("url", "/sell/admin/userlist");
                return new ModelAndView("common/success", map);
            }
        }else{
            map.put("msg", "密码错误");
            map.put("url", "/sell/seller/signin/main");
            return new ModelAndView("common/error", map);
        }
    }
}
