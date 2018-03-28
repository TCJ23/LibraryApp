package crud.user;

import java.time.LocalDate;


//reprezentuje request do uzyskania usera
public class CreateUserDto {

    private String name;

    public CreateUserDto(String name) {
        this.name = name;
    }

    public CreateUserDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    private String lastname;
//    private String username;
//    private String email;
//    LocalDate birthDate;
//
//    @Override
//    public String toString() {
//    return name + " " + lastname + " " + username + " " + birthDate;
//    }
//
//    public String getFirstname() {
//        return name;
//    }
//
//    public void setFirstname(String name) {
//        this.name = name;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public LocalDate getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(LocalDate birthDate) {
//        this.birthDate = birthDate;
//    }
}
