import java.awt.image.SampleModel;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class helloWorld {



    public static void main(String[] args) {
        Test myTest = new Test();
        System.out.println(myTest.name());
        myTest.fullName();

        Lambda pprint = () -> System.out.println("WORDS");

        //more lambda
        Runner runner = new Runner();
        //Java 6 or Java 7
        runner.run(new Executable() {
            @Override
            public void execute() {
                System.out.println("ExecutAYEded!");
            }
        });
        //Java 8
        runner.run(() -> System.out.println("Lambda Executed!"));

        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));

        List<Integer> values = Arrays.asList(1,2,3,5,4,5,6,7,8,9);
        int result = 0;
        for(int e : values) {
            if(e > 3 && e % 2 == 0) {
                result = e * 2;
                break;
            }
        }
        System.out.println(result);
        //stream is interpreter

        System.out.println(
        values.stream()
                .filter(e -> e > 3)
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .findFirst()
                .get()
        );
        //one step further
        //use class for variable
        //Higher order functions - passing a function to a function
        System.out.println(
                values.stream()
                        .filter(helloWorld::isGreaterThan3)
                        .filter(helloWorld::isEven)
                        .map(helloWorld::doubleValue)
                        .findFirst()
                        .get()
        );
        //this does nothing until we call temp.findFirst()
        //if we don't have .get() it will return optional
        Stream<Integer> temp = values.stream()
                .filter(helloWorld::isGreaterThan3)
                .filter(helloWorld::isEven)
                .map(helloWorld::doubleValue);
        System.out.println(temp.findFirst());
    }

    public static boolean isGreaterThan3(int number) {
        return number > 3;
    }
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    public static int doubleValue(int number) {
        return number * 2;
    }


    private static boolean isPrime(int i) {
        Predicate<Integer> isDivisible = divisor -> i % divisor == 0;
        return i > 1 &&
                IntStream.range(2,i)
                .noneMatch(index -> isDivisible.test(index));
    }
}
