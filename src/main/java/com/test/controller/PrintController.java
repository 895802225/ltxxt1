package com.test.controller;

import com.test.common.ServerReponse;
import com.test.pojo.Print;
import com.test.service.IPrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/print")
public class PrintController {
    @Autowired
    private IPrintService iPrintService;
    @RequestMapping("insert.do")
    @ResponseBody
    public ServerReponse insert(Print p){
        return iPrintService.insert(p);
    }
}
