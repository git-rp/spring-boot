package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController
{
    @Autowired
    private CustomerRepository repository;
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @RequestMapping("/customer")    
    Customer customer() {
	repository.save(new Customer("Jack", "Bauer"));
	repository.save(new Customer("Chloe", "O'Brian"));
	repository.save(new Customer("Kim", "Bauer"));
	repository.save(new Customer("David", "Palmer"));
	repository.save(new Customer("Michelle", "Dessler"));
	repository.save(new Customer("Michelle", "Obama"));

	// fetch all customers
	log.info("Customers found with findAll():");
	log.info("-------------------------------");
	for (Customer customer : repository.findAll())
	    {
		log.info(customer.toString());
	    }
	log.info("");

	// fetch an individual customer by ID
	Customer customer = repository.findOne(1L);
	log.info("Customer found with findOne(1L):");
	log.info("--------------------------------");
	log.info(customer.toString());
	log.info("");

	// fetch customers by last name
	log.info("Customer found with findByLastName('Bauer'):");
	log.info("--------------------------------------------");
	for (Customer bauer : repository.findByLastName("Bauer"))
	    {
		log.info(bauer.toString());
	    }
	log.info("");
	// fetch customers by first name
	log.info("Customer found with findByFirst('Michelle'):");
	log.info("--------------------------------------------");
	for (Customer firstname : repository.findByFirstName("Michelle"))
	    {
		log.info(firstname.toString());
	    }
	return customer;
    }

}
