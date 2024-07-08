package org.example.flowing.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public UserDTO saveUser(UserDTO user) {
        UserEntity userEntity = new UserEntity(user);
        this.userRepository.save(userEntity);
        kafkaTemplate.send("user_topic", "User registered: " + user.getEmail());
        return new UserDTO(userEntity);
    }

    public UserDTO getUser (Long userId) {
        Optional<UserEntity> userEntityOpt = this.userRepository.findById(userId);
        if(userEntityOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        return new UserDTO(userEntityOpt.get());
    }
}
