package starkrosck.com.santander_dev_week.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import starkrosck.com.santander_dev_week.domain.model.Fatura;

public interface FaturaRepository extends JpaRepository<Fatura, Long> {
    // pode adicionar métodos custom se quiser
}
