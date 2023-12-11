package seungjun.ladder;

import ladder.LadderParticipant;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 여러개의 이름을 생성하는 유틸용 클래스.
 * @see LadderParticipant
 */
public class Names {
    private Names() {
    }

    public static List<LadderParticipant> of(String names) {
        return splitNames(names).stream()
                .map(LadderParticipant::new)
                .collect(Collectors.toList());
    }

    private static List<String> splitNames(String names) {
        return List.of(names.split(","));
    }
}