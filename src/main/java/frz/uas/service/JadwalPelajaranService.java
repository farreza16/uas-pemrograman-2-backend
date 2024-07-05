package frz.uas.service;

import frz.uas.entity.JadwalPelajaran;
import frz.uas.repository.JadwalPelajaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JadwalPelajaranService {

    @Autowired
    private JadwalPelajaranRepository jadwalPelajaranRepository;

    public List<JadwalPelajaran> findAll() {
        return jadwalPelajaranRepository.findAll();
    }

    public Optional<JadwalPelajaran> findById(Integer id) {
        return jadwalPelajaranRepository.findById(id);
    }

    public JadwalPelajaran save(JadwalPelajaran jadwalPelajaran) {
        return jadwalPelajaranRepository.save(jadwalPelajaran);
    }

    public void deleteById(Integer id) {
        jadwalPelajaranRepository.deleteById(id);
    }
}
