package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputViewInterface;
import nextstep.ladder.view.OutputViewInterface;

public class LadderGame {
    public static final String PARTICIPANT_PROMPT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String MAX_LADDER_HEIGHT_PROMPT = "최대 사다리 높이는 몇 개인가요?";
    private final InputViewInterface inputView;
    private final OutputViewInterface outputView;

    public LadderGame(InputViewInterface inputView, OutputViewInterface outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        outputView.printPrompt(PARTICIPANT_PROMPT_MESSAGE);
        String[] names = inputView.getStringListInput(",");
        outputView.printPrompt(MAX_LADDER_HEIGHT_PROMPT);
        int maxLadderHeight = inputView.getNumberInput();

        Ladder ladder = new Ladder(maxLadderHeight, names);
        outputView.printNames(ladder.getNames());
        outputView.printLadder(ladder.getLines());
    }
}
