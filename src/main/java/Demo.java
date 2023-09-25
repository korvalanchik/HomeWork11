import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        Streaming streaming = new Streaming();
        streaming.nonPairIndexing();
        streaming.upperCasing();
        streaming.sortingArray();
        streaming.gfg();
        System.out.println("Task 5");
        Stream<String> first = Stream.of("If", "cut", "a", "wings", "you", "off", "legs", "that", "die", "boredom", "it", "ha", "ha", "ha", "ha");
        Stream<String> second = Stream.of("you", "off", "bird's", "if", "cut", "its", "too", "bird", "of", "because", "won't be able to sit");
        Stream<String> third = Streaming.zip(first, second);
        System.out.println(third.toList().toString().replace(",", "").replace("[", "").replace("]", ""));
    }
}
