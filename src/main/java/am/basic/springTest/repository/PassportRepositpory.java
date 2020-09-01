package am.basic.springTest.repository;

import am.basic.springTest.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepositpory extends JpaRepository<Passport, Integer> {

        boolean existsBySeries(String series);

        boolean existsBySeriesAndIdNot(String series, int id);

}
