package nextstep.ladder.view;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static Participants inputParticipantsNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return Participants.fromCommaSeparatedNames(SCANNER.nextLine());
    }

    public static Height inputMaxLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return new Height(Integer.parseInt(SCANNER.nextLine()));
    }

    public static List<LadderResult> inputLadderResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        return parseLadderResults(SCANNER.nextLine());
    }

    public static Participant inputParticipantNameForResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        String inputNames = SCANNER.nextLine();

        return new Participant(inputNames);
    }

    private static List<LadderResult> parseLadderResults(String inputLadderResults) {
        return Arrays.stream(inputLadderResults.split(","))
                .map(String::trim)
                .map(LadderResult::new)
                .collect(Collectors.toList());
    }
}
