package frz.uas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import frz.uas.entity.Kelas;
import frz.uas.service.KelasService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")

@RequestMapping("api/kelas")
public class KelasController {

    @Autowired
    private KelasService kelasService;

    @GetMapping
    public List<Kelas> getAllKelas() {
        return kelasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kelas> getKelasById(@PathVariable Integer id) {
        Optional<Kelas> kelas = kelasService.findById(id);
        return kelas.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Kelas createKelas(@RequestBody Kelas kelas) {
        return kelasService.save(kelas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kelas> updateKelas(@PathVariable Integer id, @RequestBody Kelas kelas) {
        Optional<Kelas> existingKelas = kelasService.findById(id);
        if (existingKelas.isPresent()) {
            kelas.setId(id);
            return ResponseEntity.ok(kelasService.save(kelas));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKelas(@PathVariable Integer id) {
        kelasService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
