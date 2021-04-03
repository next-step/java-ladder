package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderRideGame {

    private static String SPLIT_DELIMITER = ",";

    public void start() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Participants participants = checkUsers(inputView.inputParticipants());
        Height height = checkHeight(inputView.inputLadderHeight());

        Ladder ladder = Ladder.valueOf(participants, height);

        resultView.printResult(ladder, participants);
    }

    private Height checkHeight(int inputLadderHeight) {
        return Height.valueOf(inputLadderHeight);
    }

    private Participants checkUsers(String inputParticipants) {
        if(Objects.isNull(inputParticipants) || inputParticipants.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
        return Participants.valueOf(parseUsers(inputParticipants));
    }

    private String[] parseUsers(final String users) {
        return Arrays.stream(users.split(SPLIT_DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);
    }
}
