package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.BeatWorldRecordCommand;
import training360.guinessapp.dto.BeatWorldRecordDto;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@AllArgsConstructor
public class WorldRecordService {

    private ModelMapper modelMapper;
    private WorldRecordRepository worldRecordRepository;
    private RecorderService recorderService;

    public WorldRecordDto createWorldRecord(WorldRecordCreateCommand command) {
        Recorder recorder = recorderService.getRecorderById(command.getRecorderId());
        WorldRecord worldRecord = new WorldRecord(
                command.getDescription(),
                command.getValue(),
                command.getUnitOfMeasure(),
                command.getDateOfRecord(),
                recorder);
        worldRecordRepository.save(worldRecord);
        return modelMapper.map(worldRecord, WorldRecordDto.class);
    }

    @Transactional
    public BeatWorldRecordDto beatrecords(Long id, BeatWorldRecordCommand command) {
        WorldRecord worldRecord = getWorldRecordById(id);
        Recorder recorder = recorderService.getRecorderById(command.getId());
        if (worldRecord.getValue() > command.getValue()) {
            throw new BadRequestException("world-record/bad-request", "Can not beat", "Can not beat");
        }
        String oldRecorder = worldRecord.getRecorder().getName();
        Double oldValue = worldRecord.getValue();
        worldRecord.setDateOfRecord(LocalDate.now());
        worldRecord.setRecorder(recorder);
        worldRecord.setValue(command.getValue());
        worldRecordRepository.flush();
        return new BeatWorldRecordDto(
                worldRecord.getDescription(),
                worldRecord.getUnitOfMeasure(),
                oldRecorder,
                worldRecord.getRecorder().getName(),
                worldRecord.getValue(),
                worldRecord.getValue() - oldValue);
    }

    private WorldRecord getWorldRecordById(Long id) {
        return worldRecordRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("world-record/not-found", "World record not found", "World record not found"));
    }
}
