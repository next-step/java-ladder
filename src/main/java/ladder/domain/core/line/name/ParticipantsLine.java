package ladder.domain.core.line.name;

import java.util.List;
import java.util.stream.Stream;

import ladder.domain.core.line.Line;
import ladder.ui.result.DisplayResult;
import ladder.ui.result.NamesDisplayResult;

import static java.util.stream.Collectors.toList;
import static ladder.domain.core.line.name.BaseName.verifyBlankName;
import static ladder.domain.core.line.name.ParticipantsLine.ParticipantNames.participantNames;

public class ParticipantsLine implements Line {

    private final ParticipantNames names;

    ParticipantsLine(ParticipantNames names) {
        this.names = names;
    }

    public static ParticipantsLine of(String participants) {
        return new ParticipantsLine(participantNames(participants));
    }

    public int getNumberOfParticipants(){
        return names.getCount();
    }

    @Override
    public int indexOf(String name) {
        return names.indexOf(new Participant(name));
    }

    @Override
    public String getResult(int index) {
        return names.get(index);
    }

    @Override
    public DisplayResult toDisplayResult() {
        return new NamesDisplayResult(names);
    }

    static class ParticipantNames extends Names<Participant> {
        private static final String SEPARATOR = ",";

        ParticipantNames(List<Participant> names) {
            super(names);
        }

        static ParticipantNames participantNames(String participants){
            verifyBlankName(participants);

            List<Participant> participantList = Stream.of(participants.split(SEPARATOR))
                                                      .map(Participant::new)
                                                      .collect(toList())
                ;
            return new ParticipantNames(participantList);
        }
    }
}
