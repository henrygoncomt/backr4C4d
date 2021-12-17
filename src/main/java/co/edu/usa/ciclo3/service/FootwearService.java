/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.ciclo3.service;

import co.edu.usa.ciclo3.modelo.Footwear;
import co.edu.usa.ciclo3.repository.FootwearRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author hgc68
 */
@Service
public class FootwearService {
    
    @Autowired
    private FootwearRepository footwearRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Footwear> getAll() {
        return footwearRepository.getAll();
    }

   public Optional<Footwear> getFootwears(String reference) {
        return footwearRepository.getFootwears(reference);
    }

    public Footwear create(Footwear Footwears) {
        if (Footwears.getReference() == null) {
            return Footwears;
        } else {
            return footwearRepository.create(Footwears);
        }
    }

    public Footwear update(Footwear Footwears) {

        if (Footwears.getReference() != null) {
            Optional<Footwear> FootwearsDb = footwearRepository.getFootwears(Footwears.getReference());
            if (FootwearsDb.isPresent()) {
                
                if (Footwears.getBrand()!= null) {
                    FootwearsDb.get().setBrand(Footwears.getBrand());
                }
                
                if (Footwears.getCategory() != null) {
                    FootwearsDb.get().setCategory(Footwears.getCategory());
                }

                if (Footwears.getMaterial() != null) {
                    FootwearsDb.get().setMaterial(Footwears.getMaterial());
                }

                if (Footwears.getGender() != null) {
                    FootwearsDb.get().setGender(Footwears.getGender());
                }

                if (Footwears.getSize() != null) {
                    FootwearsDb.get().setSize(Footwears.getSize());
                }
                
                if (Footwears.getDescription() != null) {
                    FootwearsDb.get().setDescription(Footwears.getDescription());
                }
                if (Footwears.getPrice() != 0.0) {
                    FootwearsDb.get().setPrice(Footwears.getPrice());
                }
                if (Footwears.getQuantity() != 0) {
                    FootwearsDb.get().setQuantity(Footwears.getQuantity());
                }
                if (Footwears.getPhotography() != null) {
                    FootwearsDb.get().setPhotography(Footwears.getPhotography());
                }
                
                FootwearsDb.get().setAvailability(Footwears.isAvailability());
                footwearRepository.update(FootwearsDb.get());
                return FootwearsDb.get();
            } else {
                return Footwears;
            }
        } else {
            return Footwears;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getFootwears(reference).map(Footwears -> {
            footwearRepository.delete(Footwears);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    //* Reto 5 metodos
    public List<Footwear> getProductByPrice(double price){
        return footwearRepository.getProductbyPrice(price);
    }
    public List<Footwear> getProductByDescription(String description){
        return footwearRepository.getProductByDescription(description);
    }

    public List<Footwear> getByCategory(String category){
        return footwearRepository.getByCategory(category);
    }
}