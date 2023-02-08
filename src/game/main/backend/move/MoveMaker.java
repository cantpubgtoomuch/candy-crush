package backend.move;

import backend.Grid;
import backend.element.Candy;
import backend.element.HorizontalStripedCandy;
import backend.element.VerticalStripedCandy;
import backend.element.WrappedCandy;

import java.util.HashMap;
import java.util.Map;

public class MoveMaker {

	private Map<String, Move> map;
	private Grid grid;
	
	public MoveMaker(Grid grid) {
		this.grid = grid;
		initMap();
	}

	/*
	* Sets all the combinations of movements.
	* Candy + Candy						=	CandyMove
	*       + HorizontalStripedCandy	=	CandyMove
	* 		+ VerticalStripedCandy		=	CandyMove
	* 		+ WrappedCandy				=	CandyMove
	* 		+ Bomb						=	BombMove
	* 		+ Fruit						=	CandyMove
	*
	* (Horizontal | Vertical)StripedCandy + Candy				   =	CandyMove
	* 						 			  + HorizontalStripedCandy =    TwoStripedMove
	*						 			  + VerticalStripedCandy   =	TwoStripedMove
	*						 			  + WrappedCandy		   =	WrappedStripedMove
	* 						 			  + Bomb				   = 	BombStrippedMove
	* 						 		      + Fruit				   =	CandyMove
	*
	* WrappedCandy + Candy 					 = 		CandyMove
	* 			   + HorizontalStripedCandy  =		WrappedStripedMove
	* 			   + VerticalStripedCandy    =		WrappedStripedMove
	* 			   + WrappedCandy  			 =		TwoWrappedMove
	* 			   + Fruit					 =		CandyMove
	*
	* Bomb + Candy					 =		BombMove
	* 	   + HorizontalStripedCandy  =		BombStrippedMove
	* 	   + VerticalStripedCandy    =		BombStrippedMove
	* 	   + WrappedCandy			 =		BombWrappedMove
	* 	   + Bomb					 =		TwoBombMove
	* 	   + Fruit					 =		FruitMove
	*/
	private void initMap(){
		map = new HashMap<>();
		map.put(new Candy().getKey() + new Candy().getKey(), new CandyMove(grid));
		map.put(new Candy().getKey() + new HorizontalStripedCandy().getKey(), new CandyMove(grid));
		map.put(new Candy().getKey() + new VerticalStripedCandy().getKey(), new CandyMove(grid));
		map.put(new Candy().getKey() + new WrappedCandy().getKey(), new CandyMove(grid));

		map.put(new HorizontalStripedCandy().getKey() + new Candy().getKey(), new CandyMove(grid));
		map.put(new HorizontalStripedCandy().getKey() + new HorizontalStripedCandy().getKey(), new backend.move.TwoStripedMove(grid));
		map.put(new HorizontalStripedCandy().getKey() + new VerticalStripedCandy().getKey(), new backend.move.TwoStripedMove(grid));
		map.put(new HorizontalStripedCandy().getKey() + new WrappedCandy().getKey(), new backend.move.WrappedStripedMove(grid));

		map.put(new VerticalStripedCandy().getKey() + new Candy().getKey(), new CandyMove(grid));
		map.put(new VerticalStripedCandy().getKey() + new HorizontalStripedCandy().getKey(), new backend.move.TwoStripedMove(grid));
		map.put(new VerticalStripedCandy().getKey() + new VerticalStripedCandy().getKey(), new backend.move.TwoStripedMove(grid));
		map.put(new VerticalStripedCandy().getKey() + new WrappedCandy().getKey(), new backend.move.WrappedStripedMove(grid));


		map.put(new WrappedCandy().getKey() + new Candy().getKey(), new CandyMove(grid));
		map.put(new WrappedCandy().getKey() + new HorizontalStripedCandy().getKey(), new backend.move.WrappedStripedMove(grid));
		map.put(new WrappedCandy().getKey() + new VerticalStripedCandy().getKey(), new backend.move.WrappedStripedMove(grid));
		map.put(new WrappedCandy().getKey() + new WrappedCandy().getKey(), new backend.move.TwoWrappedMove(grid));



	}
	
	public Move getMove(int i1, int j1, int i2, int j2) {
		Move move = map.get(grid.get(i1, j1).getKey() + grid.get(i2, j2).getKey());
		move.setCoords(i1, j1, i2, j2);
		return move;
	}

}
