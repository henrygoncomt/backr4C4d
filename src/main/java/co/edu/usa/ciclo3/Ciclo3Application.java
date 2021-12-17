package co.edu.usa.ciclo3;

import co.edu.usa.ciclo3.repository.crud.UserCrudRepository;
import co.edu.usa.ciclo3.repository.crud.FootwearCrudRepository;
import co.edu.usa.ciclo3.repository.crud.OrderCrudRepository;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


@Component
@SpringBootApplication
public class Ciclo3Application implements CommandLineRunner{
        @Autowired
        private UserCrudRepository userCrudRepository;
        @Autowired
        private FootwearCrudRepository footwearCrudRepository;
        @Autowired
        private OrderCrudRepository orderCrudRepository;
        
	public static void main(String[] args) {
            SpringApplication.run(Ciclo3Application.class, args);
	}
        
        @Override
        public void run(String...  args) throws Exception{
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            userCrudRepository.deleteAll();
            footwearCrudRepository.deleteAll();
            orderCrudRepository.deleteAll();
        }

}
