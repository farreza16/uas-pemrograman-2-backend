package frz.uas.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "jurusan")
@JsonIgnoreProperties({"kelases"}) // Hindari looping saat serialisasi
public class Jurusan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "kode_jurusan", nullable = false, unique = true)
    private String kodeJurusan;

    @Column(name = "nama_jurusan", nullable = false)
    private String namaJurusan;

    @OneToMany(mappedBy = "jurusan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("jurusan") // Hindari looping saat serialisasi
    private Set<Kelas> kelases;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKodeJurusan() {
        return kodeJurusan;
    }

    public void setKodeJurusan(String kodeJurusan) {
        this.kodeJurusan = kodeJurusan;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }

    public Set<Kelas> getKelases() {
        return kelases;
    }

    public void setKelases(Set<Kelas> kelases) {
        this.kelases = kelases;
    }
}
