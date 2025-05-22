import java.io.*;
import java.util.zip.*;
import java.util.Arrays;

public class Main {

    static class Student implements Serializable {
        private String name;
        private int id;
        private double gpa;

        public Student(String name, int id, double gpa) {
            this.name = name;
            this.id = id;
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            return String.format("%s (ID: %d, GPA: %.2f)", name, id, gpa);
        }
    }

    static class AcademicGroup implements Serializable {
        private Student[] students;
        private String groupName;

        public AcademicGroup(String groupName, Student[] students) {
            this.groupName = groupName;
            this.students = students;
        }

        @Override
        public String toString() {
            return String.format("Group: %s\nStudents:\n%s",
                    groupName, Arrays.toString(students));
        }
    }

    private static void saveToZip(AcademicGroup group, String zipFile) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(zipFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            // Создание записи перед ObjectOutputStream
            ZipEntry entry = new ZipEntry("group_data.ser");
            zos.putNextEntry(entry);

            // ВАЖНО: оборачиваем именно ZipOutputStream, но после putNextEntry
            ObjectOutputStream oos = new ObjectOutputStream(zos);
            oos.writeObject(group);
            oos.flush(); // обязательно
            // Не закрываем oos напрямую, он закроет zos — этого нельзя
            zos.closeEntry(); // закрываем entry после записи
        }
    }

    private static AcademicGroup readFromZip(String zipFile) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(zipFile);
             ZipInputStream zis = new ZipInputStream(fis)) {

            ZipEntry entry = zis.getNextEntry();
            if (entry != null && entry.getName().equals("group_data.ser")) {
                ObjectInputStream ois = new ObjectInputStream(zis);
                return (AcademicGroup) ois.readObject();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Alice Johnson", 101, 3.8),
                new Student("Bob Smith", 102, 3.5),
                new Student("Charlie Brown", 103, 3.9)
        };
        AcademicGroup group = new AcademicGroup("CS-101", students);

        try {
            saveToZip(group, "student_data.zip");
            System.out.println("Data successfully saved to ZIP archive!");
        } catch (IOException e) {
            System.err.println("Error saving to ZIP: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        try {
            AcademicGroup loadedGroup = readFromZip("student_data.zip");
            if (loadedGroup != null) {
                System.out.println("\nData successfully loaded from ZIP:");
                System.out.println(loadedGroup);
            } else {
                System.out.println("No valid data found in the archive.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading from ZIP: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
