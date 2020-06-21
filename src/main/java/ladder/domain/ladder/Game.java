package ladder.domain.ladder;

import ladder.domain.play.Playing;

public class Game {
    private final Playing playing;
    private final Ladder ladder;

    private Game(Playing playing, int height) {
        this.playing = playing;
        this.ladder = Ladder.of(height, playing.getCountOfPlayers());
    }

    public static Game play(Playing playing, int height) {
        return new Game(playing, height);
    }

    @Override
    public String toString() {
        return this.playing.getPlayers().toString() +
                "\n" +
                this.ladder.toString() +
                "\n" +
                this.playing.getResults().toString();
    }
}
