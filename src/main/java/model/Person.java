package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Person") //it means this name is root in xml
//@XmlType(propOrder = {"firstname","phonenumber","lastname"})
public class Person {
    private String firstname;
    private String lastname;
    private String phonenumber;

    public Person() {
        /*JAXB does XML to java object conversion
        which is why it needs a no-arg constructor
        it'll need to instantiate the object first*/
    }

    public Person(String firstname, String lastname, String phonenumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
    }

    @XmlElement(name = "PersonName")
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

    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return firstname + ", " + lastname + ", " + phonenumber;
    }
}
