package ladder.game;

import ladder.structure.Ladder;
import ladder.structure.connection.ConnectionStrategy;

import java.util.*;

public class LadderGame {
    private Ladder ladder;
    private Participants participants;
    private Results results;
    private Map<String, String> gameResult;

    public LadderGame(String inputParticipant, int ladderHeight, ConnectionStrategy connectionStrategy, String inputResults) {
        this.participants = Participants.of(inputParticipant);
        this.ladder = new Ladder(this.participants.size(), ladderHeight, connectionStrategy);
        this.results = Results.of(inputResults, this.participants.size());
        this.gameResult = getGameResult();
    }

    public LadderDTO getLadder() {
        return new LadderDTO(Collections.unmodifiableList(ladder.getConnectedLine()));
    }

    public List<String> getParticipants() {
        return participants.getNames();
    }

    public List<String> getResults() {
        return results.getResult();
    }

    private Map<String, String> getGameResult() {
        List<Integer> finalPoints = ladder.findFinalPoints();
        List<String> participantsNames = new ArrayList<>(participants.getNames());
        Map<String, String> result = new HashMap<>();
        for (int index = 0; index < participantsNames.size(); index++) {
            result.put(participantsNames.get(index), results.getResult().get(finalPoints.get(index)));
        }
        return result;
    }

    public Map<String, String> getGameResult(String... users) {
        Map<String, String> result = new HashMap<>();

        for (String user : users) {
            String userResult = gameResult.get(user);
            if (userResult == null) {
                throw new IllegalArgumentException("제대로 된 이름을 입력하세요 ");
            }
            result.put(user, userResult);
        }
        return result;
    }
}
