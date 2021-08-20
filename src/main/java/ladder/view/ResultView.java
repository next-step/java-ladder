package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ladder.domain.Line;

public class ResultView {
    private static final String OUTPUT_EXECUTION_RESULT = "실행결과";
    private static final String OUTPUT_LADDER_FRONT_MARGIN = " ";
    private static final String OUTPUT_LADDER_WIDTH_STRING = "-";
    private static final String OUTPUT_LADDER_HEIGHT_STRING = "|";
    private static final int DEFAULT_LADDER_WIDTH = 5;

    private void outputLadderWidth(boolean isPrint, boolean isLast) {
        StringBuilder stringBuilder = new StringBuilder(OUTPUT_LADDER_HEIGHT_STRING);
        String lineComponent = " ";
        if (isPrint && !isLast) {
            lineComponent = OUTPUT_LADDER_WIDTH_STRING;
        }

        String finalLineComponent = lineComponent;
        stringBuilder.append(IntStream.range(0, DEFAULT_LADDER_WIDTH)
            .mapToObj(e -> finalLineComponent)
            .collect(Collectors.joining(""))
        );
        System.out.print(stringBuilder);
    }

    private void outputFrontMargin() {
        IntStream.range(0, DEFAULT_LADDER_WIDTH)
            .forEach(i -> System.out.print(OUTPUT_LADDER_FRONT_MARGIN));
    }

    private void outputLadderLine(Line line) {
        outputFrontMargin();

        int lengthOfLine = line.toList().size();
        IntStream.range(0, lengthOfLine)
                .forEach(i -> outputLadderWidth(line.toList().get(i), i == lengthOfLine - 1));

        System.out.print(System.lineSeparator());
    }


    public void outputLadder(List<Line> lines, List<String> names) {
        System.out.println("\n" + OUTPUT_EXECUTION_RESULT + "\n");

        outputNames(names);
        IntStream.range(0, lines.size())
            .forEach(i -> outputLadderLine(lines.get(i)));
    }

    private void outputNames(List<String> names) {
        names.stream()
                .forEach(name -> System.out.printf("%6s", name));

        System.out.print(System.lineSeparator());
    }
}
