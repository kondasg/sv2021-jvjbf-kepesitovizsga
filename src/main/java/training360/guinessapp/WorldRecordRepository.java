package training360.guinessapp;

import org.springframework.data.jpa.repository.JpaRepository;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;

public interface WorldRecordRepository extends JpaRepository<WorldRecord, Long> {

}
