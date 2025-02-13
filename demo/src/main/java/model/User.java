package model;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    String id;
    String name;
    String email;
    String username;
    String password;
}
