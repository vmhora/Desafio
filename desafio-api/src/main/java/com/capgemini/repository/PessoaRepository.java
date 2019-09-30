package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {


}
