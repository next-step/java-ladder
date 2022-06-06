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
        List<Boolean> tmpConnectionList = new ArrayList<>();

        for (int i = 0; i < person; i++) {
            addConnection(tmpConnectionList);
        }

        return tmpConnectionList;
    }

    private static void addConnection(List<Boolean> tmpConnectionList) {
        if (tmpConnectionList.isEmpty()) {
            tmpConnectionList.add(randomBoolean());
            return;
        }

        Boolean prevLine = tmpConnectionList.get(tmpConnectionList.size() - 1);
        if (!prevLine) {
            tmpConnectionList.add(randomBoolean());
            return;
        }
        tmpConnectionList.add(false);
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
