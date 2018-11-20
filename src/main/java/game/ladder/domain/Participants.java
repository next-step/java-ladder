package game.ladder.domain;

import spark.utils.Assert;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Participants {

    private static final int MIN_PARTICIPANTS = 2;

    private final Map<Name, List<Participant>> participants;
    private final int size;

    public Participants(SortedSet<Participant> participants) {
        Assert.isTrue(participants.size() >= MIN_PARTICIPANTS, "적어도 두 명 이상의 참여자가 필요합니다.");
        this.size = participants.size();
        this.participants = participants.stream().collect(
                Collectors.groupingBy(
                        Participant::getName, LinkedHashMap::new, Collectors.mapping(Function.identity(), Collectors.toList())
                )
        );
    }

    public int size() {
        return this.size;
    }

    public String getAllFormattedNames() {
        return this.participants.values().stream().flatMap(list -> list.stream())
                .map(Participant::formattedParticipantName).collect(Collectors.joining());
    }

    public List<Name> getAllNames() {
        return Collections.unmodifiableList(new ArrayList<>(this.participants.keySet()));
    }

    public List<Position> getPositions(Name name) {
        if (!this.participants.containsKey(name)) {
            throw new IllegalArgumentException("존재하지 않는 이름 입니다.");
        }

        return this.participants.get(name).stream().map(Participant::getPosition).collect(Collectors.toList());
    }
}
