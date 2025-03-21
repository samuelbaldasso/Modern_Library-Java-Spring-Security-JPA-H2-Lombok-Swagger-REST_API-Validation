package com.sbaldasso.library.services;

import com.sbaldasso.library.domain.Emprestimo;
import com.sbaldasso.library.domain.Multa;
import com.sbaldasso.library.domain.Reserva;
import com.sbaldasso.library.repository.EmprestimoRepository;
import com.sbaldasso.library.repository.MultaRepository;
import com.sbaldasso.library.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private MultaRepository multaRepository;

    private static final int MAX_LIVROS = 3;
    private static final int PRAZO_DEVOLUCAO = 14;
    private static final double MULTA_DIARIA = 1.0;

    public Emprestimo emprestarLivro(Long idLeitor, Long idLivro) {
        List<Emprestimo> emprestimos = emprestimoRepository.findByIdLeitor(idLeitor);
        if (emprestimos.size() >= MAX_LIVROS) {
            throw new RuntimeException("Limite de empréstimos atingido");
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setIdLeitor(idLeitor);
        emprestimo.setIdLivro(idLivro);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucao(LocalDate.now().plusDays(PRAZO_DEVOLUCAO));
        emprestimo.setRenovado(false);

        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo renovarEmprestimo(Long idEmprestimo) {
        Emprestimo emprestimo = emprestimoRepository.findById(idEmprestimo)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        List<Reserva> reservas = reservaRepository.findByIdLivroOrderByDataReservaAsc(emprestimo.getIdLivro());
        if (!reservas.isEmpty()) {
            throw new RuntimeException("Não é possível renovar, há reservas para este livro");
        }

        emprestimo.setDataRenovacao(LocalDate.now());
        emprestimo.setDataDevolucao(emprestimo.getDataDevolucao().plusDays(PRAZO_DEVOLUCAO));
        emprestimo.setRenovado(true);

        return emprestimoRepository.save(emprestimo);
    }

    public void devolverLivro(Long idEmprestimo) {
        Emprestimo emprestimo = emprestimoRepository.findById(idEmprestimo)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        LocalDate dataDevolucao = emprestimo.getDataDevolucao();
        LocalDate dataAtual = LocalDate.now();
        if (dataAtual.isAfter(dataDevolucao)) {
            long diasAtraso = dataAtual.toEpochDay() - dataDevolucao.toEpochDay();
            double multa = diasAtraso * MULTA_DIARIA;
            // Gerar multa
            multaRepository.save(new Multa(emprestimo.getIdLeitor(), multa));
        }

        emprestimo.setDataDevolucao(dataAtual);
        emprestimoRepository.save(emprestimo);

        List<Reserva> reservas = reservaRepository.findByIdLivroOrderByDataReservaAsc(emprestimo.getIdLivro());
        if (!reservas.isEmpty()) {
            Reserva proximaReserva = reservas.get(0);
            reservaRepository.delete(proximaReserva);
        }
    }

    public Iterable<Emprestimo> findAll() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo findById(Long id) {
        return emprestimoRepository.findById(id).orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));
    }

    public Emprestimo updateEmprestimo(Long id, Long idLeitor, Long idLivro) {
        Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));
        emprestimo.setIdLeitor(idLeitor);
        emprestimo.setIdLivro(idLivro);
        return emprestimoRepository.save(emprestimo);
    }
}