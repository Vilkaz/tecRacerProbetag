package controller;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.reader.CSVEntryParser;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import dto.Person;
import dto.PersonList;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * User: Vilius Kukanauskas
 * Package: controller
 * Date: 30.09.2015
 * Time: 10:32 AM
 */
public class PersonController implements CSVEntryParser<Person> {
    @Override
    public Person parseEntry(String... data) {
        Person person = new Person(1337,"Person " + data[1] + " " + data[0], "hat ungültige Altersangabe", 1337);
        try {
            person = new Person(PersonList.getPersonNumber(), data[1], data[0], Integer.parseInt(data[4]));
            PersonList.incrementPersonNummber();
        } catch (Exception e) {
            //logwriter(e)
        }
        return person;
    }

    public static List<Person> getPersonList() {
        Reader csvFile = CSVHelper.getInputStream();
        CSVReader<Person> personReader = new CSVReaderBuilder<Person>(csvFile).
                strategy(new CSVStrategy(',', '"', '#', true, true)).entryParser(
                new PersonController()).build();
        List<Person> persons = null;
        try {
            persons = personReader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;

    }

}
