package lab3.services;

import lab3.entity.User;
import lab3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> login(String email, String password) {
        System.out.println(email+ " " + password);

        List<User> user = new ArrayList<User>();

        user = userRepository.findByEmail(email);

        if (user.size() > 0){
            String db_password = user.get(0).getPassword();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if(encoder.matches(password, db_password)){
                return  user;
            }
        }

        return null;
    }

    public Optional<User> getUser(Long id) {
        Optional<User> user;
        user = userRepository.findById(Long.parseLong(id+""));
        return user;
    }

    public void save(User user) {
        user.setCreated_at(new Date());
        userRepository.save(user);
    }

    public List<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public String updateUser(User user) {

        List<User> currentUser = userRepository.findByEmail(user.getEmail());

        System.out.println("I am user" + currentUser);

        currentUser.get(0).setName(user.getName());
        currentUser.get(0).setEmail(user.getEmail());
        currentUser.get(0).setPhone_number(user.getPhone_number());
        currentUser.get(0).setSkills(user.getSkills());
        currentUser.get(0).setAbout_me(user.getAbout_me());

        userRepository.save(currentUser.get(0));

        return "";

    }

    public Optional<User> getUserById(Long id){
        return  userRepository.findById(id);
    }

    public User setProfileImage(Long id, String newFileName){

        Optional<User> user = userRepository.findById(id);
        user.get().setProfile_image_name(newFileName);
        userRepository.save(user.get());

        return  user.get();
    }

    public  Iterable<User> findAllUsers(){
        return  userRepository.findAll();
    }

}
