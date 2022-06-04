package ladder.domain.ladder;

import java.util.*;

public class Line {
    private Connections connections;

    public Line(int countOfPerson) {
        this(createConnections(countOfPerson - 1));
    }

    public Line(List<Boolean> connectionList) {
        connections = new Connections(connectionList);
    }

    private static List<Boolean> createConnections(int person) {
        List<Boolean> tmpSpotList = new ArrayList<>();

        for (int i = 0; i < person; i++) {
            addConnection(tmpSpotList);
        }

        return tmpSpotList;
    }

    private static void addConnection(List<Boolean> tmpSpotList) {
        if (tmpSpotList.isEmpty()) {
            tmpSpotList.add(randomBoolean());
            return;
        }

        Boolean prevLine = tmpSpotList.get(tmpSpotList.size() - 1);
        if (!prevLine) {
            tmpSpotList.add(randomBoolean());
            return;
        }
        tmpSpotList.add(false);
    }

    private static boolean randomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public int move(int nowPosition) {
        return connections.move(nowPosition);
    }

    public List<Boolean> getSpotList() {
        return connections.getConnectionList();
    }
}
