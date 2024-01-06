import java.util.ArrayList;

public class HomePets extends Animals{
    public HomePets(String name, String birthdayDate, ArrayList<String> commands, String genus) {
        super( name, birthdayDate, commands, genus);
    }
    public static String getType() {
        return "Домашние животные";
    }
}

class Cats extends HomePets{

    public Cats(String name, String birthdayDate, ArrayList<String> commands, String genus) {
        super( name, birthdayDate, commands, genus);
    }

    public static String getType() {
        return "Кошка";
    }
    public int getMaxAge() {
        return 17;
    }




}

class Dogs extends HomePets{

    public Dogs(String name, String birthdayDate, ArrayList<String> commands, String genus) {
        super( name, birthdayDate, commands, genus);
    }

    public static String getType() {
        return "Собака";
    }


    public int getMaxAge() {
        return 16;
    }
}

class Hamsters extends HomePets{

    public Hamsters(String name, String birthdayDate, ArrayList<String> commands, String genus) {
        super( name, birthdayDate, commands, genus);
    }

    public static String getType() {
        return "Хомяк";
    }

    public int getMaxAge() {
        return 4;
    }


}