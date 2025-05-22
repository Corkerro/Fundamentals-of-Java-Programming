import java.util.Comparator;

public class SumOfDigitsComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        int sumA = String.valueOf(a).chars().map(Character::getNumericValue).sum();
        int sumB = String.valueOf(b).chars().map(Character::getNumericValue).sum();
        return Integer.compare(sumA, sumB);
    }
}