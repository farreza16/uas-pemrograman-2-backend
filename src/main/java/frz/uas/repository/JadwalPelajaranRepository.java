package frz.uas.repository;

import frz.uas.entity.JadwalPelajaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JadwalPelajaranRepository extends JpaRepository<JadwalPelajaran, Integer> {
}
