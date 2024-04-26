package laddergame.domain;

import java.util.List;

public class Participates {

    private final int NAME_MAX_LENGTH = 5;
    private final List<String> participates;

    public Participates(List<String> participates) {
        validate_name(participates);
        this.participates = participates;

    }

    private void validate_name(List<String> participates) {
        for (String participate : participates) {
            if (participate.length() > NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(
                    String.format("이름은 최대 %d글자까지 부여할 수 있습니다.", NAME_MAX_LENGTH));
            }
        }
    }

    public int countParticipants() {
        return participates.size();
    }

    public List<String> getParticipates() {
        return participates;
    }
}
