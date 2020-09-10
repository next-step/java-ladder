package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderFactory;
import ladder.domain.LadderResultMapper;
import ladder.domain.Participants;
import ladder.domain.Rewards;
import ladder.ui.Input;
import ladder.ui.LadderDataInput;
import ladder.ui.Output;

public class LadderController {

    private static final String MSG_SEARCH_PLAYER_REWARDS = "결과를 보고 싶은 사람은? (all 입력 시 모두, exit 입력 시 종료)";
    private static final String MSG_SEARCH_REWARDS_RESULT = "실행 결과";

    private static final String EXIT_COMMAND = "exit";
    private static final String SEARCH_ALL_PLAYER = "all";

    private final Input input;
    private final Output output;
    private final LadderDataInput ladderDataInput;

    public LadderController(LadderControllerBuilder builder) {

        this.input = builder.getInput();
        this.output = builder.getOutput();
        this.ladderDataInput = new LadderDataInput(input, output);
    }

    public static LadderControllerBuilder builder() {
        return new LadderControllerBuilder();
    }

    public Participants makeParticipants() {
        return ladderDataInput.getParticipant();
    }

    public Ladder makeLadder() {
        return LadderFactory.of(ladderDataInput);
    }

    public Rewards makeRewards() {
        return ladderDataInput.getRewards();
    }

    public void printLadder(Participants participants, Ladder ladder, Rewards rewards) {
        output.print(participants.getNames());
        output.printMultiLine(ladder.getLadderLinesString());
        output.print(rewards.getNames());
    }

    public void printResult(LadderResultMapper ladderResultMapper) {

        input.nextLine();

        boolean run;

        do {
            output.print(MSG_SEARCH_PLAYER_REWARDS);
            run = printRewards(input.nextLine(), ladderResultMapper);
        } while(run);
    }

    private boolean printRewards(String participantName, LadderResultMapper ladderResultMapper) {

        if (participantName.equals(EXIT_COMMAND)) {
            return false;
        }

        if (participantName.equals(SEARCH_ALL_PLAYER)) {
            output.print(MSG_SEARCH_REWARDS_RESULT);
            output.printMultiLine(ladderResultMapper.getAll());
            return true;
        }

        output.print(MSG_SEARCH_REWARDS_RESULT);
        output.print(ladderResultMapper.get(participantName));

        return true;
    }
}
