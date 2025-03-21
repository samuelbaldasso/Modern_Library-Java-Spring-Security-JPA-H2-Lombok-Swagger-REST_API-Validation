package com.sbaldasso.library.repository;

import com.sbaldasso.library.domain.Leitor;
import com.sbaldasso.library.domain.Multa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Long> {
    List<Multa> findByIdLeitor(Long id);
}
