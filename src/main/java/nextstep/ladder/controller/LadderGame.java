package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.InputViewInterface;
import nextstep.ladder.view.OutputViewInterface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    public static final String PARTICIPANT_PROMPT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String RESULT_PROMPT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String MAX_LADDER_HEIGHT_PROMPT = "최대 사다리 높이는 몇 개인가요?";
    private final InputViewInterface inputView;
    private final OutputViewInterface outputView;

    public LadderGame(InputViewInterface inputView, OutputViewInterface outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        List<Name> names = getNames(PARTICIPANT_PROMPT);
        Participants participants = Participants.fromNames(names);
        List<Name> results = getNames(RESULT_PROMPT);
        int maxLadderHeight = inputView.getNumberInput(MAX_LADDER_HEIGHT_PROMPT);

        Ladder ladder = Ladder.generate(maxLadderHeight, names.size() - 1);
        participants.move(ladder);

        outputView.printLadder(names, ladder.getLines(), results);
        outputView.printGameResult(names, participants.getMatchResults(results));
    }

    private List<Name> getNames(String prompt) {
        String[] names = inputView.getStringListInput(prompt, ",");
        return Arrays.stream(names).map(Name::new).collect(Collectors.toList());
    }
}
