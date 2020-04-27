package com.cognizant.ormlearn;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;
	private static StockService stockService;
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;
	
	public static void main(String[] args) throws CountryNotFoundException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		countryService = context.getBean(CountryService.class);
		stockService=context.getBean(StockService.class);
		employeeService=context.getBean(EmployeeService.class);
		departmentService=context.getBean(DepartmentService.class);
		skillService=context.getBean(SkillService.class);
		//testGetAllCountries();
		//getAllCountriesTest();
		//testAddCountry();
		//testUpdateCountry();
		//testDeleteCountry();
		//testFindByName();
		//testFindByFirstName();
		//testGetByDate();
		//testGetByPrice();
		//testGetByVolume();
		//testGetByClose();
		testGetEmployee();
		//testAddEmployee();
		
		//testUpdateEmployee();
		//testGetDepartment();
		testAddSkillToEmployee();
		LOGGER.info("Inside main");
	}
	
	private static void testGetAllCountries() {

		LOGGER.info("Start");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");

		}
	private static void getAllCountriesTest() {

		LOGGER.info("Start");
		Country country;
		try {
			country = countryService.findCountryByCode("IN");
			LOGGER.debug("Country:{}", country);
		} catch (CountryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		LOGGER.info("End");

		}
	public static void testAddCountry()
	{
		Country country1=new Country("Hn","Hondurus");
		countryService.addCountry(country1);
		try {
			countryService.findCountryByCode("Hn");
			
		} catch (CountryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void testUpdateCountry() {
		countryService.updateCountry("Hn","BCD");
	}
	

	private static void testDeleteCountry() {
		countryService.deleteCountry("Hn");
	}
	
	private static void testFindByName()
	{
		LOGGER.info("Start");

		List<Country> countries = countryService.findByName("ou");

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");

		
	}
	
	private static void testFindByFirstName()
	{
		LOGGER.info("Start");

		List<Country> countries = countryService.findByFirstName("Z");

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");

		
	}
	
	private static void testGetByDate()
	{
		LOGGER.info("Start");

		List<Stock> stocks = stockService.getByDate();

		LOGGER.debug("stocks={}", stocks);

		LOGGER.info("End");
	}
	private static void testGetByPrice()
	{
		LOGGER.info("Start");

		List<Stock> stock = stockService.getByPrice();

		LOGGER.debug("stocks={}", stock);

		LOGGER.info("End");
	}
	
	private static void testGetByVolume()
	{
		LOGGER.info("Start");

		List<Stock> stock = stockService.getByVolume();

		LOGGER.debug("stocks={}", stock);

		LOGGER.info("End");
	}
	
	private static void testGetByClose()
	{
		LOGGER.info("Start");

		List<Stock> stock = stockService.getByClose("NFLX");

		LOGGER.debug("stocks={}", stock);

		LOGGER.info("End");
	}
	
	private static void testGetEmployee() {

		LOGGER.info("Start");

		Employee employee = employeeService.get(1);

		LOGGER.debug("Employee:{}", employee);

		LOGGER.debug("Department:{}", employee.getDepartment());
		
		LOGGER.debug("Skills:{}", employee.getSkillList());

		LOGGER.info("End");

		}
	
	public static void testAddEmployee()
	{
		LOGGER.info("Start");
		Employee employee=new Employee();
		employee.setId(88);
		employee.setName("Sohini");
		employee.setPermanent(true);
		employee.setSalary(50000.00);
		employee.setDateOfBirth(new Date());
		Department dept=departmentService.get(1);
		employee.setDepartment(dept);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.info("End");
	}
	
	private static void testUpdateEmployee() {

		LOGGER.info("Start");

		Employee emp = employeeService.get(5);
		Department department=departmentService.get(2);
		emp.setDepartment(department);
		employeeService.save(emp);

		LOGGER.debug("Employee:{}", emp);

		LOGGER.debug("Department:{}", emp.getDepartment());

		LOGGER.info("End");

		}
	
	private static void testGetDepartment() {

		LOGGER.info("Start");

		
		Department dept1=departmentService.get(3);
		
	

		LOGGER.debug("Departments:{}",dept1 );

		LOGGER.debug("EmployeeList:{}", dept1.getEmployeeList());

		LOGGER.info("End");

		}
	
	private static void testAddSkillToEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		Skill skill = skillService.get(3);
		Set<Skill> skillList = employee.getSkillList();
		skillList.add(skill);
		employee.setSkillList(skillList);
		System.out.println(employee.getSkillList());
		employeeService.save(employee);
		LOGGER.info("End");
	}
	
	
}
