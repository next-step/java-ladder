package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
	private final List<Boolean> line;

	public Line(List<Boolean> line){
		this.line = line;
	}

	public List<Boolean> getLine() {
		return line;
	}
}
