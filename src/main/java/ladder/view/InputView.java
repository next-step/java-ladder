package ladder.view;

import ladder.domain.ExecutionResult;
import ladder.domain.ExecutionResults;
import ladder.domain.Participant;
import ladder.domain.Participants;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_PARTICIPANTS_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_EXECUTION_RESULT_MESSAGE  = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String BLANK_STRING = " ";
    private static final String EMPTY_STRING = "";
    private static final String DELIMITER_REG = ",";
    private static final String INPUT_MAX_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개 인가요?";
    private static final String INPUT_PARTICIPANT_FOR_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";

    public Participants inputParticipants() {
        System.out.println(INPUT_PARTICIPANTS_MESSAGE);
        return Arrays.stream(getSplitArray())
                .map(Participant::new)
                .collect(getParticipants());
    }

    public ExecutionResults inputExecutionResults() {
        System.out.println(INPUT_EXECUTION_RESULT_MESSAGE);
        return Arrays.stream(getSplitArray())
                .map(ExecutionResult::new)
                .collect(getExecutionResults());
    }

    public int inputMaxLadderHeight() {
        System.out.println(INPUT_MAX_HEIGHT_MESSAGE);
        return Integer.parseInt(readLine());
    }

    public String inputParticipantForResult() {
        System.out.println(INPUT_PARTICIPANT_FOR_RESULT_MESSAGE);
        return readLine();
    }


    private String[] getSplitArray() {
        String participantsString = readLine();
        return participantsString.replace(BLANK_STRING, EMPTY_STRING).split(DELIMITER_REG);
    }

    private Collector<Participant, Object, Participants> getParticipants() {
        return Collectors.collectingAndThen(Collectors.toList(), Participants::new);
    }

    private Collector<ExecutionResult, Object, ExecutionResults> getExecutionResults() {
        return Collectors.collectingAndThen(Collectors.toList(), ExecutionResults::new);
    }

    public String readLine() {
        return SCANNER.nextLine();
    }
}
