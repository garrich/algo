import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class ParseText {
    final private static Map<String, Integer> textMap;

    public int getNumberFromText(String text) {
        List<Integer> collect = Arrays.stream(text.split(" ")).map(textMap::get).collect(Collectors.toList());
        log.info("{}", collect);

        IntStream.rangeClosed(0, collect.size()).forEach(i->
                log.info("{}", i)
        );
        OptionalInt sum = IntStream.range(0, collect.size()).reduce((curIndex, acc) -> {
            log.info("{}",curIndex);
            int curVal = collect.get(curIndex);
            if (curIndex == 1 && curVal >= 100) {
                return acc * curVal;
            }
            if (curIndex == 3 && curVal == 100) {
                return acc + collect.get(2) * curVal - collect.get(2);
            }
            return acc + curVal;
        });

        return sum.getAsInt();
    }

    static {
        textMap = new HashMap<>();
        textMap.put("zero", 0);
        textMap.put("one", 1);
        textMap.put("two", 2);
        textMap.put("three", 3);
        textMap.put("four", 4);
        textMap.put("five", 5);
        textMap.put("six", 6);
        textMap.put("seven", 7);
        textMap.put("eight", 8);
        textMap.put("nine", 9);
        textMap.put("ten", 10);
        textMap.put("eleven", 11);
        textMap.put("twelve", 12);
        textMap.put("thirteen", 13);
        textMap.put("fourteen", 14);
        textMap.put("fifteen", 15);
        textMap.put("sixteen", 16);
        textMap.put("seventeen", 17);
        textMap.put("eighteen", 18);
        textMap.put("nineteen", 19);
        textMap.put("twenty", 20);
        textMap.put("thirty", 30);
        textMap.put("forty", 40);
        textMap.put("fifty", 50);
        textMap.put("sixty", 60);
        textMap.put("seventy", 70);
        textMap.put("eighty", 80);
        textMap.put("ninety", 90);
        textMap.put("hundred", 100);
        textMap.put("thousand", 1000);
    }
}
