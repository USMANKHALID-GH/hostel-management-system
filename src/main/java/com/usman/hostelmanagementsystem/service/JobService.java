package com.usman.hostelmanagementsystem.service;

import com.usman.hostelmanagementsystem.model.Job;

public interface JobService {

    Job findJobById(long id);
    void saveJob(Job job);

    void updateAmount(long id, double amount);

    void deleteJob(long id);
}
