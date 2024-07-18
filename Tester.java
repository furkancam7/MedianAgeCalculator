
public class Tester {
    public static void main(String[] args) {
        MedianAgeCalculator calculator = new MedianAgeCalculator();

        // Test case 1: Adding ages and checking median
        calculator.addAge(10);
        System.out.println("The recommended content will be for ages under: " + calculator.getMedian());

        calculator.addAge(20);
        System.out.println("The recommended content will be for ages under: " + calculator.getMedian());

        calculator.addAge(30);
        System.out.println("The recommended content will be for ages under: " + calculator.getMedian());

        calculator.addAge(40);
        System.out.println("The recommended content will be for ages under: " + calculator.getMedian());

        calculator.addAge(50);
        System.out.println("The recommended content will be for ages under: " + calculator.getMedian());

        // Test case 2: Adding ages in descending order
        calculator = new MedianAgeCalculator();
        calculator.addAge(50);
        System.out.println("The recommended content will be for ages under: " + calculator.getMedian());

        calculator.addAge(40);
        System.out.println("The recommended content will be for ages under: " + calculator.getMedian());

        calculator.addAge(30);
        System.out.println("The recommended content will be for ages under: " + calculator.getMedian());

        calculator.addAge(20);
        System.out.println("The recommended content will be for ages under: " + calculator.getMedian());

        calculator.addAge(10);
        System.out.println("The recommended content will be for ages under: " + calculator.getMedian());

        // Test case 3: Adding ages in random order
        calculator = new MedianAgeCalculator();
        calculator.addAge(25);
        System.out.println("The recommended content will be for ages under: " + calculator.getMedian());

        calculator.addAge(5);
        System.out.println("The recommended content will be for ages under: " + calculator.getMedian());

        calculator.addAge(15);
        System.out.println("The recommended content will be for ages under: " + calculator.getMedian());

        calculator.addAge(10);
        System.out.println("The recommended content will be for ages under: " + calculator.getMedian());

        calculator.addAge(20);
        System.out.println("The recommended content will be for ages under: " + calculator.getMedian());
    }
}
