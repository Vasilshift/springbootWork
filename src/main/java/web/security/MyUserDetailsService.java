package web.security;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.model.User;
import web.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @PersistenceContext
    private EntityManager entityManager;

    private final UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public User loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.username=:username", User.class);
//        query.setParameter("username", username);
//        return query.getResultList().stream().findAny().orElse(null);
//
//        //return userRepository.findByUsername(username);
//
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exists"));
        return MySecurityUser.transferUserToUserDetails(user);
    }


}
