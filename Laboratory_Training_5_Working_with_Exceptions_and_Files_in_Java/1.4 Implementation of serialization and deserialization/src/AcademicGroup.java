import java.io.Serializable;
import java.util.Arrays;

public class AcademicGroup implements Serializable {
    private String groupName;
    private Student[] students;

    public AcademicGroup(String groupName, Student[] students) {
        this.groupName = groupName;
        this.students = students;
    }

    @Override
    public String toString() {
        return String.format("Group: %s\nStudents:\n%s", groupName, Arrays.toString(students));
    }
}
