package com.example.springmsentra.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appeal-processing")
public class AppealRequestProcessingController {

    @GetMapping("add-appeal")
    @ResponseBody
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")
    public String addAppeal() {
        return "adding an appeal";
    }

    @GetMapping("/verify-appeal")
    @ResponseBody
    @PreAuthorize("hasRole('Admin')")
    public String verifyAppeal() {
        return "verifying an appeal";
    }
}
