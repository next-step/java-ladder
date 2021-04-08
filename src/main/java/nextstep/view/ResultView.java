package nextstep.view;

import nextstep.OnlineLadder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultView implements ConsoleView {
    private static final String HORIZON = "-----";
    private static final String VERTICAL = "|";
    private static final String EMPTY = "     ";
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

    public void print(OnlineLadder ladder) {
        Integer max = Collections.max(ladder.heights());
        for(int i = 0; i < ladder.heights().size(); i++) {
            if (beforeHeight.get(i) != ladder.heights().get(i) && ladder.heights().get(i).equals(max)) {
                System.out.print(HORIZON + VERTICAL);
            } else {
                System.out.print(EMPTY + VERTICAL);
            }
        }
        System.out.println();
        this.beforeHeight = ladder.heights();
    }

    public void printAll(OnlineLadder ladder, String[] names) {
        for (String name : names) {
            ladder.add(name);
        }
        for (int i = 0; i < this.ladderCount; i++) {
            ladder.move();
            this.print(ladder);
        }
    }
}
