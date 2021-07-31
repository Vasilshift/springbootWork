package web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.repository.UserRepository;
import web.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service   //("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
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

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username).orElseThrow(() ->
//                new UsernameNotFoundException("User doesn't exists"));
//        return MySecurityUser.transferUserToUserDetails(user);
//    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.loadUserByUsername(username);
    }
}
