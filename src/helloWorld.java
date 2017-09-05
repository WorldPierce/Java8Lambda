import java.util.stream.IntStream;

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
    }

    private static boolean isPrime(int i) {
        return i > 1 &&
                IntStream.range(2,i)
                .noneMatch(index -> i % index == 0);
    }
}
