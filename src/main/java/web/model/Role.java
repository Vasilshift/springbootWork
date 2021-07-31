package web.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.security.Permission;
import java.util.*;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

//    @Transient
//    @ManyToMany(mappedBy = "roles")
//    private Collection<User> users;

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
        //this.users = users;
    }

    public Role() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }

//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        final List<SimpleGrantedAuthority> authorities = new LinkedList<>();
//
//        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
//    }




//    public Collection<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Collection<User> users) {
//        this.users = users;
//    }
}
