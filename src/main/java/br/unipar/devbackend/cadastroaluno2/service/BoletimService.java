    package br.unipar.devbackend.cadastroaluno2.service;

    import br.unipar.devbackend.cadastroaluno2.dto.BoletimDTO;
    import br.unipar.devbackend.cadastroaluno2.dto.BoletimItemDTO;
    import br.unipar.devbackend.cadastroaluno2.repository.AlunoDisciplinaRepository;
    import br.unipar.devbackend.cadastroaluno2.repository.AlunoRepository;
    import org.springframework.stereotype.Service;

    @Service
    public class BoletimService {

        private final AlunoDisciplinaRepository alunoDisciplinaRepository;
        private final AlunoRepository alunoRepository;

        public BoletimService(AlunoDisciplinaRepository alunoDisciplinaRepository,
                              AlunoRepository alunoRepository) {
            this.alunoDisciplinaRepository = alunoDisciplinaRepository;
            this.alunoRepository = alunoRepository;
        }

        public BoletimDTO gerarBoletim(Long idAluno) {

            var aluno = alunoRepository.findById(idAluno)
                    .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

            var disciplinas = alunoDisciplinaRepository.findByAlunoId(idAluno);

            var boletim = disciplinas.stream().map(ad -> {

                double media = ((ad.getNota1Bim() != null ? ad.getNota1Bim() : 0) +
                        (ad.getNota2Bim() != null ? ad.getNota2Bim() : 0)) / 2.0;

                int faltas = (ad.getFaltas1Bim() != null ? ad.getFaltas1Bim() : 0) +
                        (ad.getFaltas2Bim() != null ? ad.getFaltas2Bim() : 0);

                return new BoletimItemDTO(
                        ad.getDisciplina().getDescricao(),
                        ad.getNota1Bim(),
                        ad.getNota2Bim(),
                        faltas,
                        media,
                        ad.getSituacao() != null ? ad.getSituacao().name() : "EM_CURSO",
                        ad.getMatriculado()
                );


            }).toList();


            return new BoletimDTO(aluno.getNome(), boletim);
        }
    }
