package Sistemas.distribuidos.Ventas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sistemas.distribuidos.Ventas.model.Ventas;
import Sistemas.distribuidos.Ventas.repository.VentasRepository;


@Service
public class VentasService {

	@Autowired
	private VentasRepository repository;

	public List<Ventas> getAll() {
		return repository.findAll();
	}

	public Optional<Ventas> getVentasById(int id) {
		return repository.findById(id);
	}

	public Ventas createVentas(Ventas Ventas) {
		return repository.save(Ventas);
	}

	public Ventas updateVentas(Ventas VentasDetails) {

		return repository.save(VentasDetails);
	}

	public void deleteVentas(int id) {
		repository.deleteById(id);
	}

	public boolean existsById(int id) {

		return repository.existsById(id);
	}
}
