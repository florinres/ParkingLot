package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.UserDto;
import com.parking.parkinglot.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UsersBean {
    private static final Logger log = Logger.getLogger(UsersBean.class.getName());

    @PersistenceContext
    private EntityManager em;
    EntityManagerFactory emf;

    private Long ID;
    private String EMAIL;
    private String PASSWORD;
    private String USERNAME;

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
        emf = Persistence.createEntityManagerFactory("ParkingLot");
        em = emf.createEntityManager();
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
