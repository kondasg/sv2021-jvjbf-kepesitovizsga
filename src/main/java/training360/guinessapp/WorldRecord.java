package training360.guinessapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "world_record")
public class WorldRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private double value;
    @Column(name = "unit_of_measure")
    private String unitOfMeasure;
    @Column(name = "date_of_record")
    private LocalDate dateOfRecord;
    @OneToOne
    @JoinColumn(name = "recorder_id")
    private Recorder recorder;

    public WorldRecord(String description, double value, String unitOfMeasure, LocalDate dateOfRecord, Recorder recorder) {
        this.description = description;
        this.value = value;
        this.unitOfMeasure = unitOfMeasure;
        this.dateOfRecord = dateOfRecord;
        this.recorder = recorder;
    }
}
