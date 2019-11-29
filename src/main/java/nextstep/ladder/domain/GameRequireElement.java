package nextstep.ladder.domain;

import java.util.List;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-26 13:02
 */
public interface GameRequireElement {
    int numberOfParticipant();
    List<String> getParticipant();
    List<String> getExecutionResult();
}