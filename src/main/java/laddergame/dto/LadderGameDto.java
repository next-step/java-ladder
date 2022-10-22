package laddergame.dto;

import laddergame.domain.LadderGame;
import laddergame.domain.LadderGameReward;
import laddergame.domain.ParticipantNames;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        List<String> participantNameValues = getParticipantNameValues(ladderGame.getParticipantNames());
        List<String> rewardValues = ladderGame.getRewards()
                .stream()
                .map(LadderGameReward::toString)
                .collect(Collectors.toList());
        LadderDto ladderDto = LadderDto.from(ladderGame.getLadder());
        return new LadderGameDto(participantNameValues, rewardValues, ladderDto);
    }

    private static List<String> getParticipantNameValues(ParticipantNames participantNames) {
        return IntStream.range(0, participantNames.size())
                .mapToObj(i -> participantNames.get(i).toString())
                .collect(Collectors.toList());
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
