package com.student.dal.repos;

import com.student.dal.entities.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Integer> {

    @Query(value = "select type, count(type)\n" +
            "from location\n" +
            "group by type", nativeQuery = true)
    List<Object[]> findTypeAndTypeCount();
}
