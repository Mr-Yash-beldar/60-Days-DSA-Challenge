## Java Interview Topics (Fresher → 2 years)

This file contains topic-wise Java interview questions and answers. Ask for "next" to get the next topic's questions.

### Topic 1 — Core Java: OOP Basics

Summary: Object-Oriented Programming (OOP) in Java — classes, objects, inheritance, polymorphism, encapsulation, and abstraction.

Questions for Topic 1

1. What is a Class and an Object in Java?

- Brief answer: A class is a blueprint for objects. An object is an instance of a class containing state (fields) and behavior (methods).

- Explanation: Classes define the structure and behavior; objects are runtime instances. Fields represent data and methods encapsulate operations. Java uses the new keyword to create objects. Classes can include constructors to initialize state.

- Real-world example: Class = Car (blueprint); Object = your specific car with color, model, and mileage.

- Code snippet:

```java
class Car {
    String model;
    int year;

    Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    void drive() {
        System.out.println(model + " is driving");
    }

    public static void main(String[] args) {
        Car c = new Car("Toyota", 2020);
        c.drive();
    }
}
```

2. What is Inheritance? How is it used in Java?

- Brief answer: Inheritance allows a class (subclass) to acquire fields and methods of another class (superclass), promoting code reuse.

- Explanation: Use the extends keyword. A subclass can override superclass methods and add new ones. Java supports single inheritance for classes but multiple inheritance via interfaces.

- Real-world example: Vehicle superclass; Car and Bike subclasses inherit common properties like speed and fuelType.

- Code snippet:

```java
class Vehicle {
    void start() { System.out.println("Vehicle started"); }
}

class Car extends Vehicle {
    void openTrunk() { System.out.println("Trunk opened"); }

    public static void main(String[] args) {
        Car car = new Car();
        car.start(); // inherited
        car.openTrunk();
    }
}
```

3. What is Polymorphism in Java? (Compile-time vs Run-time)

- Brief answer: Polymorphism lets objects take many forms. Compile-time (method overloading) and run-time (method overriding via dynamic dispatch).

- Explanation: Overloading — multiple methods with same name but different parameters in same class. Overriding — subclass provides specific implementation for a superclass method; calls via superclass reference resolve to subclass at runtime.

- Real-world example: A "print" operation that can accept different data types (overloading) or a generic Animal reference invoking dog-specific bark() (overriding).

- Code snippet:

```java
class Printer {
    void print(String s) { System.out.println(s); }
    void print(int n) { System.out.println(n); } // overloading
}

class Animal { void speak(){ System.out.println("Animal"); } }
class Dog extends Animal { void speak(){ System.out.println("Bark"); } }

public class Demo {
    public static void main(String[] args) {
        Printer p = new Printer();
        p.print("Hello");
        p.print(5);

        Animal a = new Dog();
        a.speak(); // Bark — runtime polymorphism
    }
}
```

4. What is Encapsulation and how do you implement it in Java?

- Brief answer: Encapsulation bundles data and methods and restricts direct access using access modifiers; typically implemented via private fields with public getters/setters.

- Explanation: Encapsulation protects object integrity by controlling how fields are accessed/modified. It also hides internal representation.

- Real-world example: BankAccount with private balance and public deposit/withdraw methods to ensure invariants.

- Code snippet:

```java
class BankAccount {
    private double balance;

    public BankAccount(double initial) { balance = initial; }

    public double getBalance() { return balance; }

    public void deposit(double amt) {
        if (amt > 0) balance += amt;
    }

    public boolean withdraw(double amt) {
        if (amt > 0 && amt <= balance) { balance -= amt; return true; }
        return false;
    }
}
```

5. What is Abstraction in Java? How do abstract classes and interfaces differ?

- Brief answer: Abstraction shows only essential features and hides details. Abstract classes can have state and concrete methods; interfaces (since Java 8+) can have default/static methods but are typically used for contracts.

- Explanation: Use abstract class when you want shared code and state; use interfaces for multiple-type contracts. From Java 8+, interfaces can include default implementations; Java 9 added private methods in interfaces.

- Real-world example: PaymentProcessor interface with methods processPayment(); different implementations like CreditCardProcessor or PayPalProcessor.

- Code snippet:

```java
interface PaymentProcessor { void process(double amt); }

class PayPalProcessor implements PaymentProcessor {
    public void process(double amt) { System.out.println("Processing via PayPal: " + amt); }
}

abstract class Shape { abstract double area(); }
class Circle extends Shape { double r; Circle(double r){this.r=r;} double area(){return Math.PI*r*r;} }
```

---

Ask for "next" to receive the next topic's questions and answers.

### Topic 2 — Core Java: JVM, Memory, and Garbage Collection

Summary: JVM architecture, class loading, memory areas (heap, stack, metaspace), references, and garbage collection basics.

Questions for Topic 2

1. What is the JVM? How is it different from JRE and JDK?

- Brief answer: JVM runs Java bytecode; JRE = JVM + standard libraries for running apps; JDK = JRE + development tools (compiler, etc.).

- Explanation: Source (.java) → compiled by javac to bytecode (.class) → executed by JVM. JRE is runtime environment; JDK includes javac, javadoc, etc.

- Real-world example: Think of JVM as the engine, JRE as the car (engine + essentials to drive), and JDK as the garage toolkit.

- Code snippet:

```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello JVM");
    }
}
// Compiled by JDK's javac; executed by JVM within the JRE
```

2. Explain JVM memory areas: Heap vs Stack vs Metaspace.

- Brief answer: Stack stores method frames (local vars, references). Heap stores objects. Metaspace stores class metadata (replaced PermGen since Java 8).

- Explanation: Each thread has a stack; the heap is shared across threads. Metaspace grows up to OS limits by default (configurable). Efficient memory use requires avoiding unnecessary object creation and watching stack recursion depth.

- Real-world example: When you call a method, parameters go on the stack; when you create new ArrayList(), the object is on the heap; class info for ArrayList lives in Metaspace.

- Code snippet:

```java
class MemoryDemo {
    static class Node { int v; Node next; Node(int v){this.v=v;} }

    static int sum(int n) { // stack frames
        if (n == 0) return 0;
        return n + sum(n-1);
    }

    public static void main(String[] args) {
        Node head = new Node(1); // heap
        head.next = new Node(2);
        System.out.println(sum(3));
    }
}
```

3. How does Java Garbage Collection (GC) work in simple terms?

- Brief answer: GC automatically frees heap memory by removing objects that are no longer reachable from live references (GC roots).

- Explanation: GC uses reachability analysis; algorithms include mark-sweep-compact and generational collection (young/old). Modern collectors: G1, ZGC, Shenandoah (choose per needs like pause times vs throughput).

- Real-world example: Unused shopping carts in an e-commerce site session get cleaned up when the session ends.

- Code snippet:

```java
public class GCDemo {
    public static void main(String[] args) {
        byte[] temp = new byte[10_000_000]; // allocate on heap
        temp = null; // eligible for GC once unreachable
        System.gc(); // hint (not guaranteed)
    }
}
```

4. What are Strong, Soft, Weak, and Phantom references?

- Brief answer: Strong references prevent GC; Soft references are cleared before OutOfMemoryError (good for caches); Weak references are cleared eagerly (good for maps of listeners); Phantom references track post-finalization cleanup.

- Explanation: Found in java.lang.ref. Choice impacts GC behavior and memory-sensitive caches.

- Real-world example: Image cache uses SoftReference so images can be reclaimed under memory pressure.

- Code snippet:

```java
import java.lang.ref.*;

class RefDemo {
    public static void main(String[] args) {
        Object strong = new Object();
        SoftReference<Object> soft = new SoftReference<>(new Object());
        WeakReference<Object> weak = new WeakReference<>(new Object());
        PhantomReference<Object> phantom = new PhantomReference<>(new Object(), new ReferenceQueue<>());
        System.out.println(strong != null && soft.get() != null && weak.get() != null);
    }
}
```

5. What is a Memory Leak in Java if GC exists?

- Brief answer: Holding references to unused objects (e.g., static collections, caches, listeners) prevents GC from reclaiming memory.

- Explanation: Leaks occur when objects remain reachable unintentionally. Common causes: not removing listeners, large collections that grow without bounds, ThreadLocal misuse.

- Real-world example: Storing every HTTP request in a static List for debugging and never clearing it.

- Code snippet (bad vs good):

```java
// Bad: static cache grows forever
class Cache {
    private static final java.util.Map<String, byte[]> MAP = new java.util.HashMap<>();
    static void put(String k, byte[] v){ MAP.put(k, v); }
}

// Better: use size limits or WeakHashMap when keys should not prevent GC
class BetterCache {
    private static final java.util.Map<Object, Object> MAP = new java.util.WeakHashMap<>();
}
```

6. How can you analyze memory issues in Java?

- Brief answer: Use tools like jcmd, jmap, jstat, jvisualvm, Java Flight Recorder (JFR), and heap dumps analyzed with Eclipse MAT.

- Explanation: Capture a heap dump on OutOfMemoryError or on demand; analyze dominator trees to find largest retainers; profile allocations and GC pauses.

- Real-world example: Production service with rising heap—take JFR recording and heap dump to find a map accumulating stale sessions.

- Code snippet (triggering a heap dump via flag):

```java
// Run with:
// -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=heap.hprof
public class OOM {
    public static void main(String[] args) {
        java.util.List<byte[]> list = new java.util.ArrayList<>();
        while (true) list.add(new byte[1_000_000]);
    }
}
```

7. What is ClassLoader and the class loading process?

- Brief answer: ClassLoaders load classes into the JVM. The process follows parent delegation: bootstrap → platform → application classloader.

- Explanation: Parent-first strategy avoids duplicate loading of core classes; custom classloaders enable plugin systems and sandboxing.

- Real-world example: Application servers use custom classloaders to isolate deployed applications.

- Code snippet (custom classloader skeleton):

```java
class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // load bytes from custom source, then:
        // byte[] b = ...;
        // return defineClass(name, b, 0, b.length);
        throw new ClassNotFoundException(name);
    }
}
```

### Topic 3 — Java Collections Framework

Summary: Core interfaces and implementations; Lists, Sets, Maps, Queue/Deque; common operations, complexity, and iteration.

Questions for Topic 3

1. What are the main Collection interfaces and how do they relate?

- Brief answer: Root is Collection (List, Set, Queue extend it) and Map is separate. Implementations include ArrayList, LinkedList, HashSet, TreeSet, HashMap, TreeMap, etc.

- Explanation: Collection hierarchy defines common behaviors. List is ordered and allows duplicates; Set disallows duplicates; Queue/Deque support FIFO/LIFO operations. Map stores key-value pairs and isn’t a Collection.

- Real-world example: Shopping cart items (List), unique user IDs (Set), productId→price lookup (Map).

- Code snippet:

```java
import java.util.*;

class CollectionsOverview {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        list.add("A"); list.add("A");
        set.add("A"); set.add("A");
        map.put("A", 1);
        System.out.println(list.size()); // 2
        System.out.println(set.size()); // 1
        System.out.println(map.get("A")); // 1
    }
}
```

2. Compare ArrayList vs LinkedList.

- Brief answer: ArrayList has O(1) random access, amortized O(1) append, but O(n) insert/delete in middle. LinkedList has O(1) insert/delete at ends (with iterator) but O(n) access.

- Explanation: ArrayList is backed by dynamic array; LinkedList is doubly linked. For most cases, ArrayList is preferred due to cache locality and overall performance.

- Real-world example: Activity feed (append-heavy) suits ArrayList; a queue where you frequently add/remove at ends can use LinkedList or ArrayDeque.

- Code snippet:

```java
List<Integer> a = new ArrayList<>();
List<Integer> l = new LinkedList<>();
for (int i = 0; i < 3; i++) a.add(i);
l.add(1); l.add(2); l.add(3);
System.out.println(a.get(2)); // O(1)
// In LinkedList, a.get(2) is O(n)
```

3. HashSet vs TreeSet vs LinkedHashSet — differences?

- Brief answer: HashSet is unordered, O(1) average ops; LinkedHashSet maintains insertion order; TreeSet is sorted (O(log n) ops) using natural order or Comparator.

- Explanation: Use HashSet for fast membership, LinkedHashSet when you need stable iteration order, TreeSet for sorted sets and range queries.

- Real-world example: Unique tags (HashSet); preserving order of unique recent pages (LinkedHashSet); leaderboard of unique scores (TreeSet).

- Code snippet:

```java
Set<Integer> hs = new HashSet<>();
Set<Integer> lhs = new LinkedHashSet<>();
Set<Integer> ts = new TreeSet<>();
for (int v : new int[]{3,1,2}) { hs.add(v); lhs.add(v); ts.add(v); }
System.out.println(hs);  // order arbitrary
System.out.println(lhs); // [3, 1, 2]
System.out.println(ts);  // [1, 2, 3]
```

4. How do HashMap and TreeMap differ? What about LinkedHashMap?

- Brief answer: HashMap provides O(1) average get/put; TreeMap is sorted with O(log n) get/put; LinkedHashMap preserves insertion or access order and enables LRU-like caches.

- Explanation: HashMap uses hash buckets; TreeMap is a Red-Black tree; LinkedHashMap maintains a doubly-linked list for order.

- Real-world example: Fast id→object map (HashMap); sorted navigation by keys (TreeMap); LRU cache (LinkedHashMap with access-order).

- Code snippet (LRU-style):

```java
import java.util.*;

class LruCache<K,V> extends LinkedHashMap<K,V> {
    private final int cap;
    LruCache(int cap){ super(16, 0.75f, true); this.cap = cap; }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){ return size() > cap; }
}
```

5. What is the difference between fail-fast and fail-safe iterators?

- Brief answer: Fail-fast iterators (e.g., ArrayList, HashMap) throw ConcurrentModificationException on structural modification; fail-safe work on a snapshot (e.g., CopyOnWriteArrayList, ConcurrentHashMap) and don’t throw.

- Explanation: Fail-fast relies on modCount checks; fail-safe uses copy-on-write or weakly consistent views.

- Real-world example: Iterating a shared list while other threads modify it—use CopyOnWriteArrayList for read-heavy, infrequent writes.

- Code snippet:

```java
import java.util.*;

List<Integer> list = new ArrayList<>(List.of(1,2,3));
for (int x : list) {
    // list.add(4); // would throw ConcurrentModificationException
}

java.util.concurrent.CopyOnWriteArrayList<Integer> cow = new java.util.concurrent.CopyOnWriteArrayList<>(list);
for (int x : cow) {
    cow.add(4); // safe, iterates over snapshot
}
```

6. When do you use ArrayDeque, and why not Stack/LinkedList for stack/queue?

- Brief answer: ArrayDeque is a resizable, lock-free deque ideal for stack and queue operations; Stack is synchronized (legacy) and LinkedList has more overhead.

- Explanation: ArrayDeque offers O(1) amortized add/remove at both ends and better cache locality. Prefer ArrayDeque for single-threaded stacks/queues.

- Real-world example: Browser back/forward stack can use ArrayDeque.

- Code snippet:

```java
import java.util.ArrayDeque;

ArrayDeque<String> stack = new ArrayDeque<>();
stack.push("A"); stack.push("B");
System.out.println(stack.pop()); // B

ArrayDeque<String> queue = new ArrayDeque<>();
queue.add("A"); queue.add("B");
System.out.println(queue.remove()); // A
```

7. How do you choose the right collection?

- Brief answer: Base it on requirements: ordering, sorting, duplicates, random access, memory footprint, concurrency, and expected complexities.

- Explanation: List for ordered duplicates; Set for uniqueness; Map for key-value; ArrayList for random access; LinkedHashMap for LRU; TreeSet/TreeMap for sorted views; ArrayDeque for stacks/queues.

- Real-world example: Caching last 100 API results by key → LinkedHashMap access-order with capacity 100.

- Code snippet (selection helper idea):

```java
// Pseudocode-ish selection guide
// if need order + duplicates -> List (ArrayList)
// if need uniqueness, unordered -> HashSet
// if need sorted set/map -> TreeSet/TreeMap
// if need LRU cache -> LinkedHashMap(accessOrder=true)
// if need stack/queue -> ArrayDeque
```
