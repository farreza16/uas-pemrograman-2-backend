package frz.uas.controller;

import frz.uas.entity.JadwalPelajaran;
import frz.uas.repository.JadwalPelajaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/jadwalpelajaran")
public class JadwalPelajaranController {

    @Autowired
    private JadwalPelajaranRepository jadwalPelajaranRepository;

    @GetMapping
    public List<JadwalPelajaran> getAllJadwalPelajaran() {
        return jadwalPelajaranRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JadwalPelajaran> getJadwalPelajaranById(@PathVariable Integer id) {
        Optional<JadwalPelajaran> jadwalPelajaran = jadwalPelajaranRepository.findById(id);
        if (jadwalPelajaran.isPresent()) {
            return ResponseEntity.ok(jadwalPelajaran.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public JadwalPelajaran createJadwalPelajaran(@RequestBody JadwalPelajaran jadwalPelajaran) {
        return jadwalPelajaranRepository.save(jadwalPelajaran);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JadwalPelajaran> updateJadwalPelajaran(@PathVariable Integer id, @RequestBody JadwalPelajaran jadwalPelajaranDetails) {
        Optional<JadwalPelajaran> optionalJadwalPelajaran = jadwalPelajaranRepository.findById(id);
        if (optionalJadwalPelajaran.isPresent()) {
            JadwalPelajaran jadwalPelajaran = optionalJadwalPelajaran.get();
            jadwalPelajaran.setKelas(jadwalPelajaranDetails.getKelas());
            jadwalPelajaran.setGuru(jadwalPelajaranDetails.getGuru());
            jadwalPelajaran.setHari(jadwalPelajaranDetails.getHari());
            jadwalPelajaran.setJamMulai(jadwalPelajaranDetails.getJamMulai());
            jadwalPelajaran.setJamSelesai(jadwalPelajaranDetails.getJamSelesai());
            return ResponseEntity.ok(jadwalPelajaranRepository.save(jadwalPelajaran));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJadwalPelajaran(@PathVariable Integer id) {
        Optional<JadwalPelajaran> optionalJadwalPelajaran = jadwalPelajaranRepository.findById(id);
        if (optionalJadwalPelajaran.isPresent()) {
            jadwalPelajaranRepository.delete(optionalJadwalPelajaran.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
