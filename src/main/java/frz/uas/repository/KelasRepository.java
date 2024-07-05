package frz.uas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import frz.uas.entity.Kelas;

@Repository
public interface KelasRepository extends JpaRepository<Kelas, Integer> {
}
