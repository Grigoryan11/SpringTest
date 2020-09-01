package am.basic.springTest.service;

import am.basic.springTest.model.Passport;
import am.basic.springTest.model.exceptions.DuplicateDataException;

import java.util.List;
import java.util.Optional;


public interface PassportService {

    List<Passport> getAll();

    Optional<Passport> findById(int id);

    Passport save(Passport passport) throws DuplicateDataException;

    Passport update(Passport passport) throws DuplicateDataException;

}
