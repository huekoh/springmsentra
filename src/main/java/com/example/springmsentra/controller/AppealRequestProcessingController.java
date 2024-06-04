package com.example.springmsentra.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppealRequestProcessingController {

    public static final String APPEAL_PROCESSING = "/appeal-processing";
    public static final String APPEAL_ADD = APPEAL_PROCESSING + "/add-appeal";
    public static final String APPEAL_VERIFY = APPEAL_PROCESSING + "/verify-appeal";

    @GetMapping(APPEAL_PROCESSING)
    @PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_User')")
    public String showAppealProcessingPage() {
        return "appeal-processing";
    }

    @GetMapping(APPEAL_ADD)
    @PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_User')")
    public String showAddAppealPage() {
        return "add-appeal";
    }

    @GetMapping(APPEAL_VERIFY)
    @PreAuthorize("hasAuthority('ROLE_Admin')")
    public String showVerifyAppealPage() {
        return "verify-appeal";
    }
}
