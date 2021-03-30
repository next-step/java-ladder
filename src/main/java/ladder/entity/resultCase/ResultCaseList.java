package ladder.entity.resultCase;

import ladder.exception.CustomException;
import ladder.exception.ErrorCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultCaseList {

    private List<ResultCase> resultCases;

    public ResultCaseList(String resultCases){
        this.resultCases = verifiedResultCases(resultCases);
    }

    private List<ResultCase> verifiedResultCases(String resultCases){
        return Arrays.stream(resultCases.split(","))
                .map(ResultCase::new)
                .collect(Collectors.toList());
    }

    public ResultCase get(int index){
        if (index < 0 || index >= this.resultCases.size()) {
            throw new CustomException(ErrorCode.INVALID_RESULT_INDEX);
        }
        return this.resultCases.get(index);
    }

    public int size(){
        return this.resultCases.size();
    }
}
