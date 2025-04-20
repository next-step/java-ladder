package nextstep.ladder.domain;

import java.util.*;

public class Ladder {
    public static final String INVALID_LADDER_SIZE_MESSAGE = "사다리 사이즈(높이,가로사이즈)는 1 이상이어야 합니다.";
    public static final String NOT_ALL_MATCH_LADDER_SIZE = "사다리 라인의 크기는 동일해야 합니다.";
    public static final String NOT_MATCH_PARTICIPANTS_REWARDS_COUNT = "참가자 수와 결과 수는 같아야 합니다.";
    private final List<LadderLine> lines;

    public Ladder(List<LadderLine> lines) {
        this.validateLadderLines(lines);

        this.lines = lines;
    }

    private void validateLadderLines(List<LadderLine> ladderLines) {
        if (ladderLines.isEmpty()) {
            throw new IllegalArgumentException(INVALID_LADDER_SIZE_MESSAGE);
        }

        LadderLine expectedLadderLine = ladderLines.get(0);
        boolean allMatch = ladderLines.stream()
                .allMatch(ladderLine -> ladderLine.sameSize(expectedLadderLine));

        if (!allMatch) {
            throw new IllegalArgumentException(NOT_ALL_MATCH_LADDER_SIZE);
        }
    }

    public List<LadderLine> asList() {
        return lines;
    }

    public LadderResults assignRewards(Participants participants, Rewards rewards) {
        if (participants.size() != rewards.size()) {
            throw new IllegalArgumentException(NOT_MATCH_PARTICIPANTS_REWARDS_COUNT);
        }

        Map<Name, Name> results = new LinkedHashMap<>();
        for (int i = 0; i < participants.size(); i++) {
            int resultIndex = resultPositionOf(i);
            results.put(participants.get(i), rewards.get(resultIndex));
        }
        return new LadderResults(results);
    }

    private int resultPositionOf(int startIndex) {
        int position = startIndex;
        for (LadderLine line : lines) {
            position = line.nextPosition(position);
        }
        return position;
    }

    public static Ladder generate(int height, int ladderLineSize) {
        valid(height, ladderLineSize);
        List<LadderLine> ladderLines = generateLines(height, ladderLineSize);
        return new Ladder(ladderLines);
    }

    private static void valid(int height, int ladderLineSize) {
        if (height < 1 || ladderLineSize < 1) {
            throw new IllegalArgumentException(INVALID_LADDER_SIZE_MESSAGE);
        }
    }

    private static List<LadderLine> generateLines(int height, int ladderLineSize) {
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderLines.add(LadderLine.generate(ladderLineSize));
        }
        return Collections.unmodifiableList(ladderLines);
    }
}
