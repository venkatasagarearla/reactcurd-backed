package com.reactcurd;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.reactcurd.entity.Employee;
import com.reactcurd.repository.EmployeeRepository;
import com.reactcurd.service.EmployeeService;



@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {

	    @InjectMocks
		private EmployeeService empService;
	
		@Mock
		private EmployeeRepository emprepo;
		
		@Test
		public void getAllEmployees() {
			when(emprepo.findAll()).thenReturn(Stream.of(new Employee(1L,"sagar","Earla","earla@gmail.com"),new Employee(2L,"venkata","earla","sagar@gmail.com")).collect(Collectors.toList()));
			assertEquals(2,empService.getAllEmployees().size());
		}
	
}
