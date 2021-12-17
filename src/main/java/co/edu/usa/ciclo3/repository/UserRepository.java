/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.ciclo3.repository;


import co.edu.usa.ciclo3.modelo.User;
import co.edu.usa.ciclo3.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hgc68
 */
@Repository
public class UserRepository {

    /**
     *
     */
    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     *
     * @return
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    /**
     *
     * @param user
     * @return
     */
    public User create(User user) {
        return userCrudRepository.save(user);
    }

    /**
     *
     * @param user
     */
    public void update(User user) {
        userCrudRepository.save(user);
    }

    /**
     *
     * @param user
     */
    public void delete(User user) {
        userCrudRepository.delete(user);
    }

    /**
     *
     * @param email
     * @return
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isPresent();
    }

    /**
     *
     * @param email
     * @param password
     * @return
     */
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    /**
     *
     * @return
     */
    public Optional<User> lastUserId() {
        return userCrudRepository.findTopByOrderByIdDesc();
    }

    /**
     *
     * @param monthBirthtDay
     * @return
     */
    //* Reto 5 metodos
    public List<User> birthtDayList(String monthBirthtDay) {
        return userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }

    public List<User> getByType(String type) {
        return userCrudRepository.findByType(type);
    }
}
