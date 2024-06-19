package com.example.Clinica.repository;


import com.example.Clinica.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitaRepository extends JpaRepository<Cita, Long> {

}
