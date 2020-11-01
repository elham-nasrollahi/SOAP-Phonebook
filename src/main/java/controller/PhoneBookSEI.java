package controller;

import model.Person;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(
        name = "PhoneBook" , targetNamespace = "http://www.phonebook.com"
)

public interface PhoneBookSEI {

    @WebMethod
    @WebResult(name = "Person")
    public List<Person> getAllPerson();

    @WebMethod
    public Person addPerson(String firstName, String lastName, String phoneNumber);

    @WebMethod
    public Person searchPerson(String firstName);

    @WebMethod
    public boolean deletPerson (String firstName);

    @WebMethod
    public Person updatePerson(String firstName, String lastname,String phoneNumber);
}
