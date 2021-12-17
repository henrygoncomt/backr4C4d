/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.ciclo3.repository.crud;

import co.edu.usa.ciclo3.modelo.Footwear;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author hgc68
 */
public interface FootwearCrudRepository extends MongoRepository<Footwear, String>{
    //*Reto 5 metodos
    @Query("{'price': {$lte:?0}}")
    List<Footwear> findByPrice(double price);

    @Query("{'description': {$regex:?0,$options:'i'}}")
    List<Footwear> findByDescription(String description);

    @Query("{'category': {$regex:?0,$options:'i'}}")
    List<Footwear> findByCategory(String category);


}

