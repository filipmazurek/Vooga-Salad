package block;

/**
 * A board object with which the player character will have some active
 * interaction (i.e. pressing 'A' or stepping on a switch which elicits a
 * response.
 *
 * @author Filip Mazurek, Daniel Chai, Aninda Manocha
 */
public class CommunicatorBlock extends Block implements NotWalkable {

	public CommunicatorBlock(String name, int row, int col) {
		super(name, row, col);
		setWalkableStatus(IS_WALKABLE); 		// tentative. What about letters on the floor, etc.
	}

}
