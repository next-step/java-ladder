package step3.view;

import step3.domain.*;
import step3.utils.StringUtil;

import java.util.List;

public class OutputUi {
    private static final String EMPTY = "";
    private static final Integer REPEAT = 5;
    private static final String STEP = "|";

    private static void printResult() {
        System.out.println("실행결과");
    }

    public static void printLadder(Participants names, Rewards reward, Ladder ladder) {
        printResult();
        printParticipants(names);
        drawingLadder(ladder);
        printReward(reward);
    }

    private static void printParticipants(Participants participants) {
        participants.getParticipants()
                .stream()
                .map(name -> StringUtil.padRight(name.getName(), REPEAT) + EMPTY)
                .forEach(System.out::print);
        System.out.println();
    }

    private static void drawingLadder(Ladder ladder) {
        ladder.getLines().forEach(OutputUi::printLine);
    }

    private static void printLine(Lines lines) {
        StringBuilder sb = new StringBuilder();
        sb.append(STEP);
        lines.getLineList().forEach(line -> {
            sb.append(line.getDirection().getDirection());
            sb.append(STEP);
        });
        System.out.println(sb);

    }

    private static void printReward(Rewards reward) {
        reward.getRewards().stream()
                .map(e -> StringUtil.padRight(e.getName(), REPEAT) + EMPTY)
                .forEach(System.out::print);
        System.out.println();
    }

    public static void printLadderGameResult(List<LadderGameResult> results) {
        System.out.println("실행결과");

        results.stream()
                .map(ladderGameResult -> ladderGameResult.getName() + ": " + ladderGameResult.getReward().getName())
                .forEach(System.out::println);
    }

}
