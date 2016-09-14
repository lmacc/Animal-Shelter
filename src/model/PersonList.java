package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by leslie on 18/04/2016.
 */
public class PersonList  implements Serializable{
    private ArrayList<Person> personList = new ArrayList<Person>();
    public PersonList(){}

    public void addPerson(Person person){
        personList.add(person);
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void removePerson(Person person){
        personList.remove(person);
    }

    public Person get(int p){
        return personList.get(p);
    }

    public void clearPersonList(){
        personList.clear();
    }

    public int size(){
        return personList.size();
    }
}
