package training360.guinessapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import training360.guinessapp.dto.RecorderShortDto;

import java.util.List;

public interface RecorderRepository extends JpaRepository<Recorder, Long> {

    @Query("SELECT new training360.guinessapp.dto.RecorderShortDto(r.name, r.dateOfBirth)" +
            " FROM Recorder r " +
            " WHERE r.name LIKE 'B%' OR r.name LIKE '%e%'" +
            " ORDER BY r.dateOfBirth")
    List<RecorderShortDto> listParamQuery();
}
