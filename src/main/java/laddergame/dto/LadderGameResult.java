package laddergame.dto;

import laddergame.domain.Ladder;
import laddergame.domain.LadderGameReward;
import laddergame.domain.ParticipantName;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderGameResult {

    private final List<String> participantNames;
    private final List<String> rewards;
    private final LadderDto ladder;
    private final Map<String, String> rewardByName;

    public LadderGameResult(List<String> participantNames, List<String> rewards, LadderDto ladder, Map<String, String> rewardByName) {
        this.participantNames = participantNames;
        this.rewards = rewards;
        this.ladder = ladder;
        this.rewardByName = rewardByName;
    }

    public static LadderGameResult of(List<ParticipantName> participantNames, List<LadderGameReward> rewards, Ladder ladder, Map<ParticipantName, LadderGameReward> rewardByName) {
        List<String> participantNameValues = parseParticipantNames(participantNames);
        LadderDto ladderDto = LadderDto.from(ladder);
        List<String> rewardValues = parseLadderGameRewards(rewards);
        Map<String, String> rewardValuesByNameValue = parseLadderGameRewardByParticipantName(rewardByName);
        return new LadderGameResult(participantNameValues, rewardValues, ladderDto, rewardValuesByNameValue);
    }

    private static List<String> parseParticipantNames(List<ParticipantName> participantNames) {
        return participantNames.stream()
                .map(ParticipantName::toString)
                .collect(Collectors.toList());
    }

    private static List<String> parseLadderGameRewards(List<LadderGameReward> rewards) {
        return rewards.stream()
                .map(LadderGameReward::toString)
                .collect(Collectors.toList());
    }

    private static Map<String, String> parseLadderGameRewardByParticipantName(Map<ParticipantName, LadderGameReward> rewardByName) {
        return rewardByName.keySet().stream()
                .collect(Collectors.toMap(
                        ParticipantName::toString,
                        name -> rewardByName.get(name).toString()
                ));
    }

    public List<String> getParticipantNames() {
        return participantNames;
    }

    public List<String> getRewards() {
        return rewards;
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
        return Objects.equals(participantNames, that.participantNames) && Objects.equals(rewards, that.rewards) && Objects.equals(ladder, that.ladder) && Objects.equals(rewardByName, that.rewardByName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantNames, rewards, ladder, rewardByName);
    }

    @Override
    public String toString() {
        return "LadderGameResult{" +
                "participantNames=" + participantNames +
                ", rewards=" + rewards +
                ", ladder=" + ladder +
                ", rewardByName=" + rewardByName +
                '}';
    }

}
