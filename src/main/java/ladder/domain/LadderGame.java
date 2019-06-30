package ladder.domain;

public class LadderGame {
    Players players;
    Ladder ladder;

    public LadderGame(String players, int heightOfLadder) {
        this.players = new Players(players);
        this.ladder = LadderGenerator.ladderGenerator(heightOfLadder, this.players.size());
    }
}
