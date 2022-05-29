package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Score {
    public static final int MAX_SCORE_VALUE_LENGTH = 5;

    private final String scoreValue;

    public Score(String scoreValue) {
        validateScoreValue(scoreValue);
        this.scoreValue = scoreValue;
    }

    private void validateScoreValue(String scoreValue) {
        if (isBlank(scoreValue)) {
            throw new IllegalArgumentException(String.format("실행 결과(점수)는 null 이거나 비어있을 수 없습니다. 입력 받은 결과(점수) 값 : %s", scoreValue));
        }
        if (scoreValue.length() > MAX_SCORE_VALUE_LENGTH) {
            throw new IllegalArgumentException(String.format("실행 결과(점수) 길이는 5보다 작거나 같아야 합니다. 입력 받은 결과(점수) 값 : %s", scoreValue));
        }
    }

    private boolean isBlank(String scoreValue) {
        return scoreValue == null || scoreValue.isBlank();
    }

    public static List<Score> create(List<String> scores) {
        return scores.stream().map(Score::new).collect(Collectors.toList());
    }

    public int scoreLength() {
        return this.scoreValue.length();
    }

    public String score() {
        return this.scoreValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score = (Score) o;

        return scoreValue.equals(score.scoreValue);
    }

    @Override
    public int hashCode() {
        return scoreValue.hashCode();
    }
}
