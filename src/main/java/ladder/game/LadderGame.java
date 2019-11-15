package ladder.game;

import ladder.structure.Ladder;
import ladder.structure.LineOfLadder;
import ladder.structure.connection.ConnectionStrategy;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private Ladder ladder;
    private Participants participants;
    private Prizes prizes;

    public LadderGame(String inputParticipant, int ladderHeight, ConnectionStrategy connectionStrategy, String inputResults) {
        this.participants = Participants.of(inputParticipant);
        this.ladder = new Ladder(this.participants.size(), ladderHeight, connectionStrategy);
        this.prizes = Prizes.of(inputResults, this.participants.size());
    }

    public List<LineOfLadder> getLadder() {
        return ladder.getLadder();
    }

    public List<String> getParticipants() {
        return participants.getNames();
    }

    public List<String> getPrizes() {
        return prizes.getResult();
    }


    public Map<String, String> getResult(String... users) {
        Map<String, String> result = new LinkedHashMap<>();
        List<Integer> finalPoints = ladder.getFinalPoints();
        List<String> prizes = getPrizes();

        for (String user : users) {
            int index = participants.indexOf(user);
            result.put(user, prizes.get(finalPoints.get(index)));
        }
        return result;
    }
}
