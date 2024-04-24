package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Person;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

    private static final String UNLINK = "    |";
    private static final String LINK = "----|";

    public void personName(Person persons) {
        print("사다리 결과");
        System.out.println();
        print(persons.name());
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
                .collect(Collectors.joining("   ", " ", ""));
        print(result);
        System.out.println('\n');
    }

    private void print(String word) {
        System.out.print(word);
    }
}
