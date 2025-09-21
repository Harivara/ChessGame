package harivara.chess.components.player;

import harivara.chess.components.board.Board;
import harivara.chess.components.board.Move;

public class MoveTransition {

    private final Board transitionBoard;
    private final Move move;
    private final MoveStatus moveStatus;

    public MoveTransition(final Board transitionBoard,final Move move,final MoveStatus moveStatus){
        this.transitionBoard=transitionBoard;
        this.move=move;
        this.moveStatus=moveStatus;
    }

    public MoveStatus getMoveStatus(){
        return this.moveStatus;
    }
}
