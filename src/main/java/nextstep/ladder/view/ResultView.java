package nextstep.ladder.view;

import nextstep.ladder.domain.Line;

import java.util.List;

public class ResultView {

    public void printResultLadder(List<String> users, List<Line> ladder) {
        System.out.println();
        System.out.println("실행결과");

        System.out.println();
        users.stream().forEach(System.out::print);

        System.out.println();
        ladder.stream().forEach(System.out::println);
    }
}
