package nextstep.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {
    private final Bonuses bonuses;
    private final Participants participants;
    private final Ladder ladder;

    public LadderGame(Bonuses bonuses, Participants participants, Ladder ladder) {
        this.bonuses = bonuses;
        this.participants = participants;
        this.ladder = ladder;
    }

    /**
     * 모든 참가자의 게임 결과를 계산하여 LadderResult로 반환
     */
    public LadderResult play() {
        // insertion order를 유지하기 위해 LinkedHashMap 사용
        Map<Participant, Bonus> resultMap = participants.unmodifiableNames().stream()
            .collect(Collectors.toMap(
                p -> p,
                p -> bonuses.getBonusByPosition(ladder.play(p.getPosition())).orElseThrow(IllegalArgumentException::new),
                (existing, replacement) -> existing,
                LinkedHashMap::new
            ));
        return new LadderResult(resultMap);
    }

}
