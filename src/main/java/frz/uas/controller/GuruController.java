package frz.uas.controller;

import frz.uas.entity.Guru;
import frz.uas.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/guru")
public class GuruController {

    @Autowired
    private GuruService guruService;

    @GetMapping
    public List<Guru> getAllGuru() {
        return guruService.getAllGuru();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guru> getGuruById(@PathVariable Integer id) {
        return guruService.getGuruById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Guru createGuru(@RequestBody Guru guru) {
        return guruService.createGuru(guru);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guru> updateGuru(@PathVariable Integer id, @RequestBody Guru guru) {
        return guruService.updateGuru(id, guru)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuru(@PathVariable Integer id) {
        guruService.deleteGuru(id);
        return ResponseEntity.ok().build();
    }
}
