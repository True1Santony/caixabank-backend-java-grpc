package io.nuwe.technical.api.services;

import io.nuwe.technical.api.entities.*;
import io.nuwe.technical.api.repositories.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
	this.userRepository= userRepository;
    }

    public List<User> getAllUsers(){
	List<User> users = userRepository.findAll();
	return users;
    }

    public Optional<User> getUserById(long id){
	Optional<User> user = userRepository.findById(id);
	return user;
    }

    public User createUser(User u){
        u.setSubscribed(true);
        validateUser(u);
        return userRepository.save(u);
    }

    //implementar logica de guardado si procede.
    public void saveUser(User t){
	userRepository.save(t);
    }

    public boolean deleteUser(Long id){
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void deleteAll(){
	userRepository.deleteAll();
    }

    // Validación de campos del usuario
    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("El objeto User no puede ser nulo.");
        }

        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("El campo 'name' es obligatorio.");
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El campo 'email' es obligatorio.");
        }

        if (!isValidEmail(user.getEmail())) {
            throw new IllegalArgumentException("El formato del email es inválido.");
        }

        if (user.getAge() <= 0) {
            throw new IllegalArgumentException("El campo 'age' debe ser un número positivo mayor a cero.");
        }
    }

    // Validación del formato de email
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }


}
