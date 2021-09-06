package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.RecorderShortDto;

import java.util.List;

@Service
@AllArgsConstructor
public class RecorderService {

    private ModelMapper modelMapper;
    private RecorderRepository recorderRepository;

    public RecorderDto createRecorder(RecorderCreateCommand command) {
        Recorder recorder = new Recorder(command.getName(), command.getDateOfBirth());
        recorderRepository.save(recorder);
        return modelMapper.map(recorder, RecorderDto.class);
    }

    public List<RecorderShortDto> listParamQuery() {
        return recorderRepository.listParamQuery();
    }

    public Recorder getRecorderById(Long id) {
        return recorderRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("recorder/not-found", "Recorder not found", "Recorder not found"));
    }
}
