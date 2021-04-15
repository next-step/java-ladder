package nextstep.view;

import nextstep.constant.Constant;
import nextstep.model.OnlineLadder;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static nextstep.constant.Constant.EMPTY_LADDER_STRING;
import static nextstep.constant.Constant.HORIZON_LADDER_STRING;

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
        String draw = render(ladder, targetHeight);
        System.out.print(draw);
        System.out.println();
    }

    private String render(OnlineLadder ladder, int targetHeight) {
        StringBuilder stringBuilder = new StringBuilder();
        ladder.points(targetHeight).points().stream()
                .forEach(point -> {
                    stringBuilder.append(Constant.SPLIT_LADDER_STRING);
                    stringBuilder.append( (point) ? HORIZON_LADDER_STRING : EMPTY_LADDER_STRING);
                });
        stringBuilder.append("|");
        return stringBuilder.toString();
    }

    public void printAll(OnlineLadder ladder) {
        IntStream.range(0, this.ladderCount)
                .forEach((index) -> this.print(ladder, index));
    }
}
