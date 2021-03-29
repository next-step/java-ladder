package ladder.domain.result;

import ladder.domain.participant.ParticipantList;
import ladder.exception.CustomException;
import ladder.exception.ErrorCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultList {

    private List<Result> results;

    public ResultList(String stringResults, ParticipantList participantList) {
        this.results = results(stringResults, participantList);
    }

    private List<Result> results(String stringResults, ParticipantList participantList) {
        List<Result> parsedResultList = splitResults(stringResults);
        if (!lengthEqual(parsedResultList, participantList)) {
            throw new CustomException(ErrorCode.INVALID_RESULT_SIZE);
        }
        return parsedResultList;
    }

    private List<Result> splitResults(String results) {
        return Arrays.stream(results.split(","))
                .map(String::trim)
                .map(Result::new)
                .collect(Collectors.toList());
    }

    private boolean lengthEqual(List<Result> parsedResultList, ParticipantList participantList) {
        return parsedResultList.size() == participantList.size();
    }

    public int size() {
        return this.results.size();
    }
}
