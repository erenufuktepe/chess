package model.state;

import controller.ChessController;
import model.Position;

public interface GameState {

    public boolean canPlay(Position position, ChessController controller);

}
