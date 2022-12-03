package nextstep.ladder.domain;

import nextstep.ladder.exception.IllegalResultInputException;

import java.util.List;

import static java.util.List.of;

public class Result {

    private List<String> results;

    public Result(String results,Names names) {
        this.results = splitResult(results,names.size());
    }

    public List<String> results() {
        return results;
    }

    public String result(int index) {
        return results.get(index);
    }

    private List<String> splitResult(String results,int size) {
        List<String> splitResult = of(results.split(","));
        if(splitResult.size() != size){
            throw new IllegalResultInputException("결과개수는 참여자 수와 같아야합니다");
        }
        return splitResult;
    }
}
