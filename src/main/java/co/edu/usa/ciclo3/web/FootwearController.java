/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.ciclo3.web;

import co.edu.usa.ciclo3.modelo.Footwear;
import co.edu.usa.ciclo3.service.FootwearService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hgc68
 */
@RestController
@RequestMapping("/api/accessory")
@CrossOrigin("*")
public class FootwearController {
    
    @Autowired
    private FootwearService footwearService;
       
     @GetMapping("/all")
    public List<Footwear> getAll() {
        return footwearService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Footwear> getFootwear(@PathVariable("reference") String reference) {
        return footwearService.getFootwears(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Footwear create(@RequestBody Footwear gadget) {
        return footwearService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Footwear update(@RequestBody Footwear gadget) {
        return footwearService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return footwearService.delete(reference);
    }

    //*Reto 5 metodos
    @GetMapping("/price/{price}")
    public List<Footwear> getByPrice(@PathVariable("price") double price) {
        return footwearService.getProductByPrice(price);
    }
    @GetMapping("/description/{description}")
    public List<Footwear> getByDescription(@PathVariable("description") String description) {
        return footwearService.getProductByDescription(description);
    }

    @GetMapping("/category/{category}")
    public List<Footwear> getByCategory(@PathVariable("category") String category) {
        return footwearService.getByCategory(category);
    }
}
