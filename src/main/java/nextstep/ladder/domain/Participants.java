package nextstep.ladder.domain;

import java.util.*;

public class Participants {
    public static final String TOO_FEW_PARTICIPANTS_MESSAGE = "참여자는 2명 이상이어야 합니다.";
    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.valid(participants);
        this.participants = participants;
    }

    private void valid(List<Participant> participants) {
        if (participants == null || participants.size() < 2) {
            throw new IllegalArgumentException(TOO_FEW_PARTICIPANTS_MESSAGE);
        }
    }

    public void move(Ladder ladder) {
        ladder.getLines().forEach(this::updatePositions);
    }

    private void updatePositions(LadderLine line) {
        participants.forEach(participant -> {
            participant.move(line);
        });
    }

    public Map<Name, Name> matchResults(List<Name> results) {
        Map<Name, Name> matchResults = new HashMap<>();
        participants.forEach(participant -> {
            matchResults.put(participant.name(), results.get(participant.position()));
        });
        return matchResults;
    }

    public static Participants fromNames(List<Name> names) {
        List<Participant> participants = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            participants.add(new Participant(names.get(i), i));
        }

        return new Participants(participants);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Participants that = (Participants) o;
        return Objects.equals(participants, that.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(participants);
    }
}
