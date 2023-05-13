package com.usman.hostelmanagementsystem.repository;

import com.usman.hostelmanagementsystem.model.Hostel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface HostelRepository  extends JpaRepository<Hostel, Long> {
    @Query("select a from Hostel a  where  a.location.address.city=:city")
    Page<Hostel>  getHostelByCityName(@Param("city") String city, Pageable pageable);
    



    @Query("from Hostel a where a.gender=:gender")
    Page<Hostel> findHostelByGender(@Param("gender") String gender, Pageable pageable);


}
