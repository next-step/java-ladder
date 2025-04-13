package nextstep.ladder.game;

import nextstep.ladder.dto.Participant;
import nextstep.ladder.io.InputParser;
import nextstep.ladder.io.InputView;
import nextstep.ladder.io.OutputView;

import java.util.List;
import java.util.Map;

public class LadderGame {

    public static final String ALL = "all";

    public void start() {
        String inputNames = getInputNames();
        String inputResults = getInputResults();

        List<Participant> participants = InputParser.parseParticipants(inputNames);
        List<String> results = InputParser.parseResults(inputResults);

        Integer height = getInputHeight();

        Ladder ladder = LadderFactory.createLadder(participants.size(), height);

        Map<Participant, Integer> resultsByParticipant = ladder.getResult(participants);

        OutputView.printLadder(participants, ladder, results);

        printResult(participants, results, resultsByParticipant);
    }

    private String getInputNames() {
        OutputView.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputNames = InputView.inputLine();
        OutputView.println();

        return inputNames;
    }


    private String getInputResults() {
        OutputView.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String inputResults = InputView.inputLine();
        OutputView.println();

        return inputResults;
    }

    private Integer getInputHeight() {
        OutputView.println("최대 사다리 높이는 몇 개인가요?");
        Integer inputHeight = InputView.inputHeight();
        OutputView.println();

        return inputHeight;
    }

    private void printResult(List<Participant> participants, List<String> results, Map<Participant, Integer> resultPositionsByParticipant) {
        while (true) {
            String resultTarget = getInputGameResult();

            OutputView.println("실행 결과");
            if (resultTarget.equals(ALL)) {
                participants.forEach(participant -> printTargetResultForAll(results, resultPositionsByParticipant, participant));
                break;
            }

            printTargetResult(results, resultPositionsByParticipant, resultTarget);
        }
    }

    private String getInputGameResult() {
        OutputView.println("결과를 보고 싶은 사람은?");
        String resultTarget = InputView.inputLine();
        OutputView.println();

        return resultTarget;
    }

    private void printTargetResult(List<String> results, Map<Participant, Integer> resultPositionsByParticipant, String resultTarget) {
        Participant resultTargetParticipant = new Participant(resultTarget);
        String targetResult = getTargetResult(resultTargetParticipant, results, resultPositionsByParticipant);
        OutputView.println(targetResult);
    }

    private void printTargetResultForAll(List<String> results, Map<Participant, Integer> resultPositionsByParticipant, Participant participant) {
        String targetResult = getTargetResult(participant, results, resultPositionsByParticipant);
        OutputView.println(participant + " : " + targetResult);
    }

    private String getTargetResult(Participant resultTargetParticipant, List<String> results, Map<Participant, Integer> resultPositionsByParticipant) {
        Integer resultIndex = resultPositionsByParticipant.get(resultTargetParticipant);
        return results.get(resultIndex);
    }
}
