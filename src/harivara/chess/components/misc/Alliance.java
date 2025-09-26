package harivara.chess.components.misc;

import harivara.chess.components.player.BlackPlayer;
import harivara.chess.components.player.Player;
import harivara.chess.components.player.WhitePlayer;

public enum Alliance {
    WHITE {
        @Override
        public int getDirection(){
            return -1;
        }
        @Override 
        public boolean isWhite(){
            return true;
        }
        @Override
        public int getOppositeDirection(){
            return 1;
        }
        @Override 
        public boolean isBlack(){
            return false;
        }
        @Override
        public Player choosePlayer(final WhitePlayer whitePlayer,final BlackPlayer blackPlayer) {
                return whitePlayer;
        }
    },
    BLACK{
        @Override
        public int getDirection(){
            return 1;
        }
         @Override
        public int getOppositeDirection(){
            return -1;
        }
        @Override 
        public boolean isWhite(){
            return false;
        }   
        @Override 
        public boolean isBlack(){
            return true;
        }
        @Override
        public Player choosePlayer(final WhitePlayer whitePlayer,final BlackPlayer blackPlayer) {
                return blackPlayer;
        }
    };
    
    public abstract int getDirection();
    public abstract int getOppositeDirection();
    public abstract boolean isWhite();
    public abstract boolean isBlack();
    public abstract Player choosePlayer(WhitePlayer whitePlayer, BlackPlayer blackPlayer);

}
