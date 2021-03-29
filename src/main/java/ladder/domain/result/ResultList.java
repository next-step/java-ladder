package ladder.domain.result;

import ladder.constants.Constants;
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

    public ResultList(ResultList resultList, List<Integer> resultIndices) {
        this.results = results(resultList, resultIndices);
    }

    private List<Result> results(ResultList resultList, List<Integer> resultIndices) {
        return resultIndices.stream()
                .map(resultList::get)
                .collect(Collectors.toList());
    }

    public Result get(int index) {
        if (index < Constants.ZERO || index >= this.results.size()) {
            throw new CustomException(ErrorCode.INVALID_RESULT_INDEX);
        }
        return results.get(index);
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

    public List<Result> resultList() {
        return this.results;
    }

    public String getResult(int index) {
        if (index < Constants.ZERO || index >= this.results.size()) {
            throw new CustomException(ErrorCode.INVALID_RESULT_INDEX);
        }
        return this.results.get(index).result();
    }
}
