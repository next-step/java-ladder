package ladder.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participant {

    private static final int MIN_NAME_LENGTH = 5;
    private static final int MIN_PARTICIPANTS = 2;
    private static final String ILLEGAL_NUMBER_OF_PARTICIPANTS = "참가자 수가 유효하지 않습니다.";
    private static final String ILLEGAL_NAME = "유효하지 않은 이름입니다.";
    private final String name;

    private Participant(String name) {
        this.name = checkName(name);
    }

    public static Participant of(String name) {
        return new Participant(name);
    }

    public static List<Participant> ofNameList(List<String> participantNameList) {
        if (participantNameList.size() < MIN_PARTICIPANTS) {
            throw new IllegalArgumentException(ILLEGAL_NUMBER_OF_PARTICIPANTS);
        }
        return participantNameList.stream()
            .map(Participant::of)
            .collect(Collectors.toList());
    }

    private String checkName(String name) {
        if (name == null || name.equals("") || name.length() > MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(ILLEGAL_NAME);
        }

        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Participant that = (Participant) o;

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
