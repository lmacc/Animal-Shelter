package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by leslie on 12/03/2016.
 */
public class AnimalList implements Serializable {

    ArrayList<Animal> animals = new ArrayList<>();

    public AnimalList() {

    }



    public void addAnimal(Animal animal) {
        animals.add(animal);

    }



    public ArrayList<Animal> getAnimals(){
        return animals;
    }
    /*
    public void writeToAnimalFile() {

        try {

            ObjectOutputStream bw = new ObjectOutputStream(new FileOutputStream(("src//data//AnimalLost"),true));

            for (Animal list : animals) {
                bw.writeObject(list + "\n");
            }
            bw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        animals.clear();
    }
*/
    public void removeAnimal(Animal animal) {
        animals.remove(animal);

    }

    public void clearTheList(){
        animals.clear();
    }

    public int size(){
        return animals.size();
    }

    public Animal get(int i) {
        return animals.get(i);
    }


    public void getLostList() {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getAnimalCat() instanceof Lost) {
                System.out.print(animals.get(i).toString());
            }

        }
    }

    public void getFoundList() {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getAnimalCat() instanceof Found) {
                System.out.print(animals.get(i).toString());
            }

        }
    }

    public void print() {

        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i));

        }
    }
}
