package frz.uas.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "jadwal_pelajaran")
public class JadwalPelajaran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "kelas_id")
    private Kelas kelas;

    @ManyToOne
    @JoinColumn(name = "guru_id")
    private Guru guru;

    private String hari;
    private String jamMulai;
    private String jamSelesai;
}
