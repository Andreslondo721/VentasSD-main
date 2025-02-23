package Sistemas.distribuidos.Ventas.repository;

import org.springframework.data.repository.CrudRepository;

import Sistemas.distribuidos.Ventas.model.Ventas;

import java.util.List;
import java.util.Optional;

public interface VentasRepository extends CrudRepository<Ventas, Integer> {

	public List<Ventas> findAll();

}
