package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.LinePoints;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.PlayerPrizes;
import nextstep.ladder.domain.point.RandomPointGenerator;

public class Ladder {

    private List<Line> lines;
    private int sizeOfPerson;

    Ladder(List<Line> lines, int sizeOfPerson) {
        validate(lines, sizeOfPerson);
        this.lines = lines;
        this.sizeOfPerson = sizeOfPerson;
    }

    public static Ladder of(int height, int countOfPerson) {
        List<Line> lines = Stream.generate(() -> new Line(
            LinePoints.of(countOfPerson, new RandomPointGenerator())))
            .limit(height)
            .collect(Collectors.toList());

        return new Ladder(lines, countOfPerson);
    }

    private void validate(List<Line> lines, int sizeOfPerson) {
        if (lines.size() < 1) {
            throw new IllegalArgumentException("min height is 1");
        }

        if (sizeOfPerson < 2) {
            throw new IllegalArgumentException("min size Of Person is 2");
        }
    }

    public List<Line> getLines() {
        return new ArrayList<>(this.lines);
    }

    public PlayerPrizes play(List<Player> players, List<String> prizes) {
        if(players.size() != sizeOfPerson){
            throw new IllegalArgumentException("invalid players");
        }

        if(players.size() != prizes.size()){
            throw new IllegalArgumentException("invalid prize");
        }

        Map<Player, String> playerPrizes = new LinkedHashMap<>();
        for(int playerPosition = 0;  playerPosition < sizeOfPerson ; playerPosition++){
            String prize = prizes.get(play(playerPosition));
            playerPrizes.put(players.get(playerPosition), prize);
        }

        return new PlayerPrizes(playerPrizes);
    }

    private int play(int position) {
        for (Line line : this.lines) {
            position = line.move(position);
        }
        return position;
    }
}
