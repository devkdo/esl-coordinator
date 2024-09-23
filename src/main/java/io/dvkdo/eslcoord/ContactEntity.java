package io.dvkdo.eslcoord;

import java.util.Map;
import org.apache.commons.validator.routines.EmailValidator;
import com.google.gson.Gson;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class ContactEntity extends PanacheEntity {
    public String firstname;
    public String lastname;
    public String email;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        assert EmailValidator.getInstance().isValid(email) : "Email format is invalid";
        this.email = email;
    }

    @Override
    public String toString() {
        return new Gson().toJson(Map.of("First", firstname, "Last", lastname, "Email", email));
    }

}
