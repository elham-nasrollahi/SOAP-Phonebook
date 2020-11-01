package controller;

import business.ContactService;
import model.Person;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "controller.PhoneBookSEI"
        , serviceName = "PhoneBookService" /*changing the service name change the default wsdl url*/
        , portName = "PhoneBookPort"  /*port name="PhoneBookImpPort" --> "PhoneBookPrt"*/
)

public class PhoneBookImp implements PhoneBookSEI {
    ContactService contactService = new ContactService();

    public List<Person> getAllPerson() {
        return contactService.getAllPerson();
    }

    public Person addPerson(String firstName, String lastName, String phoneNumber) {
        return contactService.addPerson(firstName, lastName, phoneNumber);
    }

    public Person searchPerson(String firstName) {
        return contactService.searchPerson(firstName);
    }

    public boolean deletPerson (String firstName) {
        return contactService.deletPerson(firstName);
    }

    public Person updatePerson(String firstName, String lastname, String phoneNumber) {
        return contactService.updatePerson(firstName, lastname, phoneNumber);
    }
}
