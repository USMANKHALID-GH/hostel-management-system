package com.usman.hostelmanagementsystem.service.impl;

import com.usman.hostelmanagementsystem.model.Fees;
import com.usman.hostelmanagementsystem.model.Student;
import com.usman.hostelmanagementsystem.repository.FeesRepository;
import com.usman.hostelmanagementsystem.repository.StudentRepository;
import com.usman.hostelmanagementsystem.service.FeesService;
import com.usman.hostelmanagementsystem.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class FeesServiceImpl implements FeesService {
    @Autowired
    private  final FeesRepository feesRepository;
    @Autowired
    private StudentService studentService;




    @Override
    public List<Fees> getStudentFromFees() {
         return  feesRepository.findAll()
                .stream()
                .filter(s->s.getCreatedDate().toLocalDate().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth())
                        .isBefore(LocalDate.now()))

                .collect(Collectors.toList());
    }
}
