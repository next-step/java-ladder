package laddarGame.domain;

import laddarGame.dto.LineDto;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//각 사다리 라인을 관리하는 일급컬렉션
public class Lines {

    private final List<Line> lines;

    public Lines(int playerCount, int ladderHeight) {
        this(createLines(playerCount, ladderHeight));
    }

    public static List<Line> createLines(int playerCount, int ladderHeight) {
        return Stream.generate(() -> new Line(playerCount))
                .limit(ladderHeight)
                .collect(toList());
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public List<LineDto> linesDto() {
        return lines.stream()
                .map(Line::lineDto)
                .collect(toList());
    }

    public Players play(Players players) {
        lines.forEach(line -> line.move(players));
        return players;
    }
}
