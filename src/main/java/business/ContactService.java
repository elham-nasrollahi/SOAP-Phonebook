package business;

import business.dbConnection.DatabaseConnection;
import model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class ContactService {

    DatabaseConnection databaseConnection = DatabaseConnection.getNewInstance();
    Connection connection = databaseConnection.getConnection();

    public List<Person> getAllPerson() {
        List<Person> personList = new ArrayList<Person>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM phonebook");

            while (rs.next()){
                Person person = new Person();
                // person.setPersonid(rs.getInt("id"));
                person.setFirstname(rs.getString("firstname"));
                person.setLastname(rs.getString("lastname"));
                person.setPhonenumber(rs.getString("phoneNum"));
                personList.add(person);
            }
        }catch (SQLException e){
            e.printStackTrace();;
        }
        return personList;
    }

    public Person addPerson(String firstName, String lastName, String phoneNumber) {
        Person person = new Person(firstName, lastName, phoneNumber);
        try {
                PreparedStatement st = connection.prepareStatement("INSERT INTO phonebook VALUES (?,?,?)");
                st.setString(1, person.getFirstname());
                st.setString(2, person.getLastname());
                st.setString(3, person.getPhonenumber());
                st.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        }
        return person;
    }

    public Person searchPerson(String firstName) {
        Person person = new Person();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * from phonebook WHERE firstname=?" );
            st.setString(1, firstName);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                // person.setPersonid(rs.getInt("id"));
                person.setFirstname(rs.getString("firstname"));
                person.setLastname(rs.getString("lastname"));
                person.setPhonenumber(rs.getString("phoneNum"));
            }
        }catch (SQLException e){
            e.printStackTrace();;
        }
        return person;
    }

    public boolean deletPerson (String firstName) {
        try {
            if ((firstName == "") || searchPerson(firstName) == null) return false;
            else {
                PreparedStatement st = connection.prepareStatement("DELETE FROM phonebook WHERE FIRSTNAME = ?");
                st.setString(1, firstName);
                st.executeUpdate();
            }
        }catch(SQLException e){
            e.printStackTrace();;
        }
        return true;
    }

    public Person updatePerson(String firstName, String lastname, String phoneNumber) {

        try {
            if ((firstName == "") || searchPerson(firstName) == null) return null;
            else {
                PreparedStatement st = connection.prepareStatement("UPDATE phonebook SET phoneNum = ? , lastname = ? WHERE firstname=?");
                st.setString(1, phoneNumber);
                st.setString(2, lastname);
                st.setString(3, firstName);
                // st.setInt(4, person.getPersonid());
                st.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return searchPerson(firstName);
    }
}

