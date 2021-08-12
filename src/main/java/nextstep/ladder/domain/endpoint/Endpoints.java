package nextstep.ladder.domain.endpoint;

import nextstep.ladder.domain.exception.InputInvalidException;
import nextstep.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static nextstep.ladder.domain.laddar.LadderGame.DELIMITER_MARK;

public class Endpoints {
    private final List<Endpoint> endpoints;

    private Endpoints(final List<Endpoint> endpoints) {
        this.endpoints = endpoints;
    }

    public static Endpoints from(final String endpoints) {
        verifyEndpointsInitialize(endpoints);
        return new Endpoints(stream(endpoints.split(DELIMITER_MARK))
                                     .map(Endpoint::from)
                                     .collect(Collectors.toUnmodifiableList()));
    }

    private static void verifyEndpointsInitialize(final String endpoints) {
        if (StringUtils.isEmpty(endpoints)) {
            throw new InputInvalidException("입력이 없습니다.");
        }

        if (!endpoints.contains(DELIMITER_MARK)) {
            throw new InputInvalidException("입력이 잘못됐습니다.");
        }
    }

    public List<String> arriveAt() {
        return endpoints.stream()
                        .map(Endpoint::name)
                        .collect(Collectors.toUnmodifiableList());
    }

    public int size() {
        return endpoints.size();
    }
}
