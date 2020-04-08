package nextstep.ladder.view;

import nextstep.ladder.ViewUtils;
import nextstep.ladder.domain.Participant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String PARTICIPANT_NAME_INFORMATION = "참여자 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_RESULTS_INFORMATION = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_INFORMATION = "최대 사다리 높이는 몇 개인가요?";
    public static final String DELIMITER_COMMA = ",";

    public InputView() { }

    public List<Participant> getParticipants() {
        ViewUtils.printLine(PARTICIPANT_NAME_INFORMATION);
        String inputText = ViewUtils.readLine();
        List<String> participantNames = Arrays.asList(inputText.split(DELIMITER_COMMA));

        return participantNames.stream()
                .map(name -> new Participant(name, participantNames.indexOf(name)))
                .collect(Collectors.toList());
    }

    public int getHeight() {
        ViewUtils.printLine(LADDER_HEIGHT_INFORMATION);
        return ViewUtils.readLineToInt();
    }

    public List<String> getRadderResults() {
        ViewUtils.printLine(LADDER_RESULTS_INFORMATION);
        String inputText = ViewUtils.readLine();

        return Arrays.asList(inputText.split(DELIMITER_COMMA));
    }
}
