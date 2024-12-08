package ladder.domain.engine;

public interface Ladder {
    Lines getLines();

    Players getPlayers();

    Results playResults(Rewards rewards);
}
