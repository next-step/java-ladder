package ladder.service;

import ladder.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    public static final String COMMA =",";
    private Players players;
    private Ladder ladder;
    private Results results;

    private int height;

    private LadderGame(Players players, Ladder ladder, Results results, int height) {
        this.players = players;
        this.ladder = ladder;
        this.results = results;
        this.height = height;
    }

    public LadderGame(String[] names, String[] results, int height) {
        this(new Players(names), new Ladder(), new Results(results), height);
    }

    public Players getPlayers() {
        return players;
    }

    public void makeLine() {
        ladder.makeLine(players.size(), height);
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }

    public List<Result> getResults() {return results.list();}

    public String result(String name){
        if(name.equals("all")){
            return players.getPlayers().stream()
                    .map(player -> player.getName() + " : " + getValue(player.getName()))
                    .collect(Collectors.joining("\n"));

        }
        return getValue(name);
    }

    private String getValue(String name) {
        return results.list()
                .get(ladder.end(players.playerSequence(name)))
                .value();
    }

}
