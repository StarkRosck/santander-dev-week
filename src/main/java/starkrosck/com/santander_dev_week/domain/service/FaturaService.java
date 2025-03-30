package starkrosck.com.santander_dev_week.domain.service;

import starkrosck.com.santander_dev_week.domain.model.Fatura;

import java.util.List;

public interface FaturaService {
    Fatura findById(Long id);
    List<Fatura> findAll();
    Fatura create(Fatura fatura);
    void delete(Long id);
    Fatura update(Fatura fatura);
}
