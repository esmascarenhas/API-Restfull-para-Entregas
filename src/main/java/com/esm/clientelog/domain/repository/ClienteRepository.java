package com.esm.clientelog.domain.repository;

import com.esm.clientelog.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

/*    List<Cliente> findByNome (String nome);
    List<Cliente> findByNomeContaining (String nome);
    Optional<Cliente> findByEmail (String email);*/
}
