package ladder.domain.ladder;

import ladder.exception.OverlapLineException;

import java.util.Collections;
import java.util.List;

public class Connections {
    private List<Boolean> connectionList;

    public Connections(List<Boolean> connections) {
        validate(connections);
        connectionList = connections;
    }

    private void validate(List<Boolean> connections) {
        int bound = connections.size() - 1;
        for (int i = 0; i < bound; i++) {
            overlapValidate(connections, i);
        }
    }

    private void overlapValidate(List<Boolean> connections, int i) {
        if (connections.get(i) == true && connections.get(i + 1) == true) {
            throw new OverlapLineException("Line이 겹치는 부분이 있습니다.");
        }
    }

    public int move(int nowPosition) {
        // 현재 사다리 맨 왼쪽에 위치해있을때
        if (nowPosition == 0) {
            return rightMove(nowPosition);
        }

        // 현재 사다리 맨 오른쪽에 위치해있을때
        if (nowPosition == getConnectionList().size()) {
            return leftMove(nowPosition);
        }

        // 현재 사다리 중간에 위치해있을때
        return middlePositionCase(nowPosition);
    }

    private int middlePositionCase(int nowPosition) {
        if (isRightMove(nowPosition)) {
            return rightMove(nowPosition);
        }

        if (!isRightMove(nowPosition)) {
            return leftMove(nowPosition);
        }

        return nowPosition;
    }

    private int rightMove(int widthPos) {
        if (connectionList.get(widthPos)) {
            widthPos += 1;
        }
        return widthPos;
    }

    private int leftMove(int widthPos) {
        if (connectionList.get(widthPos - 1)) {
            widthPos -= 1;
        }
        return widthPos;
    }

    private boolean isRightMove(int widthPos) {
        return connectionList.get(widthPos);
    }

    public List<Boolean> getConnectionList() {
        return Collections.unmodifiableList(connectionList);
    }
}
