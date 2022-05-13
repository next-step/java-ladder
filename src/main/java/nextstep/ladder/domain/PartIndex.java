package nextstep.ladder.domain;

import java.util.List;

public class PartIndex {
    private int row;
    private int col;

    public PartIndex(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean rowIsSmallerThan(int height) {
        return row < height;
    }

    public Part partOf(List<Parts> lines) {
        return lines.get(row).part(col);
    }

    public void modifyIfConnected(Part part, List<Parts> lines) {
        if (!part.isConnected()) {
            moveRowIndexToNext();
            return;
        }

        if (col > 0
            && lines.get(row).part(col-1).isConnected()) {
            moveColumnIndexToLeft();
            moveRowIndexToNext();
            return;
        }

        if (col < lines.get(row).size()-1
            && lines.get(row).part(col+1).isConnected()) {
            moveColumnIndexToRight();
            moveRowIndexToNext();
        }
    }

    private void moveColumnIndexToRight() {
        col += 2;
    }

    private void moveColumnIndexToLeft() {
        col -= 2;
    }

    private void moveRowIndexToNext() {
        ++row;
    }

    public int getCol() {
        return col;
    }

    public void modifyIfConnectedPartOf(List<Parts> lines) {
        modifyIfConnected(partOf(lines), lines);
    }
}
