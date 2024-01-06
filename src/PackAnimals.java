import java.util.ArrayList;

public class PackAnimals extends Animals{
    public PackAnimals(String name, String birthdayDate, ArrayList<String> commands, String genus) {
        super(name, birthdayDate, commands, genus);
    }

    public static String getType() {
        return "Вьючные животные";
    }




}

class Horses extends HomePets{

    public Horses(String name, String birthdayDate, ArrayList<String> commands, String genus) {
        super( name, birthdayDate, commands, genus);
    }

    public static String getType() {
        return "Лошадь";
    }
    public int getMaxAge() {
        return 30;
    }

}

class Donkeys extends HomePets{

    public Donkeys(String name, String birthdayDate, ArrayList<String> commands, String genus) {
        super( name, birthdayDate, commands, genus);
    }

    public static String getType() {
        return "Осёл";
    }

    public int getMaxAge() {
        return 40;
    }


}

class Camels extends HomePets{

    public Camels(String name, String birthdayDate, ArrayList<String> commands, String genus) {
        super( name, birthdayDate, commands, genus);
    }

    public static String getType() {
        return "Верблюд";
    }
    public int getMaxAge() {
        return 40;
    }


}