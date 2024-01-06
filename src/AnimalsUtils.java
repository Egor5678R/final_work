import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class AnimalsUtils {
    public static void menu() throws IOException {
        System.out.println("Выберете:\n" +
                "1. Вывести всех животных\n" +
                "2. Вывести только домашних питомцев\n" +
                "3. Вывести только вьючных животных\n" +
                "4. Вывести только собак\n" +
                "5. Вывести только кошек\n" +
                "6. Вывести только хомяков\n" +
                "7. Вывести только лошадей\n" +
                "8. Вывести только ослов\n" +
                "9. Вывести только верблюдов\n" +
                "10. Добавить новое животное\n" +
                "11. Удалить животное\n");
        Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();
        switch (menu) {
            case 1:
                AnimalsRep.printAllAnimals();
                menu();
                break;
            case 2:
                AnimalsRep.printAllHomePets();
                menu();
                break;
            case 3:
                AnimalsRep.printAllPackAnimals();
                menu();
                break;
            case 4:
                AnimalsRep.printAllDogs();
                menu();
                break;
            case 5:
                AnimalsRep.printAllCats();
                menu();
                break;
            case 6:
                AnimalsRep.printAllHamsters();
                menu();
                break;
            case 7:
                AnimalsRep.printAllHorses();
                menu();
                break;
            case 8:
                AnimalsRep.printAllDonkeys();
                menu();
                break;
            case 9:
                AnimalsRep.printAllCamels();
                menu();
                break;


            case 10:

                System.out.println("Введите имя животного:");
                String name = scanner.next();
                System.out.println("Введите дату рождения (день.месяц.год):");
                String birthdayDateString = scanner.next();
                calculateAge(birthdayDateString);

                ArrayList<String> commands = new ArrayList<>();
                System.out.println("Введите команды, которые знает это животное:");
                while (true) {
                    String command = scanner.nextLine();
                    if (command.equalsIgnoreCase("стоп")) {
                        break;
                    }
                    commands.add(command);
                }
                System.out.println("Введите род животного:\n" +
                        "1. Кошка\n" +
                        "2. Собака\n" +
                        "3. Хомяк\n" +
                        "4. Лошадь\n" +
                        "5. Осёл\n" +
                        "6. Верблюд\n");
                int typeForAdd = scanner.nextInt();
                try {
                    Counter counter = new Counter();
                    String genusForHomePets = HomePets.getType();
                    String genusForPackAnimals = PackAnimals.getType();
                    int age = calculateAge(birthdayDateString);
                    switch (typeForAdd) {
                        case 1:
                            String typeForCats = Cats.getType();
                            Cats cat = new Cats(name, birthdayDateString, commands, genusForHomePets);
                            AnimalsRep.addAnimals(name, birthdayDateString, Cats.getCommands(), genusForHomePets, typeForCats, age);
                            break;


                        case 2:
                            String typeForDogs = Dogs.getType();
                            Dogs dog = new Dogs(name, birthdayDateString, commands, genusForHomePets);
                            AnimalsRep.addAnimals(name, birthdayDateString, Dogs.getCommands(), genusForHomePets, typeForDogs, age);
                            break;
                        case 3:
                            String typeForHamsters = Hamsters.getType();
                            Hamsters hamster = new Hamsters(name, birthdayDateString, commands, genusForHomePets);
                            AnimalsRep.addAnimals(name, birthdayDateString, Hamsters.getCommands(), genusForHomePets, typeForHamsters, age);
                            break;
                        case 4:
                            String typeForHorses = Horses.getType();
                            Horses horse = new Horses(name, birthdayDateString, commands, genusForPackAnimals);
                            AnimalsRep.addAnimals(name, birthdayDateString, Horses.getCommands(), genusForPackAnimals, typeForHorses, age);
                            break;
                        case 5:
                            String typeForDonkeys = Donkeys.getType();
                            Donkeys donkey = new Donkeys(name, birthdayDateString, commands, genusForPackAnimals);
                            AnimalsRep.addAnimals(name, birthdayDateString, Donkeys.getCommands(), genusForPackAnimals, typeForDonkeys, age);
                            break;
                        case 6:
                            String typeForCamels = Camels.getType();
                            Camels camel = new Camels(name, birthdayDateString, commands, genusForPackAnimals);
                            AnimalsRep.addAnimals(name, birthdayDateString, Camels.getCommands(), genusForPackAnimals, typeForCamels, age);
                            break;
                        default:
                            menu();
                            break;
                    }
                    menu();
                    break;
                } finally {
                }
            case 11:
                System.out.println("Введите имя животного, которого хотите удалить:");

                String name2 = scanner.next();
                AnimalsRep.deleteAnimals(name2);
                try {
                    Thread.sleep(10000);
                    menu();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Выбрано неправильное действие, повторите");
                break;
        }
    }

    private static int calculateAge(String input) {
        boolean isValidDate = true;
        int age = 0;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
            LocalDate birthdaydate = LocalDate.parse(input, formatter);

            if (birthdaydate.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Введенная дата больше текущей даты.");
            }

            Period period = Period.between(birthdaydate, LocalDate.now());
            age = period.getYears();

            isValidDate = true;

        } catch (DateTimeParseException e) {
            System.out.println("Неправильный формат даты. Попробуйте еще раз.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Попробуйте еще раз.");
        }

        return age;
    }
}