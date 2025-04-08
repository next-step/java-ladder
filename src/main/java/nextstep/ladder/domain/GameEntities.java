package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameEntities {
    private final List<Participant> participants;
    private final List<Reward> rewards;

    public GameEntities(List<Participant> participants, List<Reward> rewards) {
        validate(participants, rewards);
        this.participants = new ArrayList<>(participants);
        this.rewards = new ArrayList<>(rewards);
    }

    private void validate(List<Participant> participants, List<Reward> rewards) {
        if (participants.size() != rewards.size()) {
            throw new RuntimeException("사용자 수와 보상의 수는 같아야 합니다.");
        }
    }

    public static GameEntities from(List<String> participantNames, List<String> rewardNames) {
        List<Participant> participants = participantNames.stream()
                .map(Participant::new)
                .collect(Collectors.toList());

        List<Reward> rewards = rewardNames.stream()
                .map(Reward::new)
                .collect(Collectors.toList());
        return new GameEntities(participants, rewards);
    }

    public int findParticipantPositionByParticipantName(String participantName) {
        return IntStream.range(0, participants.size())
                .filter(i -> participants.get(i).hasName(participantName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("일치하는 참가자가 없습니다."));
    }

    public Reward findRewardByPosition(int rewardPosition) {
        return rewards.get(rewardPosition);
    }


    public int size() {
        return this.participants.size();
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }
}