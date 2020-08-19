package ladder.domain.core.line;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static ladder.domain.core.line.Participant.verifyBlankName;

public class Participants {
    private static final String SEPARATOR = ",";
    private final List<Participant> participants;

    Participants(String participants) {
        verifyBlankName(participants);
        List<Participant> participantList = Stream.of(participants.split(SEPARATOR))
                                                  .map(Participant::new)
                                                  .collect(toList())
            ;
        this.participants = Collections.unmodifiableList(participantList);
    }

    static Participants of(String participants) {
        return new Participants(participants);
    }

    int indexOf(String name) {
        return participants.indexOf(new Participant(name));
    }

    int getCount() {
        return participants.size();
    }

    List<String> names(){
        return participants.stream()
                           .map(Participant::getName)
                           .collect(toList());
    }

    String get(int index) {
        return participants.get(index)
                           .getName();
    }
}
