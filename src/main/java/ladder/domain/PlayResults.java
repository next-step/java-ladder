package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayResults {
    private static final int RULE_PLAY_RESULT_MIN_COUNT = 2;
    private List<PlayResult> playResults;

    public PlayResults(List<String> playResults) {
        validate(playResults);
        this.playResults = new ArrayList<>();
        int playersCount = playResults.size();
        for (int i = 0; i < playersCount; i++) {
            this.playResults.add(PlayResult.of(playResults.get(i), i + 1));
        }
    }

    public List<PlayResult> getPlayResults() {
        return new ArrayList<>(this.playResults);
    }

    public int getCount() {
        return this.playResults.size();
    }

    public String getResult(int order) {
        return this.playResults.stream()
                .filter(p -> p.isOrder(order))
                .findFirst()
                .map(p -> p.getResult())
                .orElseThrow(() -> new IllegalArgumentException("맞는 순서의 결과가 없습니다."));
    }

    private void validate(List<String> playResults) {
        if (playResults.size() < RULE_PLAY_RESULT_MIN_COUNT) {
            throw new IllegalArgumentException(String.format("게임 결과는 %d개 이상이어야 합니다.", RULE_PLAY_RESULT_MIN_COUNT));
        }
    }
}
