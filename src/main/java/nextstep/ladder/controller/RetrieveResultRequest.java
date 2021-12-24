package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;

import java.util.Objects;

public final class RetrieveResultRequest {

    private final Ladder ladder;
    private final UserResultsRequest userResultsRequest;

    private RetrieveResultRequest(Ladder ladder, UserResultsRequest userResultsRequest) {
        this.ladder = ladder;
        this.userResultsRequest = userResultsRequest;
    }

    public static RetrieveResultRequest of(Ladder ladder, UserResultsRequest userResultsRequest) {
        validate(ladder, userResultsRequest);
        return new RetrieveResultRequest(ladder, userResultsRequest);
    }

    private static void validate(Ladder ladder, UserResultsRequest userResultsRequest) {
        if (Objects.isNull(ladder)) {
            throw new IllegalArgumentException("전달된 사다리 정보가 null입니다.");
        }
        if (Objects.isNull(userResultsRequest)) {
            throw new IllegalArgumentException("전달된 사다리 결과 요청 정보가 null입니다.");
        }
    }

    public Ladder getLadder() {
        return ladder;
    }
}
