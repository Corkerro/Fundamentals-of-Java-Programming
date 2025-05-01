public class Employee extends Citizen {
    private String company;

    public Employee(String name, String nationality, String company) {
        super(name, nationality);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Employee [name=" + getName() + ", nationality=" + getNationality() + ", company=" + company + "]";
    }
}