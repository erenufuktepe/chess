package controller;

import model.Board;
import model.state.BlackTurnState;
import model.state.GameState;
import model.state.WhiteTurnState;


public class ChessController {
    private GameState state;
    private Board board;

    public ChessController() {
        setState(new WhiteTurnState());
        this.board = new Board();
    }

    public void changeTurn() {
        setState(state instanceof WhiteTurnState ? new BlackTurnState() : new WhiteTurnState());
    }

    public Board getBoard() {
        return this.board;
    }

    public GameState getState() {
        return this.state;
    }

    public void setState(GameState state){
        this.state = state;
    }

}
