package com.sbaldasso.library.repository;

import com.sbaldasso.library.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByIdLivroOrderByDataReservaAsc(Long idLivro);
}