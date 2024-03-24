package br.edu.iff.acaiteriaWebApp.service;

import br.edu.iff.acaiteriaWebApp.model.Adicional;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AdicionalService {

    public Adicional encontrarAdicionalPorNome(String nomeAdicional) {
        List<Adicional> listaAdicionais = Arrays.asList(
                new Adicional("Granola", 2.0),
                new Adicional("Leite em pó", 1.5),
                new Adicional("Frutas", 3.0)
        );
        for (Adicional adicional : listaAdicionais) {
            if (adicional.getNome() != null && adicional.getNome().equals(nomeAdicional)) {
                return adicional;
            }
        }
        return null;
    }
}
