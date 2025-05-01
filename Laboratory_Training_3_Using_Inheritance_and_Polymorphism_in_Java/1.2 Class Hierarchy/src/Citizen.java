public class Citizen extends Human {
    private String nationality;

    public Citizen(String name, String nationality) {
        super(name);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return "Citizen [name=" + getName() + ", nationality=" + nationality + "]";
    }
}