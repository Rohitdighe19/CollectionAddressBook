package AddressService;
import AddressModel.Person;

import java.util.List;
import java.util.Map;

public interface Iservice {
    void addBook(Map<String, List<Person>> addressBookMap);
    void displayAllBooks(Map<String, List<Person>> addressBookMap);
    //    void editBook(Map<String, List<Person>> addressBookMap);
    void deleteBook(Map<String, List<Person>> addressBookMap);
    void addContact(List<Person> personList);
    void viewContact(List<Person> personList);
    void editContact(List<Person> personList);
    void deleteContact(List<Person> personList);

}