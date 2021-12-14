package ladder.view;

import ladder.domain.Ladder;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    private static final int NAME_SPACE_SIZE = 6;
    private static final String NAME_SPACE = "      ";

    public ResultView() {
        System.out.println("실행 결과");
    }

    public void printNames(List<String> names) {
        names.stream()
                .map(this::transform)
                .forEach(System.out::print);
        System.out.println();
    }

    private String transform(String name) {
        char[] array = NAME_SPACE.toCharArray();
        int nameSize = name.length();
        IntStream.range(0, nameSize).forEach(i -> array[NAME_SPACE_SIZE - nameSize + i] = name.charAt(i));
        return String.valueOf(array);
    }

    public void printLadder(Ladder ladder) {
        ladder.getFloors().forEach(floor -> {
            floor.getLines().forEach(this::printLine);
            System.out.println();
        });
    }

    private void printLine(Boolean point) {
        if (point) {
            System.out.print("-----|");
            return;
        }
        System.out.print("     |");
    }
}
