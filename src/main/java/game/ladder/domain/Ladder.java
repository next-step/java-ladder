package game.ladder.domain;

import spark.utils.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final Participants participants;
    private final Expects expects;
    private final Lines lines;

    public Ladder(LinesGenerator generator, Participants participants, Expects expects) {
        Assert.isTrue(participants.size() == expects.size(), "참여자와 기대결과의 수는 같아야 합니다.");
        this.participants = participants;
        this.expects = expects;
        this.lines = generator.generate(participants.size());
    }

    public String makeStringLadder() {
        StringBuilder sb = new StringBuilder();
        sb.append(participants.getAllFormattedNames()).append(System.lineSeparator());
        sb.append(lines.getStringLines()).append(System.lineSeparator());
        sb.append(expects.getStringExpects());

        return sb.toString();
    }

    public GameResults makeGameResults(Name name) {
        List<GameResult> gameResults = makeGameResultList(name);

        return new GameResults(gameResults);
    }

    private List<GameResult> makeGameResultList(Name name) {
        if(name.equals(Name.ALL)) {
            return makeAllGameResult();
        }

        return getExpectList(name).stream().map(expect -> new GameResult(name, expect)).collect(Collectors.toList());
    }

    private List<GameResult> makeAllGameResult() {
        List<GameResult> gameResultList = new ArrayList<>();

        for (Name name : this.participants.getAllNames()) {
            List<GameResult> list = makeGameResultList(name);
            gameResultList.addAll(list);
        }

        return gameResultList;
    }

    private List<Expect> getExpectList(Name name) {
        List<Position> positions = participants.getPositions(name);
        List<Position> resultPositions = positions.stream().map(this.lines::computeResultPosition).collect(Collectors.toList());

        return resultPositions.stream().map(this.expects::getExpect).collect(Collectors.toList());
    }


}
