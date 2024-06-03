package com.example.springmsentra.services;

import com.example.springmsentra.entities.Appeal;
import org.springframework.stereotype.Service;

@Service
public interface AppealService {
    void saveAppealRequest(Appeal appeal);
    Appeal FindAppealRequestByNric(String nric);
    void approveAppealRequest(String nric);
    void rejectAppealRequest(String nric);
}
