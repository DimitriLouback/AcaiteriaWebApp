package br.edu.iff.acaiwebapp.controller.apirest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acais")
public class AcaiController {

    @GetMapping("/{id}")
    public String obterAcai(@PathVariable Long id) {
        return "Obtendo açaí com ID: " + id;
    }

    @PostMapping
    public String cadastrarAcai(@RequestBody String acai) {
        return "Cadastrando novo açaí: " + acai;
    }

    @PutMapping("/{id}")
    public String atualizarAcai(@PathVariable Long id, @RequestBody String acai) {
        return "Atualizando açaí com ID " + id + ": " + acai;
    }

    @DeleteMapping("/{id}")
    public String deletarAcai(@PathVariable Long id) {
        return "Deletando açaí com ID: " + id;
    }
}
