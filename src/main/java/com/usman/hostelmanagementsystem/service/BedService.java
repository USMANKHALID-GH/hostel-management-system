package com.usman.hostelmanagementsystem.service;


import com.usman.hostelmanagementsystem.model.Bed;

public interface BedService {

    void saveBed(Bed bed, long roomId);

    Bed findBedBYId(long id);
}
