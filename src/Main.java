import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

//        Thread th = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("A thread!");
//            }
//        });

        Thread th = new Thread(() -> System.out.println("A thread!"));
        th.start();

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //external iterator (using sequential iteration)
//        for(int e : numbers) {
//            System.out.println(e);
//        }

        //internal iterator (benefits from polymorphism
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        //lambda of previous example
        numbers.forEach((Integer value) -> System.out.println(value));
        //Do not need Integer, the type is inferred with lambda, only need to omit () when its 1 arg
        numbers.forEach(value -> System.out.println(value));

        //replace lambda with METHOD REFERNCE - only used for passing an argument through
        //calling print on the System.outE object
        numbers.forEach(System.out::print);

        numbers.stream()
                //.map(e -> String.valueOf(e))
                //equivalent to
                .map(String::valueOf)
                .forEach(System.out::println);

//        numbers.stream()
//                .map(e -> String.valueOf(e))
//                //.map(e -> e.toString())
//                .map(String::toString)
//                .forEach(System.out::println);
        System.out.println(
                numbers.stream()
                        //order recived must be the same as order used
                        //.reduce(0, (total, e) -> Integer.sum(total , e))
                        //equivalent too
                        .reduce(0, Integer::sum)

        );

        System.out.println(
                numbers.stream()
                        .map(String::valueOf)
                        //.reduce("", (carry, str) -> carry.concat(str))
                        .reduce("", String::concat)
        );
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //given the values, double the even numbers and total.
        int result = 0;
        for(int e : numbers) {
            if(e % 2 == 0) {
                result += e * 2;
            }
        }
        System.out.println(result + "main");

        numbers.stream()
                .filter(Main::isEven)
                //.map(Main::doubleValue)
                //.reduce(0, Integer::sum);
                .mapToInt(Main::doubleValue)
                .sum();
    }

    private static int doubleValue(Integer integer) {
        return integer * 2;
    }

    public static boolean isEven(int e) {
        return e % 2 == 0;
    }





}
