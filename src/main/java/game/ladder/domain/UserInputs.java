package game.ladder.domain;

import spark.utils.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputs {
    private final Participants participants;
    private final Expects expects;

    public UserInputs(Participants participants, Expects expects) {
        Assert.isTrue(participants.size() == expects.size(), "참여자와 기대결과의 수는 같아야 합니다.");
        this.participants = participants;
        this.expects = expects;
    }

    public int partipantsSize() {
        return this.participants.size();
    }

    public int expectsSize() {
        return this.expects.size();
    }

    public String getStringParticipantsNames() {
        return participants.getAllFormattedNames();
    }

    public String getStringExpects() {
        return expects.getStringExpects();
    }

    public GameResults makeGameResults(Name name, LadderLines lines) {
        List<GameResult> gameResults = makeGameResultList(name, lines);

        return new GameResults(gameResults);
    }

    private List<GameResult> makeGameResultList(Name name, LadderLines lines) {
        if(name.equals(Name.ALL)) {
            return makeAllGameResult(lines);
        }

        return getExpectList(name, lines).stream().map(expect -> new GameResult(name, expect)).collect(Collectors.toList());
    }

    private List<GameResult> makeAllGameResult(LadderLines lines) {
        List<GameResult> gameResultList = new ArrayList<>();

        for (Name name : this.participants.getAllNames()) {
            List<GameResult> list = makeGameResultList(name, lines);
            gameResultList.addAll(list);
        }

        return gameResultList;
    }

    private List<Expect> getExpectList(Name name, LadderLines lines) {
        List<Position> positions = participants.getPositions(name);
        List<Position> resultPositions = positions.stream().map(lines::computeResultPosition).collect(Collectors.toList());

        return resultPositions.stream().map(this.expects::getExpect).collect(Collectors.toList());
    }

}
