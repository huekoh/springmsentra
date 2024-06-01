package com.example.springmsentra.services.impl;

import com.example.springmsentra.model.request.AddAppealRequest;
import com.example.springmsentra.services.AppealService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//to implement
@Service
@RequiredArgsConstructor
public class AppealServiceImpl implements AppealService {

    @Override
    public void saveAppealRequest(AddAppealRequest addAppealRequest) {

    }

    @Override
    public AddAppealRequest getAppealRequestByKey(String nric) {
        return null;
    }

    @Override
    public void approveAppealRequest(String nric) {

    }

    @Override
    public void rejectAppealRequest(String nric) {

    }
}
