import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        //Supplier lambdas
        //Supplier to get a random number from 1 to 10
        Supplier<Integer> sup1 = () -> {
            return (int) (Math.random() * 10) + 1;
        };
        //Supplier to get a "Hello World"
        Supplier<String> sup2 = () -> "Hello World!";
        //Supplier to get a new Employee with a set name and age but a random salary
        Supplier<Employee> sup3 = () -> new Employee("Duilio", 22, (double) ((int) (Math.random() * 9999) + 1));
        //Supplier to get an int[] with three random values
        Supplier<int[]> sup4 = () -> new int[]{(int) (Math.random() * 10) + 1, (int) (Math.random() * 10) + 1, (int) (Math.random() * 10) + 1};
        //Supplier to get a new String Builder with "Hello" as its value
        Supplier<StringBuilder> sup5 = () -> new StringBuilder("Hello");

        //Consumer lambdas
        //Consumer that prints the Integer x multiplied by 10
        Consumer<Integer> con1 = x -> System.out.println(x * 10);
        //Consumer that prints the variable with its class name
        Consumer<Object> con2 = x -> System.out.println("You give the variable: " + x + " of the class " + x.getClass().getSimpleName());
        //Consumer that appends a copyright mark at the end of your StringBuilder
        Consumer<StringBuilder> con3 = y -> y.append("\n*copyright mark*");
        //Consumer that increases the salary of an Employee by 200.00
        Consumer<Employee> con4 = x -> x.setSalary(x.getSalary() + 200.00);
        //Consumer that increases the age of an Employee by 1 simulating the pass of time of a year
        Consumer<Employee> con5 = x -> x.setAge(x.getAge() + 1);

        //BiConsumer lambdas
        //BiConsumer that prints two String together
        BiConsumer<String, String> biCon1 = (x, y) -> System.out.println(x + y);
        //BiConsumer that increases the salary of an Employee by a certain value
        BiConsumer<Employee, Double> biCon2 = (x, y) -> x.setSalary(x.getSalary() + y);
        //BiConsumer that prints an interaction between two Employees
        BiConsumer<Employee, Employee> biCon3 = (x, y) -> System.out.println(x.getName() + " says hi to " + y.getName());
        //BiConsumer that prints whether Employee1 wins more, less, or the same than the Employee2
        BiConsumer<Employee, Employee> biCon4 = (x, y) -> System.out.println(x.getName() + " wins " +
                (x.getSalary() == y.getSalary() ? "the same as" :
                        (x.getSalary() > y.getSalary() ?
                                (x.getSalary() - y.getSalary()) + (" more than") :
                                y.getSalary() - x.getSalary() + (" less than")))
                + " " + y.getName());
        //BiConsumer that prints two variables and their respective class names
        BiConsumer<? super Object, ? super Object> biCon5 = (x, y) -> {
            System.out.println(x + " is a " + x.getClass().getSimpleName() + " while " + y + " is a " + y.getClass().getSimpleName());
        };

        //Predicate lambdas
        //Predicate that tells you if an array of Employees has more than 2 values
        Predicate<Employee[]> pred1 = x -> x.length > 2;
        //Predicate that tells you if an array of int is sorted
        Predicate<int[]> pred2 = x -> {
            int[] temp = x.clone();
            Arrays.sort(x);
            return Arrays.equals(x, temp);
        };
        //Predicate that tells you if an Employee wins more than 8000
        Predicate<Employee> pred3 = x -> x.getSalary() > 8000;
        //Predicate that tells you if the object you pass on is an Employee
        Predicate<? super Object> pred4 = x -> x.getClass().getSimpleName().equals("Employee");
        //Predicate that tells you if a String is larger than 10 characters
        Predicate<String> pred5 = x -> x.length() > 10;

        //BiPredicate lambdas
        //BiPredicate that tells you if the two objects you pass on are from the same Class
        BiPredicate<? super Object, ? super Object> biPred1 = (x, y) -> x.getClass().getSimpleName().equals(y.getClass().getSimpleName());
        //BiPredicate that tells you if the two Employees you passed on win the same amount
        BiPredicate<Employee, Employee> biPred2 = (x, y) -> x.getSalary() == y.getSalary();
        //BiPredicate that tells you if String1 contains String2 or String2 contains String1
        BiPredicate<String, String> biPred3 = (x, y) -> x.contains(y) || y.contains(x);
        //BiPredicate that tells you if a String is a certain length
        BiPredicate<String, Integer> biPred4 = (x, y) -> x.length() == y;
        //BiPredicate that tells you if a String starts with a certain Character
        BiPredicate<String, Character> biPred5 = (x, y) -> x.charAt(0) == y;

        //Function lambdas
        //Function that returns the class name it belongs
        Function<? super Object, String> func1 = x -> x.getClass().getSimpleName();
        //Function that returns the Character that belongs to the Integer we pass according to ASCII value
        Function<Integer, Character> func2 = x -> (char)x.intValue();
        //Function that returns the ASCII value of a character
        Function<Character, Integer> func3 = x -> (int)x;
        //Function that returns the average salary of an array of Employees
        Function<Employee[], Double> func4 = (x) -> {
            double result = 0.0;
            for(var d : x) {
                result += d.getSalary();
            }
            return result / x.length;
        };
        //Function that returns if an Employee is below, above or the age of 30
        Function<Employee, Integer> func5 = x -> x.getAge()-30;

        //BiFunction lambdas
        //BiFunction that returns if Employee1 has more than, less than, or equal salary than Employee2
        BiFunction<Employee, Employee, Integer> biFunc1 = (x, y) -> (int) (x.getSalary() - y.getSalary());
        //BiFunction that returns if an Employee wins more than, less than or equal salary to the amount you pass on
        BiFunction<Employee, Double, Integer> biFunc2 = (x, y) -> (int) (x.getSalary() - y);
        //BiFunction that returns a comparison between and Employee's name and a passed String
        BiFunction<Employee, String, Integer> biFunc3 = (x, y) -> x.getName().compareTo(y);
        //BiFunction that returns a comparison between two Employees sorting them first by name, then age and finally by salary
        BiFunction<Employee, Employee, Integer> biFunc4 = (x, y) -> {
            return (x.getName().equals(y.getName())) ?
                    (x.getAge() - y.getAge() == 0 ?
                            (x.getSalary() - y.getSalary() == 0.0 ?
                                    0 : (int) (x.getSalary() - y.getSalary()))
                            : x.getAge() - y.getAge()) : x.getName().compareTo(y.getName());
        };
        //Bifunction that returns an Employee with the name and age you tell them but with a random Salary
        BiFunction<String, Integer, Employee> biFunc5 = (x, y) -> new Employee(x, y, Math.random() * 1000);

        //UnaryOperator lambdas
        //UnaryOperator that returns your value to the power of a random number between 0 and 10
        UnaryOperator<Integer> unOp1 = (x) -> (int)Math.pow(x, (int)(Math.random() * 10));
        //UnaryOperator that returns a double without its decimal value
        UnaryOperator<Double> unOp2 = x -> (double)x.intValue();
        //UnaryOperator that returns an Employee with its age changed to 18 (you can use it if an Employee is below legal age)
        UnaryOperator<Employee> unOp3 = x -> {
            x.setAge(18);
            return x;
        };
        //UnaryOperator that returns an Array of Employees with a very unoptimized way of sorting an Array of Employees without implementing the Comparator interface in the class
        UnaryOperator<Employee[]> unOp4 = x -> {
            Arrays.sort(x, (a, b) -> (int)(a.getSalary() - b.getSalary()));
            List<Employee>temp = new ArrayList<>();
            for (var e : x) {
                temp.add(e);
            }
            return (Employee[])temp.toArray();
        };
        //UnaryOperator that returns an Integer multiplied by a random number between 0 and 10
        UnaryOperator<Integer> unOp5 = x -> x*(int)(Math.random() * 10);

        //BinaryOperator lambdas
        //binaryOperator that returns an Employee with no name, the average age of Employee1 and Employee2, and the average of salay of Employee1 and Employee2
        BinaryOperator<Employee> binOp1 = (x, y) -> {
            Employee temp = new Employee();
            temp.setAge((x.getAge()+y.getAge())/2);
            temp.setSalary(x.getSalary()+y.getSalary());
            return temp;
        };
        //BinaryOperator that returns the average between two integers
        BinaryOperator<Integer> binOp2 = (x, y) -> (x+y)/2;
        //BinaryOperator that returns a String of two Strings glued together with a " " (space) inbetween
        BinaryOperator<String> binOp3 = (x, y) -> x + " " + y;
        //BinaryOperator that returns an Array of ints after adding two Arrays together
        BinaryOperator<int[]> binOp4 = (x, y) -> {
            int[] temp = new int[x.length + y.length];
            for (int i = 0; i < x.length; i++) {
                temp[i] = x[i];
            }
            for (int j = 0; j < y.length; j++) {
                temp[j+x.length] = y[j];
            }
            return temp;
        };
        //BinaryOperator that return an Employee depending on if Employee1 is greater or Equal to Employee2
        BinaryOperator<Employee> binOp5 = (x, y) -> x.getSalary() >= y.getSalary() ? x : y;
    }
}