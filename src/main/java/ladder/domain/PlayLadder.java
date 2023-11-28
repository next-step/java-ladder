package ladder.domain;

import java.util.Collections;
import java.util.List;

public class PlayLadder {
    private final Players players;
    private final Prizes prizes;
    private final Ladder ladder;

    public PlayLadder(Players players, Prizes prizes, Ladder ladder) {
        validate(players, prizes);
        this.players = players;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    private void validate(Players players, Prizes prizes) {
        if (players.size() != prizes.size()) {
            throw new IllegalArgumentException("참가자 수와 당첨결과 수는 같아야 합니다.");
        }
    }

    public static PlayLadder of(Players players, Prizes prizes, Ladder ladder) {
        return new PlayLadder(players, prizes, ladder);
    }

    public void moving() {
        for (Player player : players()) {
            int playerPosition = players().indexOf(player);

            for (Line line : ladder()) {
                List<Boolean> paths = line.paths();

                int leftPosition = playerPosition - 1;
                int rightPosition = playerPosition;


                if(leftPosition >= 0){
                    boolean previousPath = paths.get(leftPosition);
                    if(previousPath){
                        playerPosition = playerPosition - 1;
                    }
                }

                if(rightPosition < paths.size()) {
                    boolean nextPath = paths.get(rightPosition);
                    if(nextPath){
                        playerPosition = playerPosition + 1;
                    }
                }
            }

            System.out.println("playerPosition = " + playerPosition);
            Prize prize = prizes.prizes().get(playerPosition);
            System.out.println("player.name() = " + player.name());
            System.out.println("prize = " + prize.value());
            System.out.println("-----------------------------------------------------------------------------------------------");
        }
    }

    public List<Player> players() {
        return Collections.unmodifiableList(players.players());
    }

    public List<Line> ladder() {
        return ladder.ladder();
    }

    public List<Prize> prizes() {
        return prizes.prizes();
    }

    public long lengthMax() {
        if(players.lengthMax() < prizes.lengthMax()){
            return prizes.lengthMax();
        }
        return players.lengthMax();
    }
}
