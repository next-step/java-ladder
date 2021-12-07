package nextstep.laddergame.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import nextstep.laddergame.model.Goal;
import nextstep.laddergame.model.Participant;
import nextstep.laddergame.utils.ScannerUtils;

public final class InputView {

    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static List<Participant> acceptParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> participants = Arrays.asList(ScannerUtils.nextLine().split(DELIMITER));
        return participants.stream()
                           .map(Participant::from)
                           .collect(Collectors.toList());
    }

    public static int acceptMaxLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return ScannerUtils.nextInt();
    }

    public static List<Goal> acceptGoals() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");
        List<String> goals = Arrays.asList(ScannerUtils.nextLine().split(DELIMITER));
        return goals.stream()
                    .map(Goal::new)
                    .collect(Collectors.toList());
    }

    public static Participant acceptParticipant() {
        System.out.println("결과를 보고 싶은 사람은?");
        return Participant.from(ScannerUtils.nextLine());
    }
}
