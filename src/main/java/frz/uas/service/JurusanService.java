package frz.uas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frz.uas.entity.Jurusan;
import frz.uas.repository.JurusanRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JurusanService {

    @Autowired
    private JurusanRepository jurusanRepository;

    public List<Jurusan> findAll() {
        return jurusanRepository.findAll();
    }

    public Optional<Jurusan> findById(int id) {
        return jurusanRepository.findById(id);
    }

    public Jurusan save(Jurusan jurusan) {
        return jurusanRepository.save(jurusan);
    }

    public void deleteById(int id) {
        jurusanRepository.deleteById(id);
    }
}
