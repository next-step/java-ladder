package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

import static ladder.domain.Participant.MIN_NAME_LENGTH;
import static ladder.domain.Participant.MAX_NAME_LENGTH;

public class Score {
    private final String scoreValue;

    public Score(String scoreValue, int maxParticipantNameLength) {
        validateScoreValue(scoreValue, maxParticipantNameLength);
        this.scoreValue = scoreValue;
    }

    public static List<Score> create(List<String> scores, int maxParticipantNameLength) {
        return scores.stream().map(score -> new Score(score, maxParticipantNameLength)).collect(Collectors.toList());
    }

    public String score() {
        return this.scoreValue;
    }

    private void validateScoreValue(String scoreValue, int maxParticipantNameLength) {
        if (maxParticipantNameLength > MAX_NAME_LENGTH || maxParticipantNameLength < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("사람 이름의 최대 길이는 1 ~ 5를 벗어날 수 없습니다. 입력 받은 최대 이름 길이 : %d", maxParticipantNameLength));
        }
        if (isBlank(scoreValue)) {
            throw new IllegalArgumentException(String.format("실행 결과는 null 이거나 비어있을 수 없습니다. 입력 받은 결과 값 : %s", scoreValue));
        }
        if (scoreValue.length() < MIN_NAME_LENGTH || scoreValue.length() > maxParticipantNameLength) {
            throw new IllegalArgumentException(String.format("입력 받은 실행 결과 길이는 [1 ~ 최대 참가자 이름 길이(%d)] 범위를 벗어날 수 없습니다. 입력 받은 결과 길이 : %d", maxParticipantNameLength, scoreValue.length()));
        }
    }

    private boolean isBlank(String scoreValue) {
        return scoreValue.isBlank() || scoreValue == null;
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
