package nextstep.laddergame.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
                           .map(Participant::new)
                           .collect(Collectors.toList());
    }
}
