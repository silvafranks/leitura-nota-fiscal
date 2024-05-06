package com.notasfiscais.core.domain.notafiscal;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotaFiscalMapper {
    NotaFiscal toDomain(NotaFiscalDto notaFiscalDto);

}
