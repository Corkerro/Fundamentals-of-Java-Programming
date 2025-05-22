import java.io.*;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Ivan Ivanov", 101, 4.5),
                new Student("Olena Koval", 102, 4.2),
                new Student("Petro Petrenko", 103, 3.9)
        };

        AcademicGroup group = new AcademicGroup("CS-23", students);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("group.dat"))) {
            oos.writeObject(group);
            System.out.println("Object successfully serialized to file group.dat");
        } catch (IOException e) {
            System.err.println("Serialization error: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("group.dat"))) {
            AcademicGroup loadedGroup = (AcademicGroup) ois.readObject();
            System.out.println("\nObject successfully deserialized from file:");
            System.out.println(loadedGroup);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization error: " + e.getMessage());
        }
    }
}
