from collections import OrderedDict

class LRUCache:
    def __init__(self, capacity):
        self.capacity = capacity
        self.cache = OrderedDict()

    def get(self, key):
        if key in self.cache:
            self.cache.move_to_end(key)
            return self.cache[key]
        return -1

    def put(self, key, value):
        if key in self.cache:
            self.cache.move_to_end(key)
        self.cache[key] = value
        if len(self.cache) > self.capacity:
            self.cache.popitem(last=False)

class Employee:
    def __init__(self, name, age, salary):
        self.name = name
        self.age = age
        self.salary = salary

    def __str__(self):
        return f"{self.name} ({self.age}, {self.salary})"

if __name__ == "__main__":
    employees = [
        Employee("Alice", 30, 50000),
        Employee("Bob", 25, 60000),
        Employee("Charlie", 35, 50000),
        Employee("David", 28, 60000),
        Employee("Eve", 32, 55000)
    ]

    # Sort by salary descending, then age ascending, then name ascending
    employees.sort(key=lambda e: (-e.salary, e.age, e.name))

    for e in employees:
        print(e)