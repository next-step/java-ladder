package laddergame.dto;

import laddergame.domain.LadderGame;
import laddergame.domain.LadderGameReward;
import laddergame.domain.ParticipantName;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderGameDto {

    private final List<String> participantNames;
    private final List<String> rewards;
    private final LadderDto ladder;

    public LadderGameDto(List<String> participantNames, List<String> rewards, LadderDto ladder) {
        this.participantNames = participantNames;
        this.rewards = rewards;
        this.ladder = ladder;
    }

    public static LadderGameDto from(LadderGame ladderGame) {
        List<String> participantNameValues = ladderGame.getParticipantNames()
                .stream()
                .map(ParticipantName::toString)
                .collect(Collectors.toList());
        List<String> rewardValues = ladderGame.getRewards()
                .stream()
                .map(LadderGameReward::toString)
                .collect(Collectors.toList());
        LadderDto ladderDto = LadderDto.from(ladderGame.getLadder());
        return new LadderGameDto(participantNameValues, rewardValues, ladderDto);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGameDto that = (LadderGameDto) o;
        return Objects.equals(participantNames, that.participantNames) && Objects.equals(rewards, that.rewards) && Objects.equals(ladder, that.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantNames, rewards, ladder);
    }

    @Override
    public String toString() {
        return "LadderGameState{" +
                "participantNames=" + participantNames +
                ", rewards=" + rewards +
                ", ladder=" + ladder +
                '}';
    }

}
