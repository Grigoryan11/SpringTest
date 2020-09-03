package am.basic.springTest.service.impl;


import am.basic.springTest.model.Phone;
import am.basic.springTest.model.exceptions.DuplicateDataException;
import am.basic.springTest.repository.PhoneRepository;
import am.basic.springTest.service.PhoneService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;


    @Override
    public List<Phone> getAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Optional<Phone> findById(int id) {
        return phoneRepository.findById(id);
    }

    @Override
    public Phone save(Phone phone) throws DuplicateDataException {
        DuplicateDataException.check(phoneRepository.existsByImei(phone.getImei()), "duplicate.phone.imei");
        return phoneRepository.save(phone);
    }

    @Override
    public Phone update(Phone phone) throws DuplicateDataException {
        DuplicateDataException.check(phoneRepository.existsByImeiAndIdNot(phone.getImei(), phone.getId()), "duplicate.phone.imei");
        return phoneRepository.save(phone);
    }

}
