package study3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
	List<Point> points = new ArrayList<>();
	
	public Line(int PlayerNumbers, boolean anyValue) {
		initLine(PlayerNumbers, anyValue);
	}

	private List<Point> initLine(int playerNumbers, boolean anyValue) {
		
		
		Point point = new Point(0, new Direction(anyValue, new RandomGenerator().getRandom()));
		
		points.add(point);
		
		System.out.println(" player 수"+playerNumbers);
		for( int i = 1; i< playerNumbers-1; i++) {
			point = point.next();
			points.add(point);
		}
		
		points.add(point.last());
		
		for(int i=0; i<points.size(); i++) {
			System.out.println(i +"값 "+points.get(i).toString());
		}
		return points;
	}

	/*TODO
	 * private Boolean randomPoint(Boolean point) {
		if (point) {
			return false;
		}
		return new RandomGenerator().getRandom();
	}*/

	public List<Point> getLine() {
		return Collections.unmodifiableList(points);
	}
}
