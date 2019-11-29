package nextstep.ladder.domain;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-26 12:57
 */
public class LadderRequireElement implements GameRequireElement {

    private final Participant participant;
    private final ExecutionResult executionResult;

    public LadderRequireElement(List<String> participant, List<String> executeResult) {
        if (participant.size() != executeResult.size()) {
            throw new InputMismatchException("참여하는 인원과 결과의 수는 같아야합니다.");
        }

        this.participant = new Participant(participant);
        this.executionResult = new ExecutionResult(executeResult);
    }

    @Override
    public int numberOfParticipant() {
        return this.participant.numberOfParticipants();
    }

    @Override
    public List<String> getParticipant() {
        return this.participant.getParticipant();
    }

    @Override
    public List<String> getExecutionResult() {
        return this.executionResult.getExecutionResult();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderRequireElement that = (LadderRequireElement) o;
        return Objects.equals(participant, that.participant) &&
                Objects.equals(executionResult, that.executionResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participant, executionResult);
    }
}