public class Main {
    public static void main(String[] args) {
        Human human = new Human("John Doe");
        Citizen citizen = new Citizen("Jane Smith", "American");
        Student student = new Student("Emily Johnson", "Canadian", "Harvard University");
        Employee employee = new Employee("Michael Brown", "British", "Google");

        Human[] people = { human, citizen, student, employee };

        for (Human person : people) {
            System.out.println(person);
        }
    }
}