package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participant;
import ladder.domain.ParticipantGroup;
import ladder.domain.Score;
import ladder.domain.LadderGame;
import ladder.domain.LadderResult;
import ladder.pattern.RandomValueGenerator;
import ladder.pattern.ValueGenerateStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

import static ladder.domain.Point.UNIT_HORIZONTAL_LINE_LENGTH;

public class LadderGameController {
    private static final ValueGenerateStrategy valueGenerateStrategy = new RandomValueGenerator();
    private static final String VIEW_ALL_COMMAND = "all";
    private static final String VIEW_EXIT_COMMAND = "exit";

    public static void main(String[] args) {
        List<Participant> participants = Participant.create(InputView.scanParticipantNames());
        ParticipantGroup participantGroup = new ParticipantGroup(participants);
        int maxConnectionLineLength = participantGroup.maxParticipantNameLength();

        List<Score> scores = Score.create(InputView.scanScores(), maxConnectionLineLength);
        LadderGame ladderGame = new LadderGame(participants, scores);

        int height = InputView.scanLadderHeight();
        int width = participantGroup.participantsCount();
        Ladder ladder = Ladder.create(width, height, valueGenerateStrategy);

        LadderResult ladderResult = ladderGame.ladderResult(ladder);

        printLadder(participantGroup, scores, ladder);

        viewLadderGameResult(ladderResult);
    }

    private static void printLadder(ParticipantGroup participantGroup, List<Score> scores, Ladder ladder) {
        int maxConnectionLineLength = participantGroup.maxParticipantNameLength();
        OutputView.printResultGuide();
        OutputView.printParticipants(participantGroup.participantNames(), maxConnectionLineLength + UNIT_HORIZONTAL_LINE_LENGTH);
        OutputView.printLadder(ladder, maxConnectionLineLength);
        OutputView.printScores(scores.stream().map(Score::score).collect(Collectors.toList()), maxConnectionLineLength + UNIT_HORIZONTAL_LINE_LENGTH);
    }

    public static void viewLadderGameResult(LadderResult ladderResult) {
        String command = InputView.scanResultViewCommand();
        if (command.equalsIgnoreCase(VIEW_EXIT_COMMAND)) {
            return;
        }
        if (command.equalsIgnoreCase(VIEW_ALL_COMMAND)) {
            OutputView.printAllResultView(ladderResult);
            viewLadderGameResult(ladderResult);
            return;
        }

        try {
            OutputView.printResultView(command, ladderResult);
            viewLadderGameResult(ladderResult);
        } catch (IllegalArgumentException exception) {
            OutputView.printReScanCommand();
            viewLadderGameResult(ladderResult);
        }
    }
}
