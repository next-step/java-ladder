package ladder.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printNames(List<String> names) {
        System.out.println("실행결과");
        System.out.println();

        names.stream()
                .map(name -> String.format("%5s ", name))
                .forEach(System.out::print);

        System.out.println();
    }

    public void printLadder(List<List<Boolean>> ladders) {
        ladders.stream()
                .map(this::convertLine)
                .forEach(System.out::println);
    }

    private String convertLine(List<Boolean> line) {
        return line.stream()
                .map(this::convertLineElement)
                .collect(Collectors.joining("|", "    |", "|"));
    }

    private String convertLineElement(Boolean connected) {
        return Boolean.TRUE.equals(connected) ? "-----" : "     ";
    }
}
