package utc.train.pojo;

import java.io.Serializable;

/**
 * @author Bill
 * @version 2012-02-03
 */
public class Employee implements Serializable{
    
    private Long id;
    
    private String surname;
    private String givenName;

    private String ssn;
    private String century;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getCentury() {
        return century;
    }

    public void setCentury(String century) {
        this.century = century;
    }
}
