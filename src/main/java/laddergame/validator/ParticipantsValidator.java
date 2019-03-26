package laddergame.validator;

import laddergame.domain.Participant;

import java.util.Set;

public class ParticipantsValidator implements Validatable<Set<Participant>> {

    @Override
    public boolean isValid(Set<Participant> target) {
        return target != null && target.size() >= 2;
    }

    @Override
    public String getInvalidMessage() {
        return "참가자는 2인 이상이어야 합니다.";
    }

}