package frz.uas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frz.uas.entity.Kelas;
import frz.uas.repository.KelasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KelasService {

    @Autowired
    private KelasRepository kelasRepository;

    public List<Kelas> findAll() {
        return kelasRepository.findAll();
    }

    public Optional<Kelas> findById(int id) {
        return kelasRepository.findById(id);
    }

    public Kelas save(Kelas kelas) {
        return kelasRepository.save(kelas);
    }

    public void deleteById(int id) {
        kelasRepository.deleteById(id);
    }
}