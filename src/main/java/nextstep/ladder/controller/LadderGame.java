package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputViewInterface;
import nextstep.ladder.view.OutputViewInterface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private static final String PARTICIPANT_PROMPT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String RESULT_PROMPT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String MAX_LADDER_HEIGHT_PROMPT = "최대 사다리 높이는 몇 개인가요?";
    private static final String SHOW_RESULT_NAME_PROMPT = "결과를 보고 싶은 사람은?(all:전부, exit:종료)";
    private static final String PLAY_RESULT = "실행 결과";
    private final InputViewInterface inputView;
    private final OutputViewInterface outputView;

    public LadderGame(InputViewInterface inputView, OutputViewInterface outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Participants participants = new Participants(getNames(PARTICIPANT_PROMPT));
        Rewards rewards = new Rewards(getNames(RESULT_PROMPT));
        int maxLadderHeight = inputView.getNumberInput(MAX_LADDER_HEIGHT_PROMPT);

        Ladder ladder = Ladder.generate(maxLadderHeight, participants.size());
        LadderResults ladderResults = ladder.assignRewards(participants, rewards);

        outputView.printLadder(participants, ladder, rewards);
        startResultSession(ladderResults);
    }

    private List<Name> getNames(String prompt) {
        String[] names = inputView.getStringListInput(prompt, ",");
        return Arrays.stream(names).map(Name::new).collect(Collectors.toList());
    }

    private void startResultSession(LadderResults ladderResults) {
        String input = inputView.getStringInput(SHOW_RESULT_NAME_PROMPT);
        if (input.equalsIgnoreCase("exit")) {
            return;
        }

        outputView.printPrompt(PLAY_RESULT);

        if (input.equalsIgnoreCase("all")) {
            outputView.printAllMatchResult(ladderResults.asMap());
            startResultSession(ladderResults);
            return;
        }

        outputView.printResult(ladderResults.resultOf(input));
        startResultSession(ladderResults);
    }
}
