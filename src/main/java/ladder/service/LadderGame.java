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

    public LadderGame(String[] names, int height) {
        this.setPlayer(names);
        this.setHeight(height);
    }

    public LadderGame(String[] names, String[] results, int height) {
        this(names, height);
        this.setResult(results);
    }

    private void setPlayer(String[] names) {
        this.players = new Players(names);
    }

    private void setHeight(int height) {
        this.height = height;
        this.ladder = new Ladder();
    }

    private void setResult(String[] result) {
        this.results =  new Results(result);
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
                    .map(player -> {
                        return player.getName() + " : " + getValue(player.getName());
                    }).collect(Collectors.joining("\n"));

        }

        return getValue(name);
    }

    private String getValue(String name) {
        return results.list()
                .get(ladder.end(players.playerSequence(name)))
                .value();
    }

}
