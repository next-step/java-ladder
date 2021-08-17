package step4.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> ladderLines;

    private final Participants participants;

    private static final int MAX_NAME_LENGTH = 5;

    private static final int MIN_HEIGHT = 1;

    private static final int MIN_PARTICIPANTS = 1;

    public Ladder(List<LadderLine> ladderLines, List<String> names) {
        this.ladderLines = ladderLines;
        this.participants = Participants.of(names);
    }

    public static Ladder create(List<String> names, int height) {
        validateNames(names);
        validateHeight(height);
        List<LadderLine> lines = createLines(height, names.size());
        return new Ladder(lines, names);
    }

    private static void validateNames(List<String> names) {
        for (String name : names) {
            validateNamesLength(name);
        }

        if (lessThanMinParticipants(names.size())) {
            throw new RuntimeException("참여자는 최소 1명 이상이여야 합니다.");
        }
    }

    private static void validateNamesLength(String name) {
        if (moreThanMaxNameLength(name.length())) {
            throw new RuntimeException("이름의 글자는 최대 5자리를 넘을 수 없습니다.");
        }
    }

    private static boolean moreThanMaxNameLength(int size) {
        return size > MAX_NAME_LENGTH;
    }

    private static boolean lessThanMinParticipants(int size) {
        return size < MIN_PARTICIPANTS;
    }

    private static void validateHeight(int height) {
        if (heightIsNotAvailable(height)) {
            throw new RuntimeException("사다리의 높이는 양수여야 합니다.");
        }
    }

    private static boolean heightIsNotAvailable(int height) {
        return height < MIN_HEIGHT;
    }

    private static List<LadderLine> createLines(int height, int size) {
        return IntStream.range(0, height)
            .mapToObj(value -> LadderLine.of(size))
            .collect(Collectors.toList());
    }

    public List<String> inlineParticipants() {
        return participants.inline();
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }

    public int getLadderWidth() {
        return participants.size();
    }

    public int findPositionOf(String name) {
        return participants.findPositionOf(name);
    }

    public int move(int position) {
        for (LadderLine ladderLine : ladderLines) {
            position = ladderLine.move(position);
        }
        return position;
    }
}
