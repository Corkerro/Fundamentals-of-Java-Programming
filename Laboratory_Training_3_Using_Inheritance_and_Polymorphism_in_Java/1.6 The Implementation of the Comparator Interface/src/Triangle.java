class Triangle {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("Invalid triangle sides.");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Heron's formula
    public double getArea() {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c && a + c > b && b + c > a);
    }

    @Override
    public String toString() {
        return String.format("Triangle(a=%.2f, b=%.2f, c=%.2f, area=%.2f)", a, b, c, getArea());
    }
}