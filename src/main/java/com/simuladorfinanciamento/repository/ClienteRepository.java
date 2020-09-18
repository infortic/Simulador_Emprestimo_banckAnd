package com.simuladorfinanciamento.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.simuladorfinanciamento.entity.Cliente;

import java.math.BigDecimal;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {
	Cliente findByCpf(BigDecimal cpf);
}
