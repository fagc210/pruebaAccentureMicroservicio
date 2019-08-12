package com.accenture.apptest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.apptest.pojo.EmpleadosPojo;
import com.accenture.apptest.service.EmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {
	
	@Autowired
	private EmpleadoService empleadoService;
	

	@GetMapping("/listar")
	public List<EmpleadosPojo> findAll(){
		return empleadoService.findAll();
	}
	
	@PostMapping("/crear")
	public String create(@RequestBody  EmpleadosPojo empleado) {
		String result=empleadoService.create(empleado);
		return "se creo el empeleado:" + result;
	}
	
	@PutMapping("/editar")
	public String edit(@RequestBody EmpleadosPojo empleado) {
		String result=empleadoService.create(empleado);
		return "Se actualizo empeleado:" + result;
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String delete(@PathVariable int id) {
		Boolean result =empleadoService.deleted(id);
		if(result) {
			return "Se elimino el empleado con id:"+id;
		}
		return "No se puedo  eliminar el empleado con id:"+id;
	}
	
	@GetMapping("/buscar/{id}")
	public EmpleadosPojo findById(@PathVariable int id){
		return empleadoService.findById(id);
	}
}
