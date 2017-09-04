public class Test extends FullName implements LastName {
    private int _x = 7;
    private String _name = "Billy";

    public String name() {
        return this._name;
    }
    //public void testFunc();

    @Override
    public void lastName() {
        System.out.println(" Pierce");
    }

    @Override
    public void fullName() {
        System.out.print(this.firstName);
        this.lastName();
    }

}


interface LastName{
    void lastName();
}
interface Lambda{
    void printer();
}

abstract class FullName {
    String firstName = "Billy";

    public abstract void fullName();
}
interface Executable {
    void execute();
}
class Runner {
    public void run(Executable e) {
        System.out.println("Executing executable");
        e.execute();
    }
}