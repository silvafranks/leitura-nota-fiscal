package com.notasfiscais.core.domain.notafiscal.data;

import com.notasfiscais.core.domain.notafiscal.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal,Integer> {
}
