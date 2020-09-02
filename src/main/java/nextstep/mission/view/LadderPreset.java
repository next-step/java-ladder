package nextstep.mission.view;

import nextstep.mission.domain.Ladder;
import nextstep.mission.domain.Participants;

import java.util.Collections;
import java.util.List;

public class LadderPreset {
    private final Participants participants;
    private final Ladder ladder;
    private final List<String> results;

    private LadderPreset(Participants participants, Ladder ladder, List<String> results) {
        this.participants = participants;
        this.ladder = ladder;
        this.results = results;
    }

    public static LadderPreset of(Participants participants, Ladder ladder, List<String> results) {
        return new LadderPreset(participants, ladder, results);
    }

    public Participants getParticipants() {
        return participants;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(results);
    }
}
