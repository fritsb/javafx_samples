package streeksoft;

public abstract class Person implements iPerson {
    protected String firstName;
    protected String lastName;

    public abstract String getName();
    public abstract void setAge(int age);

    public void justARandomMethod() {
        System.out.println("This method only prints one line to console");
    }
}
