package domain.ladder;

import domain.LadderLineSupplier;
import domain.point.LineVertex;
import domain.point.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hspark on 20/11/2018.
 */
public class LadderLine {
	private List<LineVertex> lineVertices;

	public LadderLine(int sizeOfGamer, LadderLineSupplier ladderLineSupplier) {
		lineVertices = new ArrayList<>();
		LineVertex vertex = initFirst(ladderLineSupplier);
		vertex = initBody(sizeOfGamer, ladderLineSupplier, vertex);
		initLast(vertex);
	}

	private LineVertex initFirst(LadderLineSupplier ladderLineSupplier) {
		return LineVertex.first(ladderLineSupplier);
	}

	private void initLast(LineVertex vertex) {
		vertex = vertex.last();
		lineVertices.add(vertex);
	}

	private LineVertex initBody(int sizeOfGamer, LadderLineSupplier ladderLineSupplier, LineVertex vertex) {
		lineVertices.add(vertex);
		for (int i = 1; i < sizeOfGamer - 1; i++) {
			vertex = vertex.next(ladderLineSupplier);
			lineVertices.add(vertex);
		}
		return vertex;
	}

	public Point move(Point point) {
		return lineVertices.get(point.toInteger()).move();
	}

	public List<LineVertex> getLineVertices() {
		return Collections.unmodifiableList(lineVertices);
	}
}
