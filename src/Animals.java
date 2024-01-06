import java.util.ArrayList;

abstract public class Animals { ;
    private static String name;
    private static String birthdayDate;
    private static ArrayList<String> commands;
    private String genus;

    private int maxAge;


    public Animals(String name, String birthdayDate, ArrayList<String> commands, String genus) {
        this.name = name;
        this.birthdayDate = birthdayDate;
        this.commands = commands;
        this.genus = genus;
    }

    public static String getName() {
        return name;
    }

    public static String getBirthdayDate() {
        return birthdayDate;
    }

    public static ArrayList<String> getCommands() {
        return commands;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }
}

