package com.example.springmsentra.services;

import com.example.springmsentra.model.request.AddAppealRequest;
import org.springframework.stereotype.Service;

@Service
public interface AppealService {
    void saveAppealRequest(AddAppealRequest addAppealRequest);
    AddAppealRequest getAppealRequestByKey(String nric);
    void approveAppealRequest(String nric);
    void rejectAppealRequest(String nric);
}
