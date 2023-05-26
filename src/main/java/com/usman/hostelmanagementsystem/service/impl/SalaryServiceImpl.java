package com.usman.hostelmanagementsystem.service.impl;
import com.usman.hostelmanagementsystem.exception.BusinessException;
import com.usman.hostelmanagementsystem.model.Job;
import com.usman.hostelmanagementsystem.model.Messages;
import com.usman.hostelmanagementsystem.model.Salary;
import com.usman.hostelmanagementsystem.model.Staff;
import com.usman.hostelmanagementsystem.repository.SalaryRepository;
import com.usman.hostelmanagementsystem.service.JobService;
import com.usman.hostelmanagementsystem.service.MessageService;
import com.usman.hostelmanagementsystem.service.SalaryService;
import com.usman.hostelmanagementsystem.service.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private final SalaryRepository salaryRepository;
    @Autowired
    private final JobService jobService;
    @Autowired
    private  final MessageService messageService;
    @Autowired
    private  final StaffService staffService;


   public void saveSalary(Salary salary, long jobId){
       Job job=jobService.findJobById(jobId);

       if(ObjectUtils.isEmpty(salary.getAmount())){
           throw  new BusinessException("Salary amount cant be empyt");

       }
       salary.setJob(job);
        salaryRepository.save(salary);
   }

   @Scheduled(cron = "@monthly")
   private void sendMessageIfSalaryNotPaid(){
       List<Salary> list=salaryRepository.findAll()
               .stream()
               .filter(s->s.getCreatedDate().toLocalDate().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth())
                       .isBefore(LocalDate.now()))
               .collect(Collectors.toList());
       List<Staff> staff=staffService.getAllStaff(Pageable.unpaged()).getContent();

     staff.removeAll(list.stream().map(s->s.getStaff()).collect(Collectors.toList()));

     Messages message= new Messages();
      message.setContent("YOUR SALARY WILL BE PAID VERY SOON");
      message.setStaff(staff);
      messageService.sendMessage(message);

//      query mantikli
   }





}
