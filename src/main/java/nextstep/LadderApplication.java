package nextstep;

import nextstep.domain.Line;
import nextstep.view.InputView;
import nextstep.view.ResultView;

import java.util.LinkedList;

public class LadderApplication {

    public static void main(String[] args) {

        String[] names = InputView.inputNames();

        int ladderHeight = InputView.inputLadderHeight();

        LinkedList<Line> lines = new LinkedList<>();
        lines.add(new Line(ladderHeight)); // 첫번째 라인은 랜덤으로 생성

        for (int i = 1; i < names.length - 1; i++) {
            lines.addLast(new Line(lines.getLast()));
        }

        ResultView.printResult(names, ladderHeight, lines);
    }
}
