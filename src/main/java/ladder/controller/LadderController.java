package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderFactory;
import ladder.ui.Input;
import ladder.ui.LadderDataInput;
import ladder.ui.Output;

public class LadderController {

    private static final String MSG_SEARCH_PLAYER_REWARD = "결과를 보고 싶은 사람은? (all 입력 시 모두, exit 입력 시 종료)";
    private static final String MSG_SEARCH_REWARD_RESULT = "실행 결과";

    private static final String EXIT_COMMAND = "exit";
    private static final String SEARCH_ALL_PLAYER = "all";

    private final Input input;
    private final Output output;
    private final Ladder ladder;

    public LadderController(LadderControllerBuilder builder) {

        this.input = builder.getInput();
        this.output = builder.getOutput();

        ladder = LadderFactory.of(new LadderDataInput(input, output));
    }

    public static LadderControllerBuilder builder() {
        return new LadderControllerBuilder();
    }

    public void printLadder() {
        output.print(ladder.getNames());
        output.printMultiLine(ladder.getLadderLinesString());
        output.print(ladder.getRewardNames());
    }

    public void printResult() {

        input.nextLine();

        boolean run;

        do {
            output.print(MSG_SEARCH_PLAYER_REWARD);
            run = printReward(input.nextLine());
        } while(run);
    }

    private boolean printReward(String playerName) {

        if (playerName.equals(EXIT_COMMAND)) {
            return false;
        }

        if (playerName.equals(SEARCH_ALL_PLAYER)) {
            output.print(MSG_SEARCH_REWARD_RESULT);
            output.printMultiLine(ladder.searchAllReward());
            return true;
        }

        output.print(MSG_SEARCH_REWARD_RESULT);
        output.print(ladder.searchReward(playerName));

        return true;
    }
}
