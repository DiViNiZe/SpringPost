package assingment.post.postservice.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

@Autowired
private UserRepository userRepository;

public UserService(){
  super();
}

public List<User> getAllUser() {
  return userRepository.findAll();
}

public User getUserById(long id) {
  return userRepository.getOne(id);
}

public void createUser(User user){
  userRepository.save(user);
}

public void delete(long id){
  userRepository.deleteById(id);
}
 
}