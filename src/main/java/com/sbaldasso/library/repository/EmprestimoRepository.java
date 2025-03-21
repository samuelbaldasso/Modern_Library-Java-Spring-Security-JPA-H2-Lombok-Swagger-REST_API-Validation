package com.sbaldasso.library.repository;

import com.sbaldasso.library.domain.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    List<Emprestimo> findByIdLeitor(Long idLeitor);
    List<Emprestimo> findByIdLivroAndDataDevolucaoIsNull(Long idLivro);
}
