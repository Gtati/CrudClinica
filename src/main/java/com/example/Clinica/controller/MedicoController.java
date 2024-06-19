package com.example.Clinica.controller;


import com.example.Clinica.services.MedicoService;
import com.example.Clinica.model.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ArrayList<Medico> getAllMedicos() {
        return this.medicoService.getAllMedicos();
    }

    @PostMapping
    public Medico saveMedico(@RequestBody Medico medico) {
        return this.medicoService.saveMedico(medico);
    }

    @GetMapping(path = "/{id}")
    public Optional<Medico> getMedicoById(@PathVariable Long id) {
        return this.medicoService.getMedicoById(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateMedico(@PathVariable("id") Long id, @RequestBody Medico request) {
        Optional<Medico> existingMedico = this.medicoService.getMedicoById(id);
        if (existingMedico.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Medico updateMedico = this.medicoService.updateMedico(request, id);
        return ResponseEntity.ok(updateMedico);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteMedico(@PathVariable("id") Long id) {
        if (!medicoService.getMedicoById(id).isPresent()) {
            return "Error al eliminar el medico con id: " + id;
        } else {
            boolean ok = this.medicoService.deleteMedico(id);
            if (ok) {
                return "Medico con id " + id + " eliminado";
            } else {
                return "Error al eliminar el Medico";
            }
        }
    }


}
