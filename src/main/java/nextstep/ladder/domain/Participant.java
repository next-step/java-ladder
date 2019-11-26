package nextstep.ladder.domain;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-26 12:23
 */
public class Participant {

    private static final int MINIMUM_MAXIMUM_VALUE = 5;

    private final List<String> participant;

    public Participant(List<String> participant) {
        if (isGreaterThanMaximumValue(participant)) {
            throw new InputMismatchException("이름은 다섯글자 이하로 입력해주세요.");
        }

        if (isDuplicateName(participant)) {
            throw new InputMismatchException("중복된 참가자입니다.");
        }

        this.participant = participant;
    }

    private boolean isGreaterThanMaximumValue(List<String> participant) {
        return participant.stream()
                .anyMatch(name -> name.length() > MINIMUM_MAXIMUM_VALUE);
    }

    private boolean isDuplicateName(List<String> participant) {
        return participant.stream()
                .distinct()
                .count() != participant.size();
    }

    public int numberOfParticipants() {
        return this.participant.size();
    }

    public List<String> getParticipant() {
        return participant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(participant, that.participant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participant);
    }
}
