package com.manuel.curso.springboot.jpa.springbootjpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.manuel.curso.springboot.jpa.springbootjpa.dto.PersonDto;
import com.manuel.curso.springboot.jpa.springbootjpa.entities.Person;
import com.manuel.curso.springboot.jpa.springbootjpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner{

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		subQueries();

//		int id ;
//		Scanner sc = new Scanner(System.in) ;
//
//		System.out.println("Indique quiere realizar: \n\t1.Crear\n\t2.Actualizar\n\t3.Eliminar\n\t4.Buscar Usuarios\n\t5.Salir");
//
//		id = sc.nextInt() ;
//
//		switch (id) {
//			case 1:
//				create();
//				break;
//
//			case 2:
//				update();
//				break;
//
//			case 3:
//				delete2();
//				break;
//
//			case 4:
//				findOne() ;
//				break;
//
//			case 5:
//				System.out.println("Gracias por usar el sistema");;
//				break;
//
//			default:
//				System.out.println("Valor Inesperado");
//				break;
//		}
//
//		sc.close();

	}

	@Transactional(readOnly = true)
	public void subQueries() {

		System.out.println("==================== consulta por nombre más corto y su largo ==========================");

		List<Object[]> registers = repository.getShorterName() ;

		registers.forEach( reg -> {

			String name = (String) reg[0] ;
			int length = (int) reg[1] ;
			System.out.println("name = "+name+ " ,length = "+length);

		});
		System.out.println("==================== consulta por ultimo registro ==========================");

		Optional<Person> optionalPerson = repository.getLastRegistration() ;

		optionalPerson.ifPresent(System.out::println);

	}

	@Transactional(readOnly = true)
	public void queriesFunctionAggregation() {

		
		System.out.println("==================== número de registros en la tabla ==========================");
		Long count = repository.getTotalPerson() ;
		System.out.println(count);
		System.out.println("==================== valor minimo de id ==========================");
		Long min = repository.getMinId() ;
		System.out.println(min);
		System.out.println("==================== valor maximo de id ==========================");
		Long max = repository.getMaxId() ;
		System.out.println(max);
		System.out.println("==================== consulta por nombre y largo ==========================");
		
		List<Object[]> regs = repository.getPersonNameLength() ;
		
		regs.forEach(reg -> {
			String name = (String) reg[0] ;
			int length = (int) reg[1] ;
			System.out.println("name = "+name+ " ,length = "+length);
		});
		
		System.out.println("==================== consulta con el nombre mas corto ==========================");
		int minNameLength = repository.getMinLengthName() ;
		System.out.println(minNameLength);

		System.out.println("==================== consulta con el nombre mas largo ==========================");
		int maxNameLength = repository.getMaxLengthName() ;
		System.out.println(maxNameLength);

		System.out.println("==================== consultas resumen de funcion de agregacion: min, max, sum, avg, count ==========================");
		Object[] resumeReg = (Object[]) repository.getResumeAggregationFunction() ;
		System.out.println(maxNameLength);

		System.out.println("min="+resumeReg[0]+",max="+resumeReg[1]+", sum="+resumeReg[2]+", avg="+resumeReg[3]+", count="+resumeReg[4]);

	}

	@Transactional(readOnly = true)
	public void personalizedQueriesBetween() {

		System.out.println("==================== consultas por rangos ==========================");
		List<Person> persons = repository.findAllBetweenId(3L,5L) ;

		persons.forEach(System.out::println) ;

		System.out.println("==================== consultas por nombres ==========================");
		persons = repository.findAllBetweenName("K","Q") ;

		persons.forEach(System.out::println) ;

		System.out.println("==================== Todo==========================");
		persons = repository.getAllOrdered() ;

		persons.forEach(System.out::println) ;
	

	}

	@Transactional(readOnly = true)
	public void personalizedQueriesDistinctUpperAndLowerCase() {

		System.out.println("=============Consulta nombres y apellidos de todos================");

		List<String> names = repository.findAllFullNameConcat() ;
		names.forEach(System.out::println) ;
		System.out.println("=============Consulta nombres y apellidos de todos mayus================");

		names = repository.findAllFullNameConcatUpper() ;
		names.forEach(System.out::println) ;
		System.out.println("=============Consulta nombres y apellidos de todos minus================");

		names = repository.findAllFullNameConcatLower() ;

		names.forEach(System.out::println) ;

	}

	@Transactional(readOnly = true)
	public void personalizedQueriesDistinct() {

		System.out.println("Consultas con nombres de personas");

		List<String> names = repository.findAllDistinctLanguageQuantity() ;

		names.forEach(System.out::println) ;

	}

	@Transactional(readOnly = true)
	public void personalizedQueries2(){

		System.out.println("================= consulta por objeto persona y lenguaje de programacion=================");

		List<Object[]> personsRegs = repository.findAllMixPerson() ;

		personsRegs.forEach(reg -> {

			System.out.println("programming language =" + reg[1] + ", person=" +reg[0]);

		}) ;

		System.out.println("consulta que puebla y devuelve objeto entity de una instancia personalizada");
		List<Person> persons = repository.findAllObjectPersonPersonalized() ;
		persons.forEach(System.out::println) ;

		System.out.println("Consulta que puebla y devuelve objeto entity de una instancia personalizada");
		List<PersonDto> personsDto = repository.findAllPersonDto() ;
		personsDto.forEach(System.out::println) ;
	}

	@Transactional(readOnly = true)
	public void personalizedQueries(){

		Long id ;
		//Long idDb ;
		//String name ;
		Scanner sc = new Scanner(System.in) ;
		
		System.out.println("Ingrese el id para el nombre: ");
		id = sc.nextLong() ;

		Optional<Object> optional = repository.obtenerPersonDataById(id) ;

		if (optional.isPresent()) {
			Object[] personReg = (Object[]) optional.get() ;
			System.out.println("id="+personReg[0]+", nombre="+personReg[1]+", apellido="+personReg[2]+", lenguage="+personReg[3]);
		}



		//name = repository.getNameById(id) ;
		//System.out.println(name);

		//idDb = repository.getIdById(id) ;
		//System.out.println(idDb);

		//name = repository.getNameById(id) ;
		//System.out.println(name);

		sc.close();

	}

	@Transactional
	public void delete() {

		Long id ;
		Scanner sc = new Scanner(System.in) ;

		System.out.print("Eliminación de usuario existente.\nIngrese el ID del usuario a eliminar: ");

		id = sc.nextLong() ;

		repository.deleteById(id) ;

		repository.findAll().forEach(System.out::println) ;

		sc.close() ;

	}

	@Transactional
	public void delete2() {

		Long id ;
		Scanner sc = new Scanner(System.in) ;

		System.out.print("Eliminación de usuario existente.\nIngrese el ID del usuario a eliminar: ");

		id = sc.nextLong() ;

		Optional<Person> optionalPerson = repository.findById(id) ;

		optionalPerson.ifPresentOrElse(person -> repository.delete(person), () -> System.out.println("Acción no válida")) ;
		
		repository.findAll().forEach(System.out::println) ;

		sc.close() ;

	}

	@Transactional
	public void update(){

		Long id ;
		Scanner sc = new Scanner(System.in) ;

		System.out.print("Modificación de usuario existente.\nIngrese el ID del usuario a modificar: ");

		id = sc.nextLong() ;

		Optional<Person> optionalPerson = repository.findById(id) ;

		
		sc.nextLine() ;
		
		//optionalPerson.ifPresent(person -> {

		if (optionalPerson.isPresent()) {
			System.out.print("Usuario que se va a modificar: " + optionalPerson);
				
			Person person = optionalPerson.orElseThrow() ;
			Person newPers ;
			String progLang ;

			System.out.print("Ingrese el lenguaje de programación: ") ;
			progLang = sc.nextLine() ;

			person.setProgrammingLanguage(progLang);

			newPers = repository.save(person) ;

			System.out.println(newPers);

			sc.close() ;

		} else {

			System.out.println("No existe ese usuario");

		}

		//}) ;

	}

	@Transactional
	public void create() {

		String name ;
		String lastname ;
		String language ;

		Scanner sc = new Scanner(System.in) ;

		System.out.print("Datos del nuevo usuario.\nNombre: ");

		name = sc.nextLine() ;

		System.out.print("Apellido: ");

		lastname = sc.nextLine() ;

		System.out.print("Lenguaje de programación: ");

		language = sc.nextLine() ;

		Person person = new Person(null, name, lastname, language) ;

		Person personNew = repository.save(person) ;

		System.out.println(personNew) ;

		repository.findById(personNew.getId()).ifPresent(p -> System.out.println(p)) ;

		sc.close() ;

	}

	public void findOne() {
		Person person = null ;
		Optional<Person> optionalPerson = repository.findById(9L) ;

		if (optionalPerson.isPresent()) {

			person = optionalPerson.get() ;
			System.out.println(person);

		} else {

			System.out.println("No existe ese usuario");

		}

		//repository.findByNameContaining("Man").ifPresent(System.out::println);

	}

	public void list() {

		//List<Person> persons = (List<Person>) repository.findAll();
		//List<Person> persons = (List<Person>) repository.buscarByProgrammingLanguage("Python","Pepe");
		List<Person> persons = (List<Person>) repository.findByProgrammingLanguageAndName("Java","Josefa");

		persons.stream().forEach(person -> {
			System.out.println(person);
		});


		List<Object[]> personsValues = repository.obtenerPersonData() ;
		personsValues.stream().forEach(person -> {
			System.out.println(person[0] + " programa en " +person[1]);
			System.out.println(person);
			System.out.println("");
		});


	}

}
