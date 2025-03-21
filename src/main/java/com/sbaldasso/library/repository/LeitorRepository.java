package com.sbaldasso.library.repository;

import com.sbaldasso.library.domain.Leitor;
import com.sbaldasso.library.dto.LeitorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeitorRepository extends JpaRepository<Leitor, Long> {

    Leitor findByEmail(String email);
}
