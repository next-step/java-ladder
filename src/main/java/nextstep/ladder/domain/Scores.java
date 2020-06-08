package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class Scores {
    private final List<String> scores;

    public Scores(List<String> scores) {
        this.scores = Collections.unmodifiableList(scores);
    }

    public String findScore(int scoreIndex) {
        return this.scores.get(scoreIndex);
    }

    public List<String> getScores() {
        return this.scores;
    }
}
