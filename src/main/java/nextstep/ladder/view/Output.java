package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

    private static final String UNLINK = "    |";
    private static final String LINK = "----|";

    public void personName(List<String> persons) {
        print("");
        print("실행 결과");
        System.out.println();
        String names = persons.stream()
                .collect(Collectors.joining("  ", " ", ""));
        print(names);
        System.out.println();
    }

    public void ladderResult(Ladder ladder) {
        ladder.getLadder().forEach(line -> {
            String result = line.getList().stream()
                    .map(isLink -> isLink ? LINK : UNLINK)
                    .collect(Collectors.joining());
            print(result);
            System.out.println();
        });
    }

    public void runResult(List<String> results) {
        String result = results.stream()
                .collect(Collectors.joining("  ", " ", ""));
        print(result);
        System.out.println();
    }

    private void print(String word) {
        System.out.print(word);
    }
}
