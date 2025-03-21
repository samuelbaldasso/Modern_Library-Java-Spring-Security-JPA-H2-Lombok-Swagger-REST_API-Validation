package com.sbaldasso.library.services;

import com.sbaldasso.library.domain.Leitor;
import com.sbaldasso.library.domain.Multa;
import com.sbaldasso.library.dto.LeitorDto;
import com.sbaldasso.library.repository.LeitorRepository;
import com.sbaldasso.library.repository.MultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LeitorService {

    @Autowired
    private LeitorRepository leitorRepository;

    @Autowired
    private MultaRepository multaRepository;

    public LeitorService(LeitorRepository leitorRepository, MultaRepository multaRepository) {
        this.leitorRepository = leitorRepository;
        this.multaRepository = multaRepository;
    }

    public Leitor addUser(LeitorDto leitorDto) {
        Leitor leitor = new Leitor();
        leitor.setNome(leitorDto.getNome());
        leitor.setCpf(leitorDto.getCpf());
        leitor.setEmail(leitorDto.getEmail());
        leitor.setTelefone(leitorDto.getTelefone());
        leitor.setDataNascimento(leitorDto.getDataNascimento());
        leitor.setDataCadastro(String.valueOf(LocalDate.now()));
        leitor.setDataAtualizacao(String.valueOf(LocalDate.now()));
        leitor.setStatus(leitorDto.getStatus());
        leitor.setEmprestimos(leitorDto.getEmprestimos());
        leitor.setMultas(leitorDto.getMultas());
        leitor.setReservas(leitorDto.getReservas());

        return leitorRepository.save(leitor);
    }

    public Leitor updateUser(LeitorDto leitorDto, Long id) {
        Leitor leitor = leitorRepository.findById(id).orElseThrow(() -> new RuntimeException("Leitor não encontrado"));
        leitor.setNome(leitorDto.getNome());
        leitor.setCpf(leitorDto.getCpf());
        leitor.setEmail(leitorDto.getEmail());
        leitor.setTelefone(leitorDto.getTelefone());
        leitor.setDataNascimento(leitorDto.getDataNascimento());
        leitor.setDataAtualizacao(String.valueOf(LocalDate.now()));
        leitor.setStatus(leitorDto.getStatus());
        leitor.setEmprestimos(leitorDto.getEmprestimos());
        leitor.setMultas(leitorDto.getMultas());
        leitor.setReservas(leitorDto.getReservas());

        return leitorRepository.save(leitor);
    }

    public void deleteUser(Long id) {
        Leitor leitor = leitorRepository.findById(id).orElseThrow(() -> new RuntimeException("Leitor não encontrado"));
        leitorRepository.delete(leitor);
    }

    public Leitor findById(Long id) {
        return leitorRepository.findById(id).orElseThrow(() -> new RuntimeException("Leitor não encontrado"));
    }

    public Iterable<Leitor> findAll() {
        return leitorRepository.findAll();
    }

    public Leitor findByEmail(String email) {
        return leitorRepository.findByEmail(email);
    }

    public List<Multa> findMultasByLeitor(Long idLeitor) {
        return multaRepository.findByIdLeitor(idLeitor);
    }


}
