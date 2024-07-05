package frz.uas.service;

import frz.uas.entity.Guru;
import frz.uas.repository.GuruRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuruService {

    @Autowired
    private GuruRepository guruRepository;

    public List<Guru> getAllGuru() {
        return guruRepository.findAll();
    }

    public Optional<Guru> getGuruById(Integer id) {
        return guruRepository.findById(id);
    }

    public Guru createGuru(Guru guru) {
        return guruRepository.save(guru);
    }

    public Optional<Guru> updateGuru(Integer id, Guru guruDetails) {
        return guruRepository.findById(id).map(guru -> {
            guru.setNama(guruDetails.getNama());
            guru.setNip(guruDetails.getNip());
            guru.setAlamat(guruDetails.getAlamat());
            guru.setNomorTelepon(guruDetails.getNomorTelepon());
            return guruRepository.save(guru);
        });
    }

    public void deleteGuru(Integer id) {
        guruRepository.deleteById(id);
    }
}
