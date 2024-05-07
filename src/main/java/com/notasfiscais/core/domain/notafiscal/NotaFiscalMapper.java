package com.notasfiscais.core.domain.notafiscal;

import com.notasfiscais.core.domain.notafiscal.dto.NotaFiscalDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotaFiscalMapper {
    NotaFiscal toDomain(NotaFiscalDto notaFiscalDto);

}
