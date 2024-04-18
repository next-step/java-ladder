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
        print("실행 결과");
        System.out.println();
        String result = persons.stream()
                .collect(Collectors.joining(" "));
        print(result);
        System.out.println();
    }

    public void result(Ladder ladder) {
        ladder.getLadder().forEach(line ->
                print(line.getList().stream()
                        .map(isLink -> isLink ? LINK : UNLINK)
                        .collect(Collectors.joining())));
        System.out.println();
    }

    private void print(String word) {
        System.out.print(word);
    }
}
