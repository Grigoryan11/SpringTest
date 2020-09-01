package am.basic.springTest.service.impl;

import am.basic.springTest.model.Passport;
import am.basic.springTest.model.exceptions.DuplicateDataException;
import am.basic.springTest.repository.PassportRepositpory;
import am.basic.springTest.service.PassportService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class PassportServiceImpl implements PassportService {

    @Autowired
    private PassportRepositpory passportRepositpory;


    @Override
    public List<Passport> getAll() {
        return passportRepositpory.findAll();
    }

    @Override
    public Optional<Passport> findById(int id) {
        return passportRepositpory.findById(id);
    }

    @Override
    public Passport save(Passport passport) throws DuplicateDataException {
        DuplicateDataException.check(passportRepositpory.existsBySeries(passport.getSeries()),"duplicate.passport.series");
        return passportRepositpory.save(passport);
    }

    @Override
    public Passport update(Passport passport) throws DuplicateDataException {
        DuplicateDataException.check(passportRepositpory.existsBySeriesAndIdNot(passport.getSeries(),passport.getId()),"duplicate.passport.series");
        return passportRepositpory.save(passport);
    }
}
