/*
    Read string from command line and then add spaces until string length will be equal to a given value.
    Spaces must be even added at the beginning and at the end of string. The spaces should be added evenly
    between words (if possible).
 */

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Main “text” length");
            return;
        }

        String text = args[0];
        int targetLength;

        try {
            targetLength = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("The second argument must be a number");
            return;
        }

        String justifiedText = justify(text, targetLength);
        System.out.println(justifiedText);
    }

    private static String justify(String text, int targetLength) {
        text = text.trim();
        String[] words = text.split("\\s+");

        if (words.length == 1) {
            return String.format("%-" + targetLength + "s", text);
        }

        int totalSpaces = targetLength - text.replace(" ", "").length();
        int gaps = words.length - 1;
        int spacesPerGap = totalSpaces / gaps;
        int extraSpaces = totalSpaces % gaps;

        StringBuilder justifiedText = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            justifiedText.append(words[i]);
            int spacesToAdd = spacesPerGap + (i < extraSpaces ? 1 : 0);
            justifiedText.append(" ".repeat(spacesToAdd));
        }
        justifiedText.append(words[words.length - 1]);

        return justifiedText.toString();
    }
}