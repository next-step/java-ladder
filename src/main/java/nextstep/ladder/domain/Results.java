package nextstep.ladder.domain;

import nextstep.ladder.exceptions.ParticipantsAndResultsNumberNotMatchedException;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private final List<Result> results;

    public Results(String[] results, int numberOfParticipants) {
        if (results.length != numberOfParticipants) {
            throw new ParticipantsAndResultsNumberNotMatchedException("참가자 수와 사다리 타기 결과의 수는 일치해야 합니다.");
        }
        this.results = new ArrayList<>();
        for (String result : results) {
            this.results.add(new Result(result));
        }
    }
}
