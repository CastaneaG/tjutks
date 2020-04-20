package com.wkl.sell.controller;

import com.wkl.sell.dataobject.ProductInfo;
import com.wkl.sell.dataobject.SellerInfo;
import com.wkl.sell.exception.SellException;
import com.wkl.sell.form.ProductForm;
import com.wkl.sell.form.UserForm;
import com.wkl.sell.service.SellerInfoService;
import com.wkl.sell.utils.KeyUtil;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private SellerInfoService sellerInfoService;

    @GetMapping("/userlist")
    public ModelAndView list(Map<String, Object> map) {
        List<SellerInfo> sellerInfoList = sellerInfoService.findAll();
        map.put("sellerInfoList",sellerInfoList);
        return new ModelAndView("admin/userlist", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "sellerId", required = false) String sellerId,
                              Map<String, Object> map) {
        if (!StringUtils.isEmpty(sellerId)) {
            SellerInfo sellerInfo = sellerInfoService.findById(sellerId);
            map.put("sellerInfo", sellerInfo);
        }


        return new ModelAndView("admin/index", map);
    }
    @PostMapping("/save")
//    @Cacheable(cacheNames = "product", key = "123")
//    @Cacheable(cacheNames = "product", key = "456")
//    @CachePut(cacheNames = "product", key = "123")
    @CacheEvict(cacheNames = "seller", allEntries = true, beforeInvocation = true)
    public ModelAndView save(@Valid UserForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/admin/index");
            return new ModelAndView("common/error", map);
        }

        SellerInfo sellerInfo = new SellerInfo();
        try {
            if (!StringUtils.isEmpty(form.getSellerId())) {
                sellerInfo = sellerInfoService.findById(form.getSellerId());
            } else {
                form.setSellerId(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(form, sellerInfo);
            sellerInfo.setPermission(1);
            sellerInfoService.save(sellerInfo);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/admin/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/admin/userlist");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam(value = "sellerId") String sellerId,
                               Map<String, Object> map) {
        sellerInfoService.delete(sellerId);
        map.put("url", "/sell/admin/userlist");
        return new ModelAndView("common/success", map);
    }
}
