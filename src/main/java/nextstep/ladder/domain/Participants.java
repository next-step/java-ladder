package nextstep.ladder.domain;

import nextstep.ladder.exception.NotFoundException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> players;
    private static final AtomicInteger sequence = new AtomicInteger(0);

    public Participants(String names) {
        this(Arrays.stream(names.split(","))
                .map(name -> Participant.nameOf(name, sequence.getAndIncrement())).collect(Collectors.toList()));
    }

    public Participants(List<Participant> players) {
        this.players = players;
    }

    public Participant getParticipantByName(String inputName) {
        return validateInputName(inputName);
    }

    private Participant validateInputName(String inputName) {
        return players.stream().filter(participant -> participant.getName().equals(inputName.trim()))
                .findAny()
                .orElseThrow(() -> new NotFoundException("입력하신 이름과 일치하는 참가자가 없습니다."));
    }

    public Participant getParticipantByPosition(int position) {
        return players.stream()
                .filter(player -> player.getPosition() == position)
                .findAny().orElseThrow(() -> new NotFoundException("해당하는 위치의 참가자가 없습니다."));
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(players);
    }

    public int count() {
        return this.players.size();
    }

    @Override
    public String toString() {
        return "Participants{" +
                "players=" + players +
                '}';
    }
}
