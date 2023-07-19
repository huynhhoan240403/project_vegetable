package com.fpt.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Xử lý lỗi và trả về trang lỗi tương ứng
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
