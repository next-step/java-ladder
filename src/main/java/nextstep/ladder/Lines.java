package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lines {
    private final static String LINES_DELIMITER = "\n";
    private List<Line> lines = new ArrayList<>();

    public Lines(int height, int countOfPerson) {
        generate(height, countOfPerson);
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    private void generate(int height, int countOfPerson) {
        this.lines = Stream.generate(() -> new Line(countOfPerson))
                .limit(height)
                .collect(Collectors.toList());
    }

    public List<Line> getValues() {
        return this.lines;
    }

    public String toString(String lineTrueSymbol, String lineFalseSymbol) {
        return String.join(
                LINES_DELIMITER,
                this.lines
                        .stream()
                        .map((line) -> line.toString(lineTrueSymbol, lineFalseSymbol))
                        .collect(Collectors.toList())
        );
    }

    public List<Integer> getFinalResultIndexs(int countOfPerson) {
        List<Integer> finalResultIndexs = IntStream.range(0, countOfPerson)
                .boxed()
                .collect(Collectors.toList());

        // 각 사람의 위치를 개별적으로 이동
//        for (int personIndex = 0; personIndex < countOfPerson; personIndex++) {
//            int currentIndex = personIndex;
//
//            for (Line line : lines) {
//                List<Integer> resultIndexs = line.getResultIndexs();
//                currentIndex = resultIndexs.get(currentIndex);
//            }
//
//            // 최종 위치를 반영
//            finalResultIndexs.set(personIndex, currentIndex);
//        }

        IntStream.range(0, countOfPerson)
                .forEach(personIndex -> {
                    int currentIndex = personIndex;
                    for (Line line : lines) {
                        List<Integer> resultIndexs = line.getResultIndexs();
                        currentIndex = resultIndexs.get(currentIndex);
                    }

                    finalResultIndexs.set(personIndex, currentIndex);
                });

        return finalResultIndexs;
    }
}
