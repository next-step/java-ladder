package nextstep.step4.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-30 04:19
 */
public class Ladder {
    private static final String CREATE_LIST_SIZE_EXCEPTION_MESSAGE = "사다리가 비어있습니다.";
    public static final int INIT_INDEX = 0;

    private List<LadderLine> ladder;

    public Ladder(List<LadderLine> ladder) {
        if (ladder == null || ladder.isEmpty()) {
            throw new IllegalArgumentException(CREATE_LIST_SIZE_EXCEPTION_MESSAGE);
        }
        this.ladder = ladder;
    }

    public int execute(int startIndex) {
        int endIndex = startIndex;
        for (LadderLine ladderLine : ladder) {
            endIndex = ladderLine.moveLine(endIndex);
        }
        return endIndex;
    }

    public Stream<LadderLine> stream() {
        return ladder.stream();
    }

    public Map<Name, Prize> play(Participant participant, PrizeInfo prizeInfo) {
        Map<Name, Prize> playResult = new HashMap<>();

        for (int startIndex = INIT_INDEX; startIndex < participant.count(); startIndex++) {
            Name sourceName = findNameByIndex(participant, startIndex);
            Prize targetPrize = findPrizeByIndex(prizeInfo, execute(startIndex));

            playResult.put(sourceName, targetPrize);
        }
        return playResult;
    }

    private Name findNameByIndex(Participant participant, int startIndex) {
        return participant.stream()
                .filter(name -> participant.matchAttribute(name, startIndex))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private Prize findPrizeByIndex(PrizeInfo prizeInfo, int endIndex) {
        return prizeInfo.stream()
                .filter(prize -> prizeInfo.matchAttribute(prize, endIndex))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}