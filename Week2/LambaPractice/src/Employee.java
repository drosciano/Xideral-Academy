public class Employee {
    private String name;
    private int age;
    private double salary;

    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    Employee() {

    }

    String getName() {
        return this.name;
    }
    void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return this.age;
    }
    void setAge(int age) {
        this.age = age;
    }

    double getSalary() {
        return this.salary;
    }
    void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + ": " + age + " years old. Salary: " + salary;
    }
}
