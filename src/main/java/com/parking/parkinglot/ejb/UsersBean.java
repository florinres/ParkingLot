package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.UserDto;
import com.parking.parkinglot.entities.User;
import jakarta.ejb.EJBException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UsersBean {
    @PersistenceContext
    EntityManager em;
    private static final Logger log = Logger.getLogger(UsersBean.class.getName());

    private Long ID;
    private String EMAIL;
    private String PASSWORD;
    private String USERNAME;

    public UsersBean(Long ID, String EMAIL, String PASSWORD, String USERNAME) {
        this.ID = ID;
        this.EMAIL = EMAIL;
        this.PASSWORD = PASSWORD;
        this.USERNAME = USERNAME;
    }

    public Long getID() {
        return ID;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public List<UserDto> findAllUsers(){
        log.info("findAllUsers");
        try {
            TypedQuery<User> typedQuery = em.createQuery("SELECT u FROM User u", User.class);
            List<User> users = typedQuery.getResultList();
            return copyUsersToDto(users);
        }catch (Exception e){
            throw new EJBException();
        }
    }

    private List<UserDto> copyUsersToDto(List<User> users) {
        List<UserDto> temp = new ArrayList<>();
        for (User user : users) {
            Long ID = user.getId();
            String EMAIL = user.getEmail();
            String PASSWORD = user.getPassword();
            String USERNAME = user.getUsername();
            temp.add(new UserDto(ID, USERNAME, PASSWORD, EMAIL));
        }

        return temp;
    }
}
