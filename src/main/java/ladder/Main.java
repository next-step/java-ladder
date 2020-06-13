package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participant;
import ladder.domain.ParticipantGenerator;
import ladder.view.LadderView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        LadderView ladderView = new LadderView();
        StringInputScanner stringInputScanner = new StringInputScanner();
        NumberInputScanner numberInputScanner = new NumberInputScanner();

        ladderView.printAskParticipantName();
        List<String> participantNames = stringInputScanner.getNames();

        ParticipantGenerator participantGenerator = new ParticipantGenerator(participantNames);
        List<Participant> participantList = participantGenerator.getParticipants();

        ladderView.printAskLadderHeight();
        int ladderHeight = numberInputScanner.getNumber();

        Ladder ladder = new Ladder(participantList, ladderHeight);
        ladder.makeLadder();

        ladderView.printLadder(participantNames, ladder.getLines());

    }

}
