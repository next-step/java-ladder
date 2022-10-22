package laddergame.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private final ParticipantNames participantNames;
    private final List<LadderGameReward> rewards;
    private final Ladder ladder;

    public LadderGame(ParticipantNames participantNames, List<LadderGameReward> rewards, Ladder ladder) {
        validate(participantNames, rewards, ladder);
        this.participantNames = participantNames;
        this.rewards = rewards;
        this.ladder = ladder;
    }

    private void validate(ParticipantNames participantNames, List<LadderGameReward> rewards, Ladder ladder) {
        if (participantNames.size() != rewards.size()) {
            throw new IllegalArgumentException("참가자 이름의 수와 사다리 게임 결과의 수는 같아야 합니다.");
        }
        if (participantNames.size() != ladder.getWidth() + 1) {
            throw new IllegalArgumentException("참가자 이름의 수는 사다리의 가로 길이보다 1 커야 합니다.");
        }
    }


    public Map<ParticipantName, LadderGameReward> calculateRewardByParticipantName() {
        return IntStream.range(0, participantNames.size())
                .boxed()
                .collect(Collectors.toMap(
                        participantNames::get,
                        i -> rewards.get(ladder.moveToLastLine(i))
                ));
    }

    public ParticipantNames getParticipantNames() {
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
