package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {

    private static final String RESULT_ALL = "all";

    private final Map<Participant, String> result = new LinkedHashMap<>();

    public LadderResult(Ladder ladder, Participants participants, Rewards rewards) {
        if (participants.countOfParticipants() != rewards.size()) {
            throw new IllegalArgumentException("참여자 수와 실행 결과 수는 같아야 한다.");
        }

        initResult(ladder, participants, rewards);
    }

    private void initResult(Ladder ladder, Participants participants, Rewards rewards) {
        for (Participant participant : participants.getParticipants()) {
            int finalIndex = ladder.goingDown(participants.indexOf(participant));
            result.put(participant, rewards.get(finalIndex));
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

        for (Map.Entry<Participant, String> each : result.entrySet()) {
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
        if (!result.containsKey(target)) {
            throw new IllegalArgumentException("참여자 중 선택해야한다.");
        }

        return result.get(target);
    }

}
