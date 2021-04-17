package nextstep.ladder;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final static int MIN_LENGTH = 0;
    private final List<LadderLine> ladderLines;
    private final int sizeOfPlayers;

    private Ladder(int sizeOfPlayers, int ladderHeight) {
        validation(sizeOfPlayers, ladderHeight);
        this.ladderLines = createLadderLines(sizeOfPlayers, ladderHeight);
        this.sizeOfPlayers = sizeOfPlayers;
    }

    private void validation(int sizeOfPlayer, int ladderHeight) {
        if (sizeOfPlayer <= MIN_LENGTH || ladderHeight <= MIN_LENGTH) {
            throw new IllegalArgumentException("참가자 인원 또는 사다리의 높이는 0과 같거나 작을수 없습니다.");
        }
    }

    public static Ladder of(int sizeOfPlayer, int ladderHeight) {
        return new Ladder(sizeOfPlayer, ladderHeight);
    }

    private List<LadderLine> createLadderLines(int sizeOfPlayer, int ladderHeight) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(idx -> LadderLine.init(sizeOfPlayer))
                .collect(Collectors.toList());
    }

    public int lastLadderPosition(int position) {
        for (LadderLine ladderLine : ladderLines) {
            position = ladderLine.move(position);
        }
        return position;
    }

    public List<LadderLine> ladderLines() {
        return Collections.unmodifiableList(ladderLines);
    }

    public int sizeOfPlayers() {
        return sizeOfPlayers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(ladderLines, ladder.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "ladderLines=" + ladderLines +
                '}';
    }
}
