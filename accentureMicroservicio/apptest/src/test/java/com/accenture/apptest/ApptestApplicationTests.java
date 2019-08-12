package com.accenture.apptest;import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.apptest.domain.Empleados;
import com.accenture.apptest.pojo.EmpleadosPojo;
import com.accenture.apptest.pojo.converter.EmpleadosConverter;
import com.accenture.apptest.repository.EmpleadosRepository;
import com.accenture.apptest.service.EmpleadoService;
import com.accenture.apptest.service.impl.EmpleadoServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApptestApplicationTests {
  
	@Autowired
	private EmpleadoService empleadoService;
	
	@MockBean
	private EmpleadosRepository empleadosRepository;
	
	
	
	private Empleados empleado ;
	private EmpleadosPojo empleadosPojo;
	private Empleados empleado2 ;
	private EmpleadosPojo empleadosPojo2;
	
	
	@Before
	public void init() {
		empleadosPojo = new EmpleadosPojo();
		empleadosPojo.setId(1);
		empleadosPojo.setDocumentNumber(8465210);
		empleadosPojo.setName("Empleado Test");
		empleadosPojo.setEmail("test@gmail.com");
		EmpleadosConverter empleadosConverter = new EmpleadosConverter();
		empleado=empleadosConverter.converterEmpleadosPojo2Empleados(empleadosPojo);
		
		empleadosPojo2 = new EmpleadosPojo();
		empleadosPojo2.setId(2);
		empleadosPojo2.setDocumentNumber(12345);
		empleadosPojo2.setName("Empleado 2");
		empleadosPojo2.setEmail("empleado2@gmail.com");
		
		empleado2=empleadosConverter.converterEmpleadosPojo2Empleados(empleadosPojo2);
		
	}
	
	
	@Test
	public void findEmpleado() {
		
		int id=1;
		Optional<Empleados> emplOptional = Optional.of(empleado) ;
		when(empleadosRepository.findById(id)).thenReturn(emplOptional );
		EmpleadosPojo result = empleadoService.findById(id);
		assertEquals("Empleado Test",result.getName());
	}
	
	@Test
		public void deleteEmpleado() {
			
			int id=1;
			when(empleadosRepository.deleteById(id)).thenReturn(true);
			Boolean result = empleadoService.deleted(1);
			assertEquals(true,result);
		}
		
	
	
	//@Test
	public void contextLoads() {
	}

}