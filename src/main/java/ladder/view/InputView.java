package ladder.view;

import ladder.model.ExecutionResult;
import ladder.model.ExecutionResults;
import ladder.model.Height;
import ladder.model.Participant;
import ladder.model.Participants;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class InputView {

    private static final String INPUT_PARTICIPANT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MAX_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_EXECUTION_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_PARTICIPANT_FOR_RESULT = "결과를 보고 싶은 사람은?";

    private static final String DEFAULT_DELIMITER = ",";

    private static final String BLANK = "";
    private static final String WHITE_SPACE = " ";

    private final Scanner scanner = new Scanner(System.in);

    public Participants inputParticipants() {
        System.out.println(INPUT_PARTICIPANT_NAMES_MESSAGE);
        return convertParticipants();
    }

    private Participants convertParticipants() {
        String[] participants = splitByDefaultDelimiter();
        return Arrays.stream(participants)
                .map(Participant::create)
                .collect(collectingAndThen(toList(), Participants::create));
    }

    public Height inputLadderHeight() {
        System.out.println(MAX_LADDER_HEIGHT_MESSAGE);
        return Height.create(Integer.parseInt(readLine()));
    }

    public ExecutionResults inputExecutionResults() {
        System.out.println(INPUT_EXECUTION_RESULT);
        return convertExecutionResults();
    }

    public String inputParticipantForResult() {
        System.out.println(INPUT_PARTICIPANT_FOR_RESULT);
        return readLine();
    }

    private ExecutionResults convertExecutionResults() {
        String[] executionResults = readLine().replace(WHITE_SPACE, BLANK).split(DEFAULT_DELIMITER);
        List<ExecutionResult> executionResultList = Arrays.stream(executionResults)
                .map(ExecutionResult::create)
                .collect(toList());
        return ExecutionResults.create(executionResultList);
    }

    private String[] splitByDefaultDelimiter() {
        return readLine().replace(WHITE_SPACE, BLANK).split(DEFAULT_DELIMITER);
    }

    private String readLine() {
        return scanner.nextLine();
    }

}
