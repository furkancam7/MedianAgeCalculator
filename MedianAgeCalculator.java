public class MedianAgeCalculator {
    private int[] lowerHalf;
    private int lowerHalfSize;
    private int[] upperHalf;
    private int upperHalfSize;
    private static final int CAPACITY = 1000;
  
    public MedianAgeCalculator() {
        lowerHalf = new int[CAPACITY];
        lowerHalfSize = 0;
        upperHalf = new int[CAPACITY];
        upperHalfSize = 0;
    }
    public void addAge(int age) {
        if (lowerHalfSize == 0 || age <= lowerHalf[0]) {
            lowerHalf[lowerHalfSize] = age;
            floatUp(lowerHalf, lowerHalfSize, true);
            lowerHalfSize++;
        } else {
            upperHalf[upperHalfSize] = age;
            floatUp(upperHalf, upperHalfSize, false);
            upperHalfSize++;
        }
        if (lowerHalfSize > upperHalfSize + 1) {
            int root = lowerHalf[0];
            lowerHalf[0] = lowerHalf[--lowerHalfSize];
            sinkDown(lowerHalf, 0, lowerHalfSize, true);
            upperHalf[upperHalfSize] = root;
            floatUp(upperHalf, upperHalfSize, false);
            upperHalfSize++;
        } else if (upperHalfSize > lowerHalfSize) {
            int root = upperHalf[0];
            upperHalf[0] = upperHalf[--upperHalfSize];
            sinkDown(upperHalf, 0, upperHalfSize, false);
            lowerHalf[lowerHalfSize] = root;
            floatUp(lowerHalf, lowerHalfSize, true);
            lowerHalfSize++;
        }
    }
    public double getMedian() {
        if (lowerHalfSize == upperHalfSize) {
            return (lowerHalf[0] + upperHalf[0]) / 2.0;
        } else {
            return lowerHalf[0];
        }
    }
    private void floatUp(int[] heap, int index, boolean isMaxHeap) {
        while (index > 0 && compareElements(heap[(index - 1) / 2], heap[index], isMaxHeap)) {
            swapElements(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    private void sinkDown(int[] heap, int index, int size, boolean isMaxHeap) {
        while (2 * index + 1 < size) {
            int j = 2 * index + 1;
            if (j + 1 < size && compareElements(heap[j], heap[j + 1], isMaxHeap)) {
                j++;
            }
            if (!compareElements(heap[index], heap[j], isMaxHeap)) {
                break;
            }
            swapElements(heap, index, j);
            index = j;
        }
    }
    private boolean compareElements(int a, int b, boolean isMaxHeap) {
        return isMaxHeap ? a < b : a > b;
    }
    private void swapElements(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public static void main(String[] args) {
        MedianAgeCalculator medianCalculator = new MedianAgeCalculator();
        medianCalculator.addAge(22);
        medianCalculator.addAge(35);
        System.out.println("The recommended content will be for ages under: " + medianCalculator.getMedian());
        medianCalculator.addAge(30);
        System.out.println("The recommended content will be for ages under: " + medianCalculator.getMedian());
        medianCalculator.addAge(25);
        System.out.println("The recommended content will be for ages under: " + medianCalculator.getMedian());
    }
}