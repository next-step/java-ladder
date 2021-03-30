package ladder.entity.resultCase;

import ladder.entity.participant.ParticipantList;
import ladder.exception.CustomException;
import ladder.exception.ErrorCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultCaseList {

    private final List<ResultCase> resultCases;

    public ResultCaseList(ParticipantList participantList, String resultCases){
        this.resultCases = verifiedResultCases(participantList, resultCases);
    }

    private List<ResultCase> verifiedResultCases(ParticipantList participantList, String resultCases){
        List<ResultCase> resultCaseList = Arrays.stream(resultCases.split(","))
                .map(ResultCase::new)
                .collect(Collectors.toList());
        if(resultCaseList.size()!= participantList.size()){
            throw new CustomException(ErrorCode.INVALID_RESULT_SIZE);
        }
        return resultCaseList;
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
