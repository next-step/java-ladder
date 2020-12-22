package ladder.domain;

import java.util.List;

/**
 * 생성된 사다리 형태를 줄 단위로 읽을 수 있다
 *
 */
public interface LadderReader {

    /**
     * 한줄씩 읽는다.
     * 한줄은 LadderPoint 로 이루어져 있다
     * EOL 에 도달하면 null 을 return 한다
     *
     * @return
     */
    List<LadderItem> readLine();
}
