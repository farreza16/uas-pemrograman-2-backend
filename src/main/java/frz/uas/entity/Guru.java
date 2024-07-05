package frz.uas.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Guru {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nama;

    @Column(nullable = false, unique = true)
    private String nip;

    @Column(nullable = false)
    private String alamat;

    @Column(nullable = false)
    private String nomorTelepon;

    @ManyToMany(mappedBy = "guru")
    @JsonBackReference // Menghindari looping saat serialisasi
    private List<JadwalPelajaran> jadwalPelajaran;

    // Constructors, getters, and setters
}
