package ladder.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class Result {
    public static final String MESSAGE_OF_NOT_PARTICIPANT_EXCEPTION = "참여하지 않아 결과를 찾을 수 없습니다.";

    private final Map<Participant, Reward> result;

    public Result(Participants participants, Rewards rewards, List<Integer> arrivalIndex) {
        result = new TreeMap<>(Comparator.comparing(Participant::getName));
        for (int i = 0; i < arrivalIndex.size(); i++) {
            final int rewardIndex = arrivalIndex.get(i);
            result.put(participants.getParticipant(i), rewards.getReward(rewardIndex));
        }
    }

    public Map<Participant, Reward> getAllResult() {
        return Collections.unmodifiableMap(result);
    }

    public Participant getParticipant(String nameOfParticipant) {
        return result.keySet().stream()
                     .filter(i -> i.getName().equals(nameOfParticipant))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException(
                             MESSAGE_OF_NOT_PARTICIPANT_EXCEPTION));
    }

    public Reward getReward(Participant participant) {
        Optional<Reward> reward = Optional.ofNullable(result.get(participant));
        return reward.orElseThrow(() -> new IllegalArgumentException(MESSAGE_OF_NOT_PARTICIPANT_EXCEPTION));
    }
}
