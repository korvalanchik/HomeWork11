import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streaming {
    List<nameWithNumber> names = List.of(
            new nameWithNumber(1,"Ivan"),
            new nameWithNumber(2,"Petro"),
            new nameWithNumber(3,"Dmitro"),
            new nameWithNumber(4,"Stepan"),
            new nameWithNumber(5,"Sergiy"),
            new nameWithNumber(6,"Valerii"),
            new nameWithNumber(7,"Jack"),
            new nameWithNumber(8,"Michael"));

    String[] array = {"1, 4, 57", "2, 15, 3", "4, 5"};
    public void nonPairIndexing() {
//Метод приймає на вхід список імен. Необхідно повернути рядок вигляду
// 1. Ivan, 3. Peter... лише з тими іменами, що стоять під непарним індексом (1, 3 тощо)
        System.out.println("Task 1");
        LinkedHashMap<Integer, String> map = names.stream()
                .filter(num->num.id()%2!=0)
                    .collect(
                        Collectors
                                .toMap(nameWithNumber::id,
                                       nameWithNumber::name,
                                       (x, y)-> x + ", " + y,
                                       LinkedHashMap::new));

        map.forEach((x, y) -> System.out.println(x + ". " + y));
        System.out.println("");
    }

    public void upperCasing() {
//    Метод приймає на вхід список рядків (можна взяти список із Завдання 1).
//    Повертає список цих рядків у верхньому регістрі,
//    і відсортованих за спаданням (від Z до A).
        System.out.println("Task 2");
        List<nameWithNumber> sortedList = names.stream()
            .sorted(Comparator.comparing(nameWithNumber::name).reversed()).toList();
        sortedList.forEach(x-> System.out.println(x.name().toUpperCase()));
        System.out.println("");
    }

    public void sortingArray() {
    //  Є масив:  ["1, 2, 0", "4, 5"]
    //  Необхідно отримати з масиву всі числа, і вивести їх у відсортованому вигляді через кому ,, наприклад:
    //  "0, 1, 2, 4, 5"
        System.out.println("Task 3");
        Stream<String> arrayStream = Arrays.stream(array);
        Stream<Integer> intStream = arrayStream.flatMap(line -> Arrays.stream(line.split(", "))).map(Integer::valueOf).sorted();
        System.out.println(intStream.toList().toString().replace("[","").replace("]",""));
        System.out.println("");
    }
    public record nameWithNumber(Integer id, String name) { }
    //  Використовуючи Stream.iterate, створіть безкінечний стрім випадкових чисел, але не використовуючи Math.random().
    public void gfg() {
        // Seed value
        long seed = 98L; //System.currentTimeMillis();
        // Multiplier term
        long a = 25214903917L;
        // Increment term
        long c = 11L;
        // Modulus parameter
        long m = 2^48L;

        // Number of Random numbers
        // to be generated
        int numberRandomNum = 30;
        System.out.println("Task 4");

        Stream.iterate(seed, x->((x*a)+c)%m).limit(numberRandomNum).toList().forEach((Long rnd) -> System.out.print(rnd + " "));
        System.out.println("\n");
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
//    Напишіть метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
//    який "перемішує" елементи зі стрімів first та second, зупиняючись тоді,
//    коли у одного зі стрімів закінчаться елементи.
        Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();
        Stream.Builder<T> builder = Stream.builder();

        while (iterator1.hasNext()&&iterator2.hasNext()) {
            builder.add(iterator1.next()).add(iterator2.next());
        }

        return builder.build();
    }
}

