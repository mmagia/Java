import java.util.HashSet;
import java.util.Set;

public class Task2 {
    public static void main(String[] args) {
        final int test = 5;
        Set<Dog> animals = new HashSet<>();
        Dog archi = new Dog("archi", test);
        Dog leo = new Dog("leo", test);
        Main<Dog> dogHandler = new Main<>();
        dogHandler.addAnimals(animals, archi);
        dogHandler.addAnimals(animals, archi);
        dogHandler.addAnimals(animals, archi);
        dogHandler.addAnimals(animals, leo);
        dogHandler.addAnimals(animals, leo);
        dogHandler.displayAnimals(animals);
        dogHandler.makeTalk(animals);
    }
}




class Animal {
    private String nickname;

    public Animal() {

    }

    public Animal(String nickname) {
        this.nickname = nickname;
    }
    public void voice() { };
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void displayStatus() {
        System.out.println(getNickname());
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        Animal other = (Animal) obj;
        if (nickname == null) {
            if (other.nickname != null) {
                return false;
            }

        } else if (!nickname.equals(other.nickname)) {
            return false;
        }
        return true;
    }

}

class Main<T extends Animal> {
    public void displayAnimals(Set<T> animals) {
        for (T element: animals) {
            element.displayStatus();
        }
    }

    public void makeTalk(Set<T> animals) {
        for (T element: animals) {
            ((T) element).voice();
        }
    }

    public void addAnimals(Set<T> animals, T object) {
        animals.add(object);
    }
}

class Cat extends Animal {
    private int purLoudness;

    public Cat(String nickname, int purLoudness) {
        this.setNickname(nickname);
        this.purLoudness = purLoudness;
    }

    @Override
    public void voice() {
        System.out.println("Cat " + getNickname() + " is meowing with loudness " + getPurLoudness());
    }

    public int getPurLoudness() {
        return purLoudness;
    }

    public void setPurLoudness(int purLoudness) {
        this.purLoudness = purLoudness;
    }

    public void displayStatus() {
        System.out.println("Cat " + getNickname());
    }
}

class Dog extends Animal {
    private int barkingLoudness;

    public Dog(String nickname, int barkingLoudness) {
        this.setNickname(nickname);
        this.barkingLoudness = barkingLoudness;
    }

    @Override
    public void voice() {
        System.out.println("Dog " + getNickname() + " is barking with loudness " + getBarkingLoudness());
    }

    public int getBarkingLoudness() {
        return barkingLoudness;
    }

    public void setBarkingLoudness(int barkingLoudness) {
        this.barkingLoudness = barkingLoudness;
    }

    public void displayStatus() {
        System.out.println("Dog " + getNickname());
    }

}
