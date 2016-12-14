package player;

import api.Player;
import api.Block;
import api.Grid;
import block.blocktypes.DecorationBlock;
import exceptions.*;
import grid.GridManager;
import java.util.List;
import java.util.Observer;
import java.util.Observable;

/**
 * This class manages the player in the editor or engine
 * @author Aninda Manocha
 */

public class PlayerManager implements Observer{

    private Player myPlayer;
    private Grid myGrid;

    public PlayerManager(Grid grid) {
        myGrid = grid;
    }

    public boolean addPlayer(List<String> names, String playerName, int row, int col, int gridIndex) throws BadPlayerPlacementException, DuplicatePlayerException {
        if(!(myGrid.getBlock(row, col).isWalkable())) {
            throw new BadPlayerPlacementException(row, col);
        }
        if(myPlayer == null) {
            myPlayer = new PlayerInstance(names, playerName, row, col, gridIndex);
            return true;
        }
        else {
            throw new DuplicatePlayerException(myPlayer.getRow(), myPlayer.getCol());
        }
    }

    public boolean addPlayerAttribute(String name, double amount, double increment, double decrement) throws DuplicateAttributeException {
        PlayerAttribute playerAttribute = new PlayerAttribute(name, amount, increment, decrement);
        if (!myPlayer.addAttribute(playerAttribute)) {
            throw new DuplicateAttributeException();
        }
        return true;
    }

    public void deletePlayer() {
        myPlayer = null;
    }

    public boolean movePlayer(int row, int col) throws BadPlayerPlacementException {
        Block block = myGrid.getBlock(row, col);
        if (block instanceof DecorationBlock) {
            myPlayer.setRow(row);
            myPlayer.setCol(col);
            return true;
        }
        throw new BadPlayerPlacementException(row, col);
    }

    /**
     * Updates the player's properties when the grid shrinks
     * @param grid - the observable grid manager
     * @param update - the type of update (row or column change)
     */
    public void update(Observable grid, Object update) {
        if (grid instanceof GridManager) {
            PlayerBlockUpdate playerBlockUpdate = (PlayerBlockUpdate)update;
            if (playerBlockUpdate.getUpdate() == PlayerUpdate.ROW) {
                myPlayer.setRow(myPlayer.getRow() - playerBlockUpdate.getOffset());
            } else {
                myPlayer.setCol(myPlayer.getCol() - playerBlockUpdate.getOffset());
            }
        }
    }

    /**
     * Gets the player
     * @return the player
     * @throws NoPlayerException
     */
    public Player getPlayer() throws NoPlayerException {
        if (myPlayer == null) {
            throw new NoPlayerException();
        }
        return myPlayer;
    }

    public List<String> getNames() {
        return myPlayer.getNames();
    }

    public String getPlayerName() {
        return myPlayer.getPlayerName();
    }

    public int getRow() {
        return myPlayer.getRow();
    }

    public int getCol() {
        return myPlayer.getCol();
    }

    public PlayerDirection getDirection() {
        return myPlayer.getDirection();
    }

    public double getHealth() {
        return myPlayer.getHealth();
    }

    public int getNumPokemon() {
        return myPlayer.getNumPokemon();
    }

    /**
     * Sets the player
     * @param player - the new player
     */
    public void setPlayer(Player player) {
        myPlayer = player;
    }

    /**
     * Sets the grid containing the player
     * @param grid - the new grid
     */
    public void setGrid(Grid grid) {
        myGrid = grid;
    }
}
