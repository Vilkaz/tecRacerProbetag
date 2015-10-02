package dto;

/**
 * User: Vilius Kukanauskas
 * Package: dto
 * Date: 30.09.2015
 * Time: 10:28 AM
 */
public class Person {

    private Integer id;
    private  String  name;
    private  String  lastname;
    private  Integer age;

    public Person(int id,String firstname, String lastname, int age) {
        this.id = PersonList.getPersonNumber();
        this.name = firstname;
        this.lastname = lastname;
        this.age = age;
    }

  //region  getter, equals, hashcode


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getAge() {
        return age;
    }

    @Override
  public String toString() {
    return String.format("%s |  %s | %s |", name, lastname, age);
  }


    //endregion
}