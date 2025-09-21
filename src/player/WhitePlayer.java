package player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.ImmutableList;

import board.Board;
import board.Move;
import board.Move.KingSideCastleMove;
import board.Move.QueenSideCastleMove;
import board.Tile;
import misc.Alliance;
import pieces.Piece;
import pieces.Rook;

public class WhitePlayer extends Player {

    public WhitePlayer(Board board, Collection<Move> whiteStandardLegalMoves,
            Collection<Move> blackStandardLegalMoves) {
        
                super(board,whiteStandardLegalMoves,blackStandardLegalMoves);
    }

    @Override
    public Collection<Piece> getActivePieces() {
        return this.board.getwhitePieces();
    }
    @Override
	public Alliance getAlliance() {
        return Alliance.WHITE;
	}

	@Override
	public Player getOpponent() {
		return this.board.whitePlayer();
	}

    @Override
    protected Collection<Move> calculateKingCastles(final Collection<Move> playerLegals, final Collection<Move> opponentsLegals) {
        final List<Move> kingCastles = new ArrayList<>();

        if(this.playerKing.isFirstMove() && !this.isInChecked()) {
            // whites king side castle
            if(!this.board.getTile(61).isTileOccupied() && !this.board.getTile(62).isTileOccupied()) {
                final Tile rookTile = this.board.getTile(63);
                if(rookTile.isTileOccupied() && rookTile.getPiece().isFirstMove()) {
                    if(Player.calculateAttackOnTile(61, opponentsLegals).isEmpty() &&
                    Player.calculateAttackOnTile(62, opponentsLegals).isEmpty() &&
                    rookTile.getPiece().getPieceType().isRook()) {
                        // TODO ADD A CASTLEMOVE!
                        kingCastles.add(new KingSideCastleMove(this.board, this.playerKing, 
                        62, (Rook)rookTile.getPiece(), 
                        rookTile.getTileCoordinate(),61));
                    }
                }
            }

            if(!this.board.getTile(59).isTileOccupied() &&
            !this.board.getTile(58).isTileOccupied() &&
            !this.board.getTile(57).isTileOccupied()) {
                final Tile rookTile = this.board.getTile(56);
                if(rookTile.isTileOccupied() && rookTile.getPiece().isFirstMove()) {
                    // TODO add castle move
                    kingCastles.add(new QueenSideCastleMove(this.board, this.playerKing, 
                        58, (Rook)rookTile.getPiece(), 
                        rookTile.getTileCoordinate(),59));
                }
            }
        }

        return ImmutableList.copyOf(kingCastles);
    }

    
}
