package com.example.springmsentra.services.impl;

import com.example.springmsentra.repository.AppealRepository;
import com.example.springmsentra.services.AppealService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.springmsentra.entities.Appeal;

@Service
@RequiredArgsConstructor
public class AppealServiceImpl implements AppealService {

    private final AppealRepository appealRepository;

    @Override
    public void saveAppealRequest(Appeal appeal) {
        appealRepository.save(appeal);
    }

    @Override
    public Appeal FindAppealRequestByNric(String nric) {
        return appealRepository.findByNric(nric);
    }

    @Override
    public void approveAppealRequest(String nric) {
        Appeal appeal = appealRepository.findByNric(nric);
        appeal.setAppealStatus(Appeal.AppealStatus.APPROVED);
        appealRepository.save(appeal);
    }

    @Override
    public void rejectAppealRequest(String nric) {
        Appeal appeal = appealRepository.findByNric(nric);
        appeal.setAppealStatus(Appeal.AppealStatus.REJECTED);
        appealRepository.save(appeal);
    }
}
