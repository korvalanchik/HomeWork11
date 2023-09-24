import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;



public class Streaming {
//Метод приймає на вхід список імен. Необхідно повернути рядок вигляду
// 1. Ivan, 3. Peter... лише з тими іменами, що стоять під непарним індексом (1, 3 тощо)
    public void nonPairIndexing() {

//        String outString = null;
        List<nameWithNumber> names = List.of(
                new nameWithNumber(1,"Ivan"),
                new nameWithNumber(2,"Petro"),
                new nameWithNumber(3,"Dmitro"),
                new nameWithNumber(4,"Stepan"),
                new nameWithNumber(5,"Sergiy"),
                new nameWithNumber(6,"Valerii"),
                new nameWithNumber(7,"Jack"),
                new nameWithNumber(8,"Michael"));


        LinkedHashMap<Integer, String> map = names.stream()
                .filter(num->num.id()%2!=0)
                    .collect(
                        Collectors
                                .toMap(nameWithNumber::id,
                                       nameWithNumber::name,
                                       (x, y)-> x + ", " + y,
                                       LinkedHashMap::new));

        map.forEach((x, y) -> System.out.println(x + ". " + y));

    }

    public record nameWithNumber(Integer id, String name) {


        //  constructor/getters/setters
        }

}
