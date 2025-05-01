public class Student extends Citizen {
    private String university;

    public Student(String name, String nationality, String university) {
        super(name, nationality);
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }

    @Override
    public String toString() {
        return "Student [name=" + getName() + ", nationality=" + getNationality() + ", university=" + university + "]";
    }
}