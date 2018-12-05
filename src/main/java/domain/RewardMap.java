package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class RewardMap {

    private static final String RESULT_ALL = "all";

    private final Participants participants;
    private final Rewards rewards;
    private final Map<Participant, String> rewardMap = new LinkedHashMap<>();

    public RewardMap(Participants participants, Rewards rewards) {
        this.participants = participants;
        this.rewards = rewards;
    }

    public void initMapFromResult(PlayResults results) {
        for (PlayResult result : results.getResults()) {
            Map.Entry<Participant, String> entry = result.getEntry(participants, rewards);
            rewardMap.put(entry.getKey(), entry.getValue());
        }
    }

    public String viewResult(String name) {
        if (isAll(name)) {
            return allResult();
        }

        return singleResult(name);
    }

    private boolean isAll(String name) {
        return RESULT_ALL.equals(name);
    }

    private String allResult() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Participant, String> each : rewardMap.entrySet()) {
            stringBuilder
                .append(each.getKey().toString())
                .append(" : ")
                .append(each.getValue())
                .append("\n");
        }

        return stringBuilder.toString();
    }

    private String singleResult(String name) {
        Participant target = new Participant(name);
        if (!rewardMap.containsKey(target)) {
            throw new IllegalArgumentException("참여자 중 선택해야한다.");
        }

        return rewardMap.get(target);
    }
}
