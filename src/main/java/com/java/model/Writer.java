package com.java.model;

import java.time.LocalDate;
import java.util.Objects;

public class Writer {
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;

    public Writer(String firstname, String lastname, LocalDate dateOfBirth) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Writer writer = (Writer) o;
        return Objects.equals(firstname, writer.firstname) && Objects.equals(lastname, writer.lastname) && Objects.equals(dateOfBirth, writer.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Writer {" +
                "firstname = " + firstname +
                ", lastname = " + lastname +
                ", dateOfBirth = " + dateOfBirth +
                "}";
    }
}
