package am.basic.springTest.repository;

import am.basic.springTest.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    boolean existsByImei(String imei);

    boolean existsByImeiAndIdNot(String imei, int id);

}

