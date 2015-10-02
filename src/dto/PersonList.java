package dto;

import java.util.List;

/**
 * User: Vilius Kukanauskas
 * Package: dto
 * Date: 30.09.2015
 * Time: 12:24 PM
 */
public class PersonList {

    private Header       header;
    private List<Person> persons;
    private int          maxIdLength;
    private int          maxNameLength;
    private int          maxAgeLength;
    private int          maxLastnameLength;
    private int amoutOfPersonPerPage = 20;
    private static int maxPages=1;
    private static int currentPage  = 1;
    private static int personNumber = 1;


    public PersonList(Header header, List<Person> persons) {
        this.header = header;
        this.persons = persons;
        this.maxIdLength = header.getColumns().get(0).length();
        this.maxNameLength = header.getColumns().get(1).length();
        this.maxAgeLength = header.getColumns().get(2).length();
        this.maxLastnameLength = header.getColumns().get(3).length();
        this.maxPages = (int) persons.size() / 20;
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s|" +
                                     "\n" + "%s" + "%s" + "%s",
                             fixedLengthString(this.header.getColumns().get(0), this.getMaxIdLength()),
                             fixedLengthString(this.header.getColumns().get(1), this.getMaxNameLength()),
                             fixedLengthString(this.header.getColumns().get(2), this.getMaxAgeLength()),
                             fixedLengthString(this.header.getColumns().get(3), this.getMaxLastnameLength()),
                             getHeaderSeparationLine(),
                             getPersonsAsString(),
                             "\nN(ext page, P(revious page, F(irst page, L(ast page, J(ump to page, eX(it"
                            );

    }

    private String fixedLengthString(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    private String getPersonsAsString() {
        String result = "";

        for (Person person : getPersonSublist()) {
            result += String.format("%n%s|%s|%s|%s|",
                                    fixedLengthString(Integer.toString(person.getId()), this.getMaxIdLength()),
                                    fixedLengthString(person.getName(), this.getMaxNameLength()),
                                    fixedLengthString(person.getAge().toString(), this.getMaxAgeLength()),
                                    fixedLengthString(person.getLastname(), this.getMaxLastnameLength()));
        }
        return result;
    }

    private List<Person> getPersonSublist(){
        int begin = this.amoutOfPersonPerPage*(this.currentPage-1);
        int end = this.amoutOfPersonPerPage*(this.currentPage)+1;
        List<Person> result =  this.getPersons().subList(begin, end);
        return result;
    }

    public static void incrementPersonNummber(){
        PersonList.personNumber++;
    }

    private String getHeaderSeparationLine() {
        String result = String.format("%" + (this.getMaxIdLength() + 1) + "s", "+").replace(' ', '-');
        result += String.format("%" + (this.getMaxNameLength() + 1) + "s", "+").replace(' ', '-');
        result += String.format("%" + (this.getMaxAgeLength() + 1) + "s", "+").replace(' ', '-');
        result += String.format("%" + (this.getMaxLastnameLength() + 1) + "s", "+").replace(' ', '-');
        return result;
    }

    //region getter and setter


    public static int getMaxPages() {
        return PersonList.maxPages;
    }

    public int getMaxIdLength() {
        return maxIdLength;
    }

    public void setMaxIdLength(int maxIdLength) {
        this.maxIdLength = maxIdLength;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public int getMaxNameLength() {
        return maxNameLength;
    }

    public void setMaxNameLength(int maxNameLength) {
        this.maxNameLength = maxNameLength;
    }

    public int getMaxAgeLength() {
        return maxAgeLength;
    }

    public void setMaxAgeLength(int maxAgeLength) {
        this.maxAgeLength = maxAgeLength;
    }

    public int getMaxLastnameLength() {
        return maxLastnameLength;
    }

    public void setMaxLastnameLength(int maxLastnameLength) {
        this.maxLastnameLength = maxLastnameLength;
    }

    public static int getPersonNumber() {
        return personNumber;
    }

    public static void setPersonNumber(int personNumber) {
        PersonList.personNumber = personNumber;
    }


    //endregion getter and setter

}
