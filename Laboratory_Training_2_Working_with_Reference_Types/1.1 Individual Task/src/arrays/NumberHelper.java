package arrays;
import java.util.Random;

/**
 * Helper class that generates random numbers based on the specified settings.
 */
public class NumberHelper {
    private static final Random random = new Random();

    /**
     * Generates a random odd number within the specified range.
     *
     * @param settings The settings that define the range for the number generation.
     * @return A random odd number within the specified range.
     */
    private static int generateOddNumber(Settings settings) {
        int range = (settings.getTo() - settings.getFrom() + 1) / 2;
        int odd = random.nextInt(range) * 2 + 1;
        return odd + settings.getFrom();
    }

    /**
     * Generates a random even number within the specified range.
     *
     * @param settings The settings that define the range for the number generation.
     * @return A random even number within the specified range.
     */
    private static int generateEvenNumber(Settings settings) {
        int range = (settings.getTo() - settings.getFrom() + 1) / 2;
        int even = random.nextInt(range) * 2;
        return even + settings.getFrom();
    }

    /**
     * Generates a random number within the specified range, without restrictions on parity.
     *
     * @param settings The settings that define the range for the number generation.
     * @return A random number within the specified range.
     */
    private static int generateAnyNumber(Settings settings) {
        return random.nextInt(settings.getTo() - settings.getFrom()) + settings.getFrom();
    }

    /**
     * Generates a random number based on the specified settings for parity (odd/even/any).
     *
     * @param settings The settings that control the type of number (even, odd, or any).
     * @return A random number generated according to the settings.
     */
    public static int generateNumber(Settings settings) {
        return switch (settings.getRandomSetting()) {
            case RANDOM_EVEN -> generateEvenNumber(settings);
            case RANDOM_ODD -> generateOddNumber(settings);
            case RANDOM_POSITIVE -> generateAnyNumber(settings);
            default -> throw new IllegalArgumentException("Unsupported RandomSettings");
        };
    }
}
