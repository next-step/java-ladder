package nextstep.ladder.view;

import nextstep.ladder.Line;

import java.util.List;

public class ResultView {
    public void println(int maxLadderHeight, List<String> people) {
        for(int i = 0; i < maxLadderHeight; i++) {
            System.out.println(Line.drawLine(people.size()));
        }
    }

    public void printName(List<String> list) {
        String names = list.toString().replaceAll("\\[|\\]", "").replaceAll(",", "");
        System.out.println(names);
    }
}
