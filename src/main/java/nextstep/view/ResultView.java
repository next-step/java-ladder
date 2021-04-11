package nextstep.view;

import nextstep.model.OnlineLadder;

import static nextstep.constant.Constant.EMPTY_LADDER_STRING;

public class ResultView implements ConsoleView {
    private final int ladderCount;

    public ResultView(int ladderCount) {
        this.ladderCount = ladderCount;
    }

    @Override
    public void print(String str) {
        System.out.println(str);
    }

    public void print(OnlineLadder ladder, int targetHeight) {
        System.out.print(ladder.ladderString(targetHeight));
        System.out.println();
    }

    public void printAll(OnlineLadder ladder) {
        System.out.println(ladder.playersString());
        for (int i = 0; i < this.ladderCount; i++) {
            this.print(ladder, i);
        }
    }
}
