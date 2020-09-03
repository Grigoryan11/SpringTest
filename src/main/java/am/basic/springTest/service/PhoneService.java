package am.basic.springTest.service;


import am.basic.springTest.model.Phone;
import am.basic.springTest.model.exceptions.DuplicateDataException;

import java.util.List;
import java.util.Optional;

public interface PhoneService {

    List<Phone> getAll();


    Optional<Phone> findById(int id);


    Phone save(Phone phone) throws DuplicateDataException;

    Phone update(Phone phone) throws DuplicateDataException;
}

