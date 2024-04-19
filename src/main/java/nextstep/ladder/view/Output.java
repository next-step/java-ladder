package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Output {

    private static final String UNLINK = "    |";
    private static final String LINK = "----|";

    public void personName(List<String> persons) {
        print("");
        print("실행 결과");
        System.out.println();
        String result = persons.stream()
                .collect(Collectors.joining(" "));
        print(result);
        System.out.println();
    }

    public void result(Ladder ladder) {
        ladder.getLadder().forEach(line -> {
            String result = line.getList().stream()
                    .map(isLink -> isLink ? LINK : UNLINK)
                    .collect(Collectors.joining()); // Join elements of the line with a space
            print(result);
            System.out.println(); // Add a blank line after printing each line
        });
    }

    private void print(String word) {
        System.out.print(word);
    }
}
