package ladder.domain;

import ladder.util.StringUtil;

import java.util.List;

public class GameAttendees {
    private final List<String> gameAttendees;

    public GameAttendees(String stringGameAttendees) {
        this.gameAttendees = StringUtil.parse(stringGameAttendees);
    }

    public int getNumberOfGameAttendees() {
        return gameAttendees.size();
    }

    public String getGameAttendees(final int index) {
        final int maxIndex = getNumberOfGameAttendees() - 1;
        if (index > maxIndex) {
            throw new IllegalArgumentException();
        }
        return gameAttendees.get(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        gameAttendees.forEach((attendees) -> stringBuilder.append(StringUtil.fixStringLength(attendees)));
        return stringBuilder.toString();
    }

}
