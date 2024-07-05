package frz.uas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import frz.uas.entity.Jurusan;

@Repository
public interface JurusanRepository extends JpaRepository<Jurusan, Integer> {
}
