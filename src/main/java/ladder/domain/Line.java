package ladder.domain;

import ladder.vo.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private int height;
    private List<Block> rows;

    public Line(int height) {
        this.height = height;
        rows = new ArrayList<>();
    }

    public List<Block> createRow() {
        for (int i = 0; i < height; i++) {
            addRow(getRandomValue());
        }
        return rows;
    }

    public void addRow(boolean randomValue) {
        Block block = new Block(randomValue);
        rows.add(block);
    }

    public boolean getRandomValue() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public void checkLine(Line nextLine) {
        for (int i = 0; i < height; i++) {
            changeLine(nextLine, i);
        }
    }

    public boolean changeLine(Line nextLine, int row) {
        boolean isChange = false;

        if (this.rows.get(row).isRow() && nextLine.rows.get(row).isRow()) {
            nextLine.rows.set(row, new Block(false));
            isChange = true;
        }

        return isChange;
    }

    public void deleteRow() {
        rows.replaceAll(row -> row = new Block(false));
    }

    public List<Block> getRows() {
        return rows;
    }

    public int getHeight() {
        return height;
    }

}
