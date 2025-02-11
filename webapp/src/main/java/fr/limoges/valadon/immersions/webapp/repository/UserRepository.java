package fr.limoges.valadon.immersions.webapp.repository;
import fr.limoges.valadon.immersions.webapp.CustomProperties;
import fr.limoges.valadon.immersions.webapp.model.Users;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);

    @Autowired
    CustomProperties props = null;



    public default Iterable<Users> getEmployees() {

        System.out.println("props.getApiUrl() = " + props.getApiUrl());
        String baseApiUrl = props.getApiUrl();
        String getEmployeesUrl = baseApiUrl + "/employees";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Users>> response = restTemplate.exchange(
                getEmployeesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Users>>() {}
        );

        return response.getBody();
    }


    public default Users getUsers(int id) {
        String baseApiUrl = props.getApiUrl();
        String getEmployeeUrl = baseApiUrl + "/employee/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Users> response = restTemplate.exchange(
                getEmployeeUrl,
                HttpMethod.GET,
                null,
                Users.class
        );


        return response.getBody();
    }


    public default Users createUsers(Users e) {
        String baseApiUrl = props.getApiUrl();
        String createEmployeeUrl = baseApiUrl + "/employee";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Users> request = new HttpEntity<Users>(e);
        ResponseEntity<Users> response = restTemplate.exchange(
                createEmployeeUrl,
                HttpMethod.POST,
                request,
                Users.class);


        return response.getBody();
    }


    public default Users updateUsers(Users e) {
        String baseApiUrl = props.getApiUrl();
        String updateEmployeeUrl = baseApiUrl + "/employee/" + e.getIdUser();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Users> request = new HttpEntity<Users>(e);
        ResponseEntity<Users> response = restTemplate.exchange(
                updateEmployeeUrl,
                HttpMethod.PUT,
                request,
                Users.class);


        return response.getBody();
    }


    public default void deleteUser(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteEmployeeUrl = baseApiUrl + "/employee/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteEmployeeUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

    }

}