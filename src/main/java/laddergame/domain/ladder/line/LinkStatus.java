/*
* Point간 연결상태를 정의하는 클래스
* Before-Next 순으로 연결이 되어야한다.
* */
package laddergame.domain.ladder.line;

public enum LinkStatus {
    LINK_BEFORE, LINK_NEXT, NOT_LINK;

    public boolean isLinked() {
        if (this == NOT_LINK) {
            return false;
        }
        return true;
    }

    public boolean isLinkedWith(LinkStatus status) {
        if (this == LINK_BEFORE && status == LINK_NEXT) {
            return true;
        }
        return false;
    }
}
