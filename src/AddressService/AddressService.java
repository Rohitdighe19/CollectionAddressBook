package AddressService;

import AddressModel.Person;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressService implements Iservice {
    Scanner s = new Scanner(System.in);

    @Override
    public void addBook(Map<String, List<Person>> addressBookMap) {
        System.out.println("Enter Book Name");
        String name = s.next();
        addressBookMap.put(name, new ArrayList<>());
    }

    @Override
    public void displayAllBooks(Map<String, List<Person>> addressBookMap) {
        addressBookMap.forEach((k, v) -> System.out.println(k + " " + v));

    }


    @Override
    public void deleteBook(Map<String, List<Person>> addressBookMap) {
        System.out.println("Enter Book Name");
        String name = s.next();
        if( addressBookMap.containsKey(name)){
            addressBookMap.remove(name);
        }
    }

    @Override
    public void addContact(List<Person> personList) {
        Person person = new Person();
        System.out.println("Enter First Name");
        String firstname = s.next();
        System.out.println("Enter Last Name");
        String lastname = s.next();
        System.out.println("Enter Address");
        String address = s.next().concat(s.nextLine());
        System.out.println("Enter City");
        String city = s.next();
        System.out.println("Enter State");
        String state = s.next();
        System.out.println("Enter Zip Code");
        int zip = s.nextInt();
        System.out.println("Enter Phone Number");
        long phonenumber = s.nextLong();
        System.out.println("Enter Email Address");
        String email = s.next();
        person.setFirstname(firstname);
        person.setLastname(lastname);
        person.setAddress(address);
        person.setCity(city);
        person.setState(state);
        person.setZip(zip);
        person.setPhonenumber(phonenumber);
        person.setEmail(email);
        personList.add(person);
    }

    @Override
    public void viewContact(List<Person> personList) {
        personList.forEach(System.out::println);
    }

    @Override
    public void editContact(List<Person> personList) {
        System.out.println("Enter First Name");
        String FirstName = s.next();
        System.out.println("Enter Last Name");
        String LastName = s.next();
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getFirstname().equals(FirstName) && personList.get(i).getLastname().equals(LastName)) {
                System.out.println("Enter Address");
                String newaddress = s.next().concat(s.nextLine());
                System.out.println("Enter City");
                String newcity = s.next();
                System.out.println("Enter State");
                String newstate = s.next();
                System.out.println("Enter Zip");
                int newzip = s.nextInt();
                System.out.println("Enter Phone Number");
                long newphonenumber = s.nextLong();
                System.out.println("Enter Email");
                String newemail = s.next();
                personList.get(i).setAddress(newaddress);
                personList.get(i).setCity(newcity);
                personList.get(i).setState(newstate);
                personList.get(i).setZip(newzip);
                personList.get(i).setPhonenumber(newphonenumber);
                personList.get(i).setEmail(newemail);
            }
        }
    }

    @Override
    public void deleteContact(List<Person> personList) {
        System.out.println("Enter First Name");
        String deletefirstname = s.next();
        System.out.println("Enter Last Name");
        String deletelastname = s.next();
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getFirstname().equals(deletefirstname) && personList.get(i).getLastname().equals(deletelastname)) {
                personList.remove(i);
                break;
            }
        }
    }
}