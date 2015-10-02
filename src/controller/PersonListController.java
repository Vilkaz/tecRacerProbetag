package controller;

import dto.Header;
import dto.Person;
import dto.PersonList;

import java.util.List;

/**
 * User: Vilius Kukanauskas
 * Package: controller
 * Date: 30.09.2015
 * Time: 1:48 PM
 */
public class PersonListController {

    public static PersonList getPersonList() {
        List<Person> persons = PersonController.getPersonList();
        Header header = HeaderController.getHeader();
        PersonList personList = new PersonList(header, persons);
        setMaxLengths(personList);
        return personList;
    }

    private static void setMaxLengths(PersonList personList) {
        for (Person person : personList.getPersons()) {

            if (personList.getMaxIdLength() < person.getId().toString().length()) {
                           personList.setMaxIdLength(person.getId().toString().length());
                       }

            if (personList.getMaxNameLength() < person.getName().length()) {
                personList.setMaxNameLength(person.getName().length());
            }

            if (personList.getMaxLastnameLength() < person.getLastname().length()) {
                personList.setMaxLastnameLength(person.getLastname().length());
            }

            if (personList.getMaxAgeLength() < person.getAge().toString().length()) {
                personList.setMaxAgeLength(person.getAge().toString().length());
            }

        }
    }

    public static void handleInput(String input){
        Command command;


    }

    private static void incrementCurrentPage(){
        if (PersonList.getPersonNumber()<PersonList.getMaxPages()){
            PersonList.setPersonNumber(PersonList.getPersonNumber()+1);
        }
    }

}
