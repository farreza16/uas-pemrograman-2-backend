package frz.uas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import frz.uas.entity.Jurusan;
import frz.uas.service.JurusanService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/jurusan")
public class JurusanController {

    @Autowired
    private JurusanService jurusanService;

    @GetMapping
    public List<Jurusan> getAllJurusan() {
        return jurusanService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jurusan> getJurusanById(@PathVariable int id) {
        Optional<Jurusan> jurusan = jurusanService.findById(id);
        if (jurusan.isPresent()) {
            return ResponseEntity.ok(jurusan.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Jurusan createJurusan(@RequestBody Jurusan jurusan) {
        return jurusanService.save(jurusan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jurusan> updateJurusan(@PathVariable int id, @RequestBody Jurusan jurusanDetails) {
        Optional<Jurusan> jurusan = jurusanService.findById(id);
        if (jurusan.isPresent()) {
            Jurusan existingJurusan = jurusan.get();
            existingJurusan.setKodeJurusan(jurusanDetails.getKodeJurusan());
            existingJurusan.setNamaJurusan(jurusanDetails.getNamaJurusan());
            return ResponseEntity.ok(jurusanService.save(existingJurusan));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJurusan(@PathVariable int id) {
        if (jurusanService.findById(id).isPresent()) {
            jurusanService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
