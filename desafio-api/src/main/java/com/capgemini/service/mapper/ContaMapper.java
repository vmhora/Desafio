package com.capgemini.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.capgemini.model.Conta;
import com.capgemini.service.dto.ContaDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ContaMapper {
	
	ContaDTO contaToContaDTO(Conta Conta);

    List<ContaDTO> contasToContaDTOs(List<Conta> Contas);

    Conta contaDTOToConta(ContaDTO ContaDTO);

    List<Conta> contaDTOsToContas(List<ContaDTO> ContaDTOs);
    
    default Conta contaFromId(Long id) {
        if (id == null) {
            return null;
        }
        Conta conta = new Conta();
        conta.setId(id);
        return conta;
    }
}
