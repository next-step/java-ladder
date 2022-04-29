package nextstep.ladder.view.dto;

import nextstep.ladder.model.Participant;
import nextstep.ladder.model.Participants;

import java.util.List;
import java.util.stream.Collectors;

public final class NamesResponse {

    private final List<String> names;

    private NamesResponse(List<String> names) {
        this.names = names;
    }

    public static NamesResponse from(Participants participants) {
        return new NamesResponse(participants.list()
                .stream()
                .map(Participant::value)
                .collect(Collectors.toList()));
    }

    public List<String> getNames() {
        return names;
    }
}
