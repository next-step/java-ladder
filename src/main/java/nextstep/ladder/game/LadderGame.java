package nextstep.ladder.game;

import nextstep.ladder.dto.Participant;
import nextstep.ladder.io.InputView;
import nextstep.ladder.io.OutputView;

import java.util.List;

public class LadderGame {

    public void start() {
        String inputNames = getInputNames();

        List<Participant> participants = Participant.parse(inputNames);
        Integer height = getInputHeight();

        Ladder ladder = Ladder.create(participants.size(), height);

        OutputView.printResult(participants, ladder);
    }

    private String getInputNames() {
        OutputView.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputNames = InputView.inputNames();
        OutputView.println();

        return inputNames;
    }

    private Integer getInputHeight() {
        OutputView.println("최대 사다리 높이는 몇 개인가요?");
        Integer inputHeight = InputView.inputHeight();
        OutputView.println();

        return inputHeight;
    }
}
