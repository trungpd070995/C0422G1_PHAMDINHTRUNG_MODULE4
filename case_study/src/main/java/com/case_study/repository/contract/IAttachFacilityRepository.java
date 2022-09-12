package com.case_study.repository.contract;

import com.case_study.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {

    @Query(value = "select * from attach_facility dvdk " +
            " join contract_detail hdct on dvdk.attach_facility_id = hdct.attach_facility_id " +
            " join contract ct on hdct.contract_id = ct.contract_id " +
            " where ct.contract_id = :id ",
            countQuery = "select count(*) from attach_facility dvdk " +
                    " join contract_detail cd on a.attach_facility_id = cd.attach_facility_id " +
                    " join contract ct on cd.contract_id = ct.contract_id " +
                    " where c.contract_id = :id ",nativeQuery = true)

    List<AttachFacility> findAllAttachFacility(@Param("id") int id);

}
