import java.util.*;

class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}

class Employee {
    String name;
    int age;
    double salary;

    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " (" + age + ", " + salary + ")";
    }
}

class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        // 1. Salary descending
        int salaryCompare = Double.compare(e2.salary, e1.salary);
        if (salaryCompare != 0) {
            return salaryCompare;
        }
        // 2. Age ascending
        int ageCompare = Integer.compare(e1.age, e2.age);
        if (ageCompare != 0) {
            return ageCompare;
        }
        // 3. Name alphabetical (ascending)
        return e1.name.compareTo(e2.name);
    }
}

class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, 50000),
            new Employee("Bob", 25, 60000),
            new Employee("Charlie", 35, 50000),
            new Employee("David", 28, 60000),
            new Employee("Eve", 32, 55000)
        );

        Collections.sort(employees, new EmployeeComparator());

        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
