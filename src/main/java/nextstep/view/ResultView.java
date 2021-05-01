package nextstep.view;

import nextstep.model.Ladder;
import nextstep.model.Players;

import java.util.Random;

public class ResultView implements ConsoleView {

    private final int ladderCount;

    public ResultView(int ladderCount) {
        this.ladderCount = ladderCount;
    }

    @Override
    public void print(String str) {
        System.out.println(str);
    }

    public void printAll(Ladder ladder, Players players) {
        Random random = new Random();
        int move = random.nextInt(players.size());
        System.out.println("move = " + move);
        System.out.println("사다리 결과");
        System.out.println(players.spacedNames());
        for (int i = 0; i < ladder.ladderLines.size(); i++) {
            move = ladder.ladderLines.get(i).move(move);
            System.out.println(ladder.ladderLines.get(i).pointsString());
        }

    }

}
