package nextstep.ladder.view;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Lines;
import nextstep.ladder.model.Players;

public class OutputView {

    private OutputView() {
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(Players players) {
        print(players.toString());
    }

    public static void print(Line line) {
        print(line.toString());
    }

    public static void print(Lines lines) {
        print(lines.toString());
    }

    public static void print(Ladder ladder) {
        print("실행 결과");
        print(ladder.drawing());
    }
}
