package co.edu.uco.grades.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.api.controller.validator.idtype.CreateIdTypeValidator;
import co.edu.uco.grades.api.response.Response;
import co.edu.uco.grades.api.validators.Validator;
import co.edu.uco.grades.businesslogic.facade.IdTypeFacade;
import co.edu.uco.grades.businesslogic.facade.impl.IdTypeFacadeImpl;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.crosscutting.exception.enumeration.ExceptionType;
import co.edu.uco.grades.dto.IdTypeDTO;

@RestController
@RequestMapping("/api/v1/idtype")
public class IdTypeController {
	
	@GetMapping("/dummy")
	public IdTypeDTO getDummy() {
		return new IdTypeDTO();
	}
	
	@PostMapping
	public ResponseEntity<Response<IdTypeDTO>> create(@RequestBody IdTypeDTO dto) {
		Validator<IdTypeDTO> validator = new CreateIdTypeValidator();
		
		List<String> messages = UtilObject.getUtilObject().getDefault(validator.validate(dto), new ArrayList<>());
		Response<IdTypeDTO> response = new Response<>();
		ResponseEntity<Response<IdTypeDTO>> responseEntity;
		HttpStatus statusCode = HttpStatus.BAD_REQUEST;
		if(messages.isEmpty()) {
			try {
				IdTypeFacade facade = new IdTypeFacadeImpl();
				facade.create(dto);
				messages.add("Id type was created succesfully");
				
				statusCode = HttpStatus.OK;
			}catch(GradesException exception){
				if(ExceptionType.TECHNICAL.equals(exception.getType())) {
					messages.add("there was a problem trying to register the new id type ...");
					System.err.println(exception.getLocation());
					System.err.println(exception.getType());
					System.err.println(exception.getMessage());
					exception.getRootException().printStackTrace();
				}else {
					
					messages.add(exception.getUserMessage());
					System.err.println(exception.getLocation());
					System.err.println(exception.getType());
					System.err.println(exception.getMessage());
					exception.getRootException().printStackTrace();
				}
			}catch(Exception exception) {
				messages.add("There was an unexpected problem trying to register ...");
				exception.printStackTrace();
			
			}
			
		}
		System.out.println("Estoy en crear");
		response.setMessages(messages);
		responseEntity = new ResponseEntity<Response<IdTypeDTO>>(statusCode);
		return responseEntity;
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id")int id, @RequestBody IdTypeDTO dto) {
		System.out.println("Estoy en actualizar");
	}
	
	
	@PutMapping("/{id}")
	public void delete(@PathVariable("id")int id) {
		System.out.println("Estoy en eliminar");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Response<IdTypeDTO>> findId(@PathVariable("id")int id) {
		List<String> messages =  new ArrayList<>();
		Response<IdTypeDTO> response = new Response<>();
		ResponseEntity<Response<IdTypeDTO>> responseEntity;
		HttpStatus statusCode = HttpStatus.BAD_REQUEST;
		
			try {
				IdTypeFacade facade = new IdTypeFacadeImpl();
				response.setData(facade.find(new IdTypeDTO()));
				messages.add("Id type were found succesfully");
				
				statusCode = HttpStatus.OK;
			}catch(GradesException exception){
				if(ExceptionType.TECHNICAL.equals(exception.getType())) {
					messages.add("there was a problem trying to register the new id type ...");
					System.err.println(exception.getLocation());
					System.err.println(exception.getType());
					System.err.println(exception.getMessage());
					exception.getRootException().printStackTrace();
				}else {
					
					messages.add(exception.getUserMessage());
					System.err.println(exception.getLocation());
					System.err.println(exception.getType());
					System.err.println(exception.getMessage());
					exception.getRootException().printStackTrace();
				}
			}catch(Exception exception) {
				messages.add("There was an unexpected problem trying to register ...");
				exception.printStackTrace();
			
			}
			
		
		System.out.println("Estoy en crear");
		response.setMessages(messages);
		responseEntity = new ResponseEntity<Response<IdTypeDTO>>(statusCode);
		return responseEntity;
		System.out.println("Estoy en consultar por id");
		
		
	}
	
	public void find() {
		System.out.println("Estoy en consultar todos");
	}
	
}
