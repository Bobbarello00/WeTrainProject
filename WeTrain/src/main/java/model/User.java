package model;

import java.time.LocalDate;

public abstract class User {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String fiscalCode;
    private String email;

    protected User(String name, String surname, LocalDate dateOfBirth, String fc, String email){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.fiscalCode = fc;
        this.email = email;
    }
}
