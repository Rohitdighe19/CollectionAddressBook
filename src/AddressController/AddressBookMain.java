package AddressController;

import AddressModel.Person;
import AddressService.AddressService;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AddressBookMain {
    static Scanner s = new Scanner(System.in);

    AddressService addressService = new AddressService();

    public static void main(String[] args) {
        AddressBookMain addressBookMain = new AddressBookMain();
        System.out.println("Welcome to the Address book program"); // Welcome statement
        addressBookMain.menu();
    }

    public void menu() {

        Map<String, List<Person>> addressBookMap = new HashMap<>();
        int option = 0;
        while (option != 9) {
            System.out.println("1: Add Address Book ");
            System.out.println("2: Display Address Book");
            System.out.println("3: Edit Address Book");
            System.out.println("4: Delete Address Book");
            System.out.println("5: Search By City");
            System.out.println("6: Search By State");
            System.out.println("7: Count By City");
            System.out.println("8: Count By State");
            System.out.println("9: Exit");
            option = s.nextInt();
            switch (option) {
                case 1 -> addressService.addBook(addressBookMap);
                case 2 -> addressService.displayAllBooks(addressBookMap);
                case 3 -> contactMenu(addressBookMap);
                case 4 -> addressService.deleteBook(addressBookMap);
                case 5 -> searchByCity(addressBookMap);
                case 6 -> searchByState(addressBookMap);
                case 7 -> countByCity(addressBookMap);
                case 8 -> countByState(addressBookMap);
                case 9 -> option = 9;
            }
        }
    }

    private void countByState(Map<String, List<Person>> bookList) {
        AtomicInteger count = new AtomicInteger();
        System.out.println("Enter State Name:");
        String stateName = s.next();

        bookList.keySet().forEach(entry -> {
            List<Person> list = bookList.get(entry);
            list.forEach(contact -> {
                if (stateName.equalsIgnoreCase(contact.getState())) {
                    count.getAndIncrement();
                }
            });
        });
        System.out.println(count);
    }

    private void countByCity(Map<String, List<Person>> bookList) {
        AtomicInteger count = new AtomicInteger();
        System.out.println("Enter City Name:");
        String cityName = s.next();

        bookList.keySet().forEach(entry -> {
            List<Person> list = bookList.get(entry);
            list.forEach(contact -> {
                if (cityName.equalsIgnoreCase(contact.getCity())) {
                    count.getAndIncrement();
                }
            });
        });
        System.out.println(count);
    }

    public void contactMenu(Map<String, List<Person>> addressBookMap) {
        System.out.println("Enter Book Name");
        String bookName = s.next();
        if (addressBookMap.containsKey(bookName)) {
            List<Person> contactList = addressBookMap.get(bookName);
            int check = 0;
            while (check != 5) {
                System.out.println("Enter 1 to Add Contacts");//Taking Input From User
                System.out.println("Enter 2 to View Contacts");
                System.out.println("Enter 3 to Edit Contacts");
                System.out.println("Enter 4 to Delete Contacts");
                System.out.println("Enter 5 to Exit");
                check = s.nextInt();
                switch (check) {
                    case 1 -> addressService.addContact(contactList);
                    case 2 -> addressService.viewContact(contactList);
                    case 3 -> addressService.editContact(contactList);
                    case 4 -> addressService.deleteContact(contactList);
                    case 5 -> check = 5;
                }
            }
        }
    }

    public void searchByCity(Map<String, List<Person>> bookList) {
        System.out.println("Enter City Name:");
        String cityName = s.next();

        bookList.keySet().forEach(entry -> {
            List<Person> list = bookList.get(entry);
            list.forEach(contact -> {
                if (cityName.equalsIgnoreCase(contact.getCity())) {
                    System.out.println(contact);
                }
            });
        });
    }

    public void searchByState(Map<String, List<Person>> bookList) {
        System.out.println("Enter State Name:");
        String stateName = s.next();

        bookList.keySet().forEach(entry -> {
            List<Person> list = bookList.get(entry);
            list.forEach(contact -> {
                if (stateName.equalsIgnoreCase(contact.getState())) {
                    System.out.println(contact);
                }
            });
        });
    }

}
