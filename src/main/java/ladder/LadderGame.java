package ladder;

public class LadderGame {

    public static void main(String[] args) {
        LadderInitializer initializer = new LadderInitializer();
        LadderGameData gameData = initializer.init();

        LadderGamePlayer gamePlayer = new LadderGamePlayer();
        gamePlayer.play(gameData);
    }
}
