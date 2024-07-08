package org.example.flowing.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String password;

    public UserDTO (UserEntity userEntity) {
        this.firstName = userEntity.getFirstName();
        this.lastName = userEntity.getLastName();
        this.address = userEntity.getAddress();
        this.email = userEntity.getEmail();
        this.password = userEntity.getPassword();
    }
}
