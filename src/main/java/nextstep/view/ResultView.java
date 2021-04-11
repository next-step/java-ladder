package nextstep.view;

import nextstep.OnlineLadder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultView implements ConsoleView {
    private List<Integer> beforeHeight;
    private final int ladderCount;

    public ResultView(int ladderCount) {
        this.ladderCount = ladderCount;
        this.beforeHeight = new ArrayList<>();
        for (int i = 0; i < ladderCount; i++) {
            this.beforeHeight.add(0);
        }
    }

    @Override
    public void print(String str) {
        System.out.println(str);
    }

    public void print(OnlineLadder ladder, int targetHeight) {
        System.out.print(ladder.ladderString(targetHeight));
        System.out.println();
    }

    public void printAll(OnlineLadder ladder, String[] names) {
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();
        for (int i = 0; i < this.ladderCount; i++) {
//            ladder.move();
            this.print(ladder, i);
        }
    }
}
