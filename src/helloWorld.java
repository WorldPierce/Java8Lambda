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
    }
}
