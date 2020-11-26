package step2.domain;

public class Row {

    private int[] players;

    public Row(int playersCount) {
        players = new int[playersCount];
    }

    public void drawLine(int startPosition) {
        players[startPosition] = 1;
        players[startPosition + 1] = 1;
    }

    public int move(int personPosition) {
        if (players[personPosition] == 0) {
            return personPosition;
        }
        if (personPosition - 1 >= 0 && players[personPosition - 1] == 1) {
            return personPosition - 1;
        }
        return personPosition + 1;
    }

}
