package frz.uas.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
public class Kelas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String namaKelas;

    @ManyToOne
    @JoinColumn(name = "jurusan_id")
    private Jurusan jurusan;

    @OneToMany(mappedBy = "kelas")
    @JsonIgnore
    @ToString.Exclude // Hindari looping pada jadwalPelajaran
    private List<JadwalPelajaran> jadwalPelajaran;

    // Constructor, getters, and setters
}
