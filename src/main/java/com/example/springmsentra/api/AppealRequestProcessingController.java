package com.example.springmsentra.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//to reconfigure
@RestController
@RequestMapping("/appeal-processing")
public class AppealRequestProcessingController {
    @GetMapping("add-appeal")
    @ResponseBody
    @PreAuthorize("hasAuthority('APPROLE_Admin')")
    public String Admin() {
        return "adding an appeal";
    }

    @GetMapping("/verify-appeal")
    @ResponseBody
    @PreAuthorize("hasAuthority('APPROLE_Supervisor')")
    public String Supervisor() {
        return "verifying an appeal";
    }
}
