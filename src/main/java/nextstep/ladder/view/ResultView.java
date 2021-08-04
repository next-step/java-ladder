package nextstep.ladder.view;

import nextstep.ladder.LadderName;
import nextstep.ladder.Line;

import java.util.List;

public class ResultView {
    //TODO: 해결 해야하는 문제
    public void println(int maxLadderHeight, List<String> people) {
        for(int i = 0; i < maxLadderHeight; i++) {
            System.out.println(Line.drawLine(people.size()));
        }
    }

    public void printName(LadderName ladderName) {
        System.out.println(ladderName.toString().replaceAll("\\[|\\]", "").replaceAll(",", ""));
    }
}
