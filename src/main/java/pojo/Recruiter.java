package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recruiter {
    private int id;
    private String username;
    private String password;
    private String mail;
    private String company;
    private String information;

}
