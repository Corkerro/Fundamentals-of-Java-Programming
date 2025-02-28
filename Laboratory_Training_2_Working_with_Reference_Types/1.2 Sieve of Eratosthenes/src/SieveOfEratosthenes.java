public class SieveOfEratosthenes {
    private static int to;
    int[] array;

    public SieveOfEratosthenes(int to) {
        SieveOfEratosthenes.to = to;
        array = new int[to];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        array[0] = -1;
    }

    public void process() {
        for (int i = 1; i < array.length; i++) {
            if (array[i] > 0) {
                int prime = array[i];
                int index = i + prime;

                while (index < array.length) {
                    array[index] = -1;
                    index += prime;
                }
            }
        }
    }

    public void printArray() {
        for (int num : array) {
            if (num > 0) {
                System.out.print(num + " ");
            }
        }
        System.out.print('\n');
    }

}
