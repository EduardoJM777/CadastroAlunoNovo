package br.unipar.devbackend.cadastroaluno2.service;

import br.unipar.devbackend.cadastroaluno2.model.AlunoDisciplina;
import br.unipar.devbackend.cadastroaluno2.repository.AlunoDisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoDisciplinaService {

    private final AlunoDisciplinaRepository adRepository;

    public AlunoDisciplinaService(AlunoDisciplinaRepository adRepository){
        this.adRepository = adRepository;
    }

    public AlunoDisciplina salvar(AlunoDisciplina alunoDisciplina){
        return adRepository.save(alunoDisciplina);
    }

    public List<AlunoDisciplina> listar(){
        return adRepository.findAll();
    }

//    public AlunoDisciplina atualizar(Long id, AlunoDisciplina adAtualizada){
//        return adRepository.findById(id).map(alunoDisciplina -> {
//            alunoDisciplina.set
//        })
//    }

    public AlunoDisciplina buscarPorId(Long id){
        return adRepository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrada(o)"));
    }



}
