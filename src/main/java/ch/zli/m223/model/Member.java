package ch.zli.m223.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@NamedQueries({
    @NamedQuery(name = "ApplicationUser.findByID", query = "SELECT u FROM ApplicationUser u WHERE u.ID = :ID")
})
public class Member extends ApplicationUser {

    @Column(nullable = false, unique = true)
    private String email;
  
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    // ? @JsonIgnoreProperties("members")
    @Fetch(FetchMode.JOIN)
    private Set<Booking> bookings;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
    
}
