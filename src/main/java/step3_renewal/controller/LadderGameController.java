package step3_renewal.controller;

import step3_renewal.domain.*;
import step3_renewal.utils.StringUtil;
import step3_renewal.view.InputUi;
import step3_renewal.view.OutputUi;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    public static void run() {
        Participants participants = Participants.of(StringUtil.splitToList(InputUi.nameOfParticipate()));
        Rewards rewards =
                Rewards.of(StringUtil.splitToList(InputUi.inputExecutionResult()), participants.getParticipants().size());

        Ladder ladder = Ladder.of(InputUi.maximumHeight(), participants);
        OutputUi.printAll(participants, rewards, ladder);
        OutputUi.printLadderGameResult(InputUi.wantToSeeResult(), gameStart(participants, rewards, ladder));

        InputUi.close();
    }

    public static GameResults gameStart(Participants participants, Rewards rewards, Ladder ladder) {
        List<GameResult> list =
                participants.getParticipants()
                        .stream()
                        .map(participant -> toGameResult(participant, rewards, ladder))
                        .collect(Collectors.toList());
        return GameResults.of(list);
    }

    private static GameResult toGameResult(Participant participant, Rewards rewards, Ladder ladder) {
        return GameResult.of(participant.getParticipantName()
                , rewards.getRewardName(ladder.move(participant.getPosition())));
    }
}
