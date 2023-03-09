package com.inteligentes.backend_inteligentes.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.inteligentes.backend_inteligentes.model.Nodo;
import com.inteligentes.backend_inteligentes.services.AlgoritmoService;
import com.inteligentes.backend_inteligentes.web.vo.NodoVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/backend_inteligentes/algoritmo")
@Api(tags = "algoritmo")
public class AlgoritmoResource {
	
	private final AlgoritmoService algoritmoService;
	
	public AlgoritmoResource(AlgoritmoService algoritmoService) {
		this.algoritmoService = algoritmoService;
	}
	
	@PostMapping
	@ApiOperation(value = "Nodo", notes = "Servicios algoritmo")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "wii"),
			@ApiResponse(code = 400, message = "Solicitud Invalida") })
	public ResponseEntity<Nodo> createUser(@RequestBody NodoVO userVo){
		
		Nodo user = new Nodo();
		
		user.setNombre(userVo.getNombre());
		
		return new ResponseEntity<Nodo>(this.algoritmoService.create(user), HttpStatus.CREATED);
	}
	
	@GetMapping
	@ApiOperation(value = "Listar", notes = "Servicios para obtener todo")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Informacion obtenida de forma correcta"),
			@ApiResponse(code = 404, message = "No se encontro anda") })
	public ResponseEntity<List<Nodo>> findAll(){
		return  ResponseEntity.ok(new ArrayList<Nodo>());
	}

	@GetMapping(value = "profundidad")
	public ResponseEntity<List<Nodo>> profundidad(){
		return ResponseEntity.ok(new ArrayList<Nodo>()); 
	}
}
