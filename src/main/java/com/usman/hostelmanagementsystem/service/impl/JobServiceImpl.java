package com.usman.hostelmanagementsystem.service.impl;

import com.usman.hostelmanagementsystem.exception.BusinessException;
import com.usman.hostelmanagementsystem.model.Job;

import com.usman.hostelmanagementsystem.repository.JobRepository;
import com.usman.hostelmanagementsystem.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;



@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;
    @Override
    public Job findJobById(long id) {
        return jobRepository.findById(id)
                .orElseThrow(()-> new BusinessException("THERE IS NO SUCH JOB IN OUR SYSTEM"));
    }

    @Override
    public void saveJob(Job job) {
        boolean isExist=jobRepository.findAll()
                .stream()
                .anyMatch(s->job.getName().equalsIgnoreCase(s.getName()));
        if(isExist){
            throw new BusinessException("JOB Already exist in our system");
        }
        if(ObjectUtils.isEmpty(job.getName())){
            throw new BusinessException("JOB NAME CANT BE EMPYT");
        }
        if(ObjectUtils.isEmpty(job.getDescription())){
            throw new BusinessException("JOB DESCRIPTION  CANT BE EMPYT");
        }
        if(ObjectUtils.isEmpty(job.getSalaryAmount())){
            throw new BusinessException("JOB DESCRIPTION  CANT BE EMPYT");
        }

        jobRepository.save(job);



    }

    @Override
    public void updateAmount(long id, double amount) {
        Job job =findJobById(id);
        job.setSalaryAmount(amount);
        jobRepository.save(job);
    }

    @Override
    public void deleteJob(long id) {

        Job job= findJobById(id);
           boolean activeStaffUnderIt= job.getStaff()
                            .stream()
                                    .anyMatch(s->s.isActive());
           if(activeStaffUnderIt){
               throw  new BusinessException("Cant be delete because there are working under it");
           }
        jobRepository.delete(findJobById(id));

    }
}
