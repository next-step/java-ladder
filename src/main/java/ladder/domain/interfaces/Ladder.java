package ladder.domain.interfaces;

public interface Ladder {
    Lines getLines();

    Players getPlayers();

    Results results(Rewards rewards);
}
