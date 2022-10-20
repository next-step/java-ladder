package laddergame.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private final List<ParticipantName> participantNames;
    private final List<LadderGameReward> rewards;
    private final Ladder ladder;

    public LadderGame(List<ParticipantName> participantNames, List<LadderGameReward> rewards, Ladder ladder) {
        validate(participantNames, rewards, ladder);
        this.participantNames = participantNames;
        this.rewards = rewards;
        this.ladder = ladder;
    }

    private void validate(List<ParticipantName> participantNames, List<LadderGameReward> rewards, Ladder ladder) {
        int sizeOfDistinctParticipantNames = getNumberOfDistinctParticipantNames(participantNames);
        if (sizeOfDistinctParticipantNames != participantNames.size()) {
            throw new IllegalArgumentException("참가자 이름은 중복될 수 없습니다.");
        }
        if (sizeOfDistinctParticipantNames != rewards.size()) {
            throw new IllegalArgumentException("참가자 이름의 수와 사다리 게임 결과의 수는 같아야 합니다.");
        }
        if (sizeOfDistinctParticipantNames != ladder.getWidth() + 1) {
            throw new IllegalArgumentException("참가자 이름의 수는 사다리의 가로 길이보다 1 커야 합니다.");
        }
    }

    private int getNumberOfDistinctParticipantNames(List<ParticipantName> participantNames) {
        return (int) participantNames.stream()
                .distinct()
                .count();
    }

    public Map<ParticipantName, LadderGameReward> calculateRewardByParticipantName() {
        return IntStream.range(0, participantNames.size())
                .boxed()
                .collect(Collectors.toMap(
                        participantNames::get,
                        i -> rewards.get(ladder.moveToLastLine(i))
                ));
    }

    public List<ParticipantName> getParticipantNames() {
        return participantNames;
    }

    public List<LadderGameReward> getRewards() {
        return rewards;
    }

    public Ladder getLadder() {
        return ladder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGame that = (LadderGame) o;
        return Objects.equals(participantNames, that.participantNames) && Objects.equals(rewards, that.rewards) && Objects.equals(ladder, that.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantNames, rewards, ladder);
    }

    @Override
    public String toString() {
        return "LadderGame{" +
                "participantNames=" + participantNames +
                ", rewards=" + rewards +
                ", ladder=" + ladder +
                '}';
    }

}
