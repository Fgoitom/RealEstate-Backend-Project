package com.ibex.pms.service;

import com.ibex.pms.domain.User;
import com.ibex.pms.domain.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.security.auth.login.CredentialException;
import java.util.List;

public interface UserService {

    /*
    *
    * for eager load
    * */

    List<User> getAll();
    User getById(long id);
    void deleteById(long id);
    void save(User user);
    void update(long id, User user);

    /*
    * End for eager load
    * */

    UserDto getCustomerById(long id);
    UserDto getOwnerById(long id);
    UserDto getAdminById(long id);
    List<UserDto>getAllUsers();
    List<UserDto>getAllCustomers();
    List<UserDto>getAllOwners();
    List<UserDto>getAllAdmin();
    void deleteCustomerById(long id);
    void deleteOwnerById(long id);
    void deleteAdminById(long id);
    //void updateUserById(User user, long id);
}
