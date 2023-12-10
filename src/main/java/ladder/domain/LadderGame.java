package ladder.domain;

import ladder.view.IOView;

public class LadderGame {

    private final Players players;
    private final Ladders ladders;
    private final int height;

    public LadderGame(String[] inputNames, int height) {
        isValidHeight(height);

        this.height = height;
        this.players = new Players(inputNames);
        this.ladders = new Ladders(inputNames.length, height);
    }

    private void isValidHeight(int height) {
        if (height < 0) {
            throw new IllegalArgumentException("사다리 높이는 1보다 작을 수 없습니다.");
        }
    }

    public void play() {
        IOView.printName(this.players.getPlayers());
        IOView.printLadders(this.ladders);
    }

}
