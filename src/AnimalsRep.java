import java.io.*;
import java.util.*;


public class AnimalsRep {
    private static Map<String, String> petsRep = new HashMap<>();
    static File file = new File("petsRep.txt");

    public static void printAllAnimals() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printAllHomePets() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Домашние животные")) {
                    System.out.println(line);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printAllPackAnimals() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Вьючные животные")) {
                    System.out.println(line);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printAllCats() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Кошка")) {
                    System.out.println(line);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printAllDogs() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Собака")) {
                    System.out.println(line);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printAllHorses() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Лошадь")) {
                    System.out.println(line);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printAllDonkeys() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Осёл")) {
                    System.out.println(line);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printAllCamels() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Верблюд")) {
                    System.out.println(line);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printAllHamsters() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Хомяк")) {
                    System.out.println(line);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void addAnimals(String name, String birthdayDate, ArrayList<String> commands, String genus, String type, int age) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

            writer.write(name + "  ");
            writer.write(birthdayDate);
            for (int i = 0; i < commands.size(); i++) {
                writer.write(" " + commands.get(i) + "  ");
                if (i != commands.size() - 1) {
                    writer.write(" ");
                }
            }
            writer.write(genus + "  ");
            writer.write(type + "  ");
            writer.write(age + " лет\n");


        } catch (IOException e) {
            System.out.println("Возникла ошибка во время записи, проверьте данные.");
            throw e;
        }
    }

    public static void deleteAnimals(String name) throws IOException {
        File tempFile = new File(file.getAbsolutePath() + ".tmp");
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains(name)) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        if (!file.delete()) {
            throw new IOException("Не удалось удалить файл");
        }
        if (!tempFile.renameTo(file)) {
            throw new IOException("Не удалось переименовать файл");
        }
    }


}


