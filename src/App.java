import harivara.chess.components.board.Board;

public class App {
    public static void main(String[] args) throws Exception {
        Board board=Board.createStandardBoard();

        System.out.println(board);
    }
}
