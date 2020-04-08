package ladder.model.row;

import ladder.model.player.Players;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Rows {
    private static List<Row> rows;

    public Rows(List<Row> rows) {
        this.rows = Collections.unmodifiableList(rows);
    }

    public static Rows create(Players players, Height height) {
        return IntStream.range(0, height.getHeight())
                .mapToObj(it -> Row.create(players.getPlayerCount()))
                .collect(collectingAndThen(toList(), Rows::new));
    }

    public List<Row> getRows() {
        return rows;
    }

    public static Rows getAllRows(){
        return new Rows(rows);
    }

    public int getSize() {
        return rows.size();
    }

    public Row getRowsElement(int index) {
        return rows.get(index);
    }
}