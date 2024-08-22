enum Department {
    SALES,
    IT,
    MARKETING,
    HR,
    FINANCE
}

public class Employee {
    String name;
    int age;
    Department department;
    double salary;

    Employee(String name, int age, Department department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
