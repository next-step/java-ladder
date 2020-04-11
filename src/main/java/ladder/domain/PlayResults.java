package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayResults {
    private List<PlayResult> playResults;

    public PlayResults(List<String> playResults) {
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
}
