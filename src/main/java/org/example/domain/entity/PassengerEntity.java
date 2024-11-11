package org.example.domain.entity;

import java.util.Objects;

public class PassengerEntity {

    private Long id;
    private String fullName;
    private String surname;
    private String login;
    private String password;

    public PassengerEntity(String fullName, String surname, String login, String password) {
        this(null, fullName, surname, login, password);
    }

    public PassengerEntity(Long id, String fullName, String surname, String login, String password) {
        this.id = id;
        this.fullName = fullName;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerEntity that = (PassengerEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(login, that.login) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }

    @Override
    public String toString() {
        return String.format("PassengerEntity{id='%s', fullName='%s', surname='%s', login='%s'}",
                id, fullName, surname, login);
    }
}
