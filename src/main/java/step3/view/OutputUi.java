package step3.view;

import step3.domain.Ladder;
import step3.domain.Line;
import step3.domain.Participants;
import step3.domain.Rewards;
import step3.utils.StringUtil;

public class OutputUi {
    private static final String EMPTY = "";
    private static final Integer REPEAT = 5;
    private static final String STEP = "|";
    private static final String LINE = "-----";

    private static void printResult() {
        System.out.println("실행결과");
    }

    public static void printLadder(Participants names, Rewards reward, Ladder ladder) {
        printResult();
        printParticipants(names);
        drawingLadder(ladder, names.getParticipants().size());
        printReward(reward);
    }

    private static void printParticipants(Participants participants) {
        participants.getParticipants()
                .stream()
                .map(name -> StringUtil.padRight(name.getName().getName(), REPEAT) + EMPTY)
                .forEach(System.out::print);
        System.out.println();
    }

    private static void drawingLadder(Ladder ladder, int nameOfCount) {
        for (Line line : ladder.getLines()) {
            StringBuilder sb = new StringBuilder();
            sb.append(STEP);
            for(int i = 0; i < nameOfCount -1; i++) {
                sb.append(line.getLine() ? LINE : StringUtil.padRight(EMPTY, REPEAT) + EMPTY);
                sb.append(STEP);
            }
            System.out.println(sb);
        }
    }

    private static void printReward(Rewards reward) {
        reward.getRewards().stream()
                .map(e -> StringUtil.padRight(e.getName(), REPEAT) + EMPTY)
                .forEach(System.out::print);
        System.out.println();
    }

}
