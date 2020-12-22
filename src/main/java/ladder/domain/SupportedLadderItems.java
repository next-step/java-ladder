package ladder.domain;

import java.util.List;

/**
 * LadderItem 으로 변환가능한 가능한 객체는 이 interface 를 구현합니다.
 */
public interface SupportedLadderItems {

    List<LadderItem> toLadderItems();

}
