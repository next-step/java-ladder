package laddergame.dto;

import laddergame.domain.Ladder;
import laddergame.domain.LadderGameReward;
import laddergame.domain.ParticipantName;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderGameResult {

    private final LadderDto ladder;
    private final Map<String, String> rewardByName;

    public LadderGameResult(LadderDto ladder, Map<String, String> rewardByName) {
        this.ladder = ladder;
        this.rewardByName = rewardByName;
    }

    public static LadderGameResult of(Ladder ladder, Map<ParticipantName, LadderGameReward> rewardByName) {
        LadderDto ladderDto = LadderDto.from(ladder);
        Map<String, String> rewardByNameDto = rewardByName.keySet()
                .stream()
                .collect(Collectors.toMap(
                        ParticipantName::toString,
                        participantName -> rewardByName.get(participantName).toString()
                ));
        return new LadderGameResult(ladderDto, rewardByNameDto);
    }

    public LadderDto getLadder() {
        return ladder;
    }

    public Map<String, String> getRewardByName() {
        return rewardByName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGameResult that = (LadderGameResult) o;
        return Objects.equals(ladder, that.ladder) && Objects.equals(rewardByName, that.rewardByName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder, rewardByName);
    }

    @Override
    public String toString() {
        return "LadderGameResult{" +
                "ladder=" + ladder +
                ", rewardByName=" + rewardByName +
                '}';
    }

}
