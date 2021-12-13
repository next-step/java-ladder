package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;

public class Compensations {
    private final List<String> compensations;

    private Compensations(List<String> compensations, int participantsSize) {
        checkCompensationsSize(compensations, participantsSize);
        this.compensations = compensations;
    }

    public static Compensations of(String compensationString, int participantsSize) {
        return new Compensations(Arrays.asList(compensationString.split(",")), participantsSize);
    }

    public List<String> getCompensations() {
        return compensations;
    }

    private static void checkCompensationsSize(List<String> compensations, int participantsSize) {
        if (compensations.size() != participantsSize) {
            throw new IllegalArgumentException("보상과 참가자 수가 다릅니다.");
        }
    }
}
