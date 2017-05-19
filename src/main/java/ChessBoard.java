import java.util.ArrayList;


public class ChessBoard {
    static Cell[][] chessBoard = new Cell[8][8];
    static long counter = 0;

    public static void main(String[] args) {
        fillChessBoard();
        fillingWithBoats(0);
        System.out.println(counter);
        }

    public static void fillingWithBoats(int i) {
        for (int column = 0; column < 8; column++) {
            if (i == 7) {
                counter++;
                i = 0;
            } else if (chessBoard[i][column].isEmpty == true && !chessBoard[i][column].underAttack.contains(true) && i < 8) {
                addFigure(i, column);
                fillingWithBoats(i + 1);
                removeFigure(i, column);
            } else continue;
        }
    }

   public static void easyFillingWithBoats() {
        for (int column0 = 0; column0 < 8; column0++) {
            if (chessBoard[0][column0].isEmpty == true && !chessBoard[0][column0].underAttack.contains(true)) {
                addFigure(0, column0);
                for (int column1 = 0; column1 < 8; column1++) {
                    if (chessBoard[1][column1].isEmpty == true && !chessBoard[1][column1].underAttack.contains(true)) {
                        addFigure(1, column1);
                        for (int column2 = 0; column2 < 8; column2++) {
                            if (chessBoard[2][column2].isEmpty == true && !chessBoard[2][column2].underAttack.contains(true)) {
                                addFigure(2, column2);
                                for (int column3 = 0; column3 < 8; column3++) {
                                    if (chessBoard[3][column3].isEmpty == true && !chessBoard[3][column3].underAttack.contains(true)) {
                                        addFigure(3, column3);
                                        for (int column4 = 0; column4 < 8; column4++) {
                                            if (chessBoard[4][column4].isEmpty == true && !chessBoard[4][column4].underAttack.contains(true)) {
                                                addFigure(4, column4);
                                                for (int column5 = 0; column5 < 8; column5++) {
                                                    if (chessBoard[5][column5].isEmpty == true && !chessBoard[5][column5].underAttack.contains(true)) {
                                                        addFigure(5, column5);
                                                        for (int column6 = 0; column6 < 8; column6++) {
                                                            if (chessBoard[6][column6].isEmpty == true && !chessBoard[6][column6].underAttack.contains(true)) {
                                                                addFigure(6, column6);
                                                                for (int column7 = 0; column7 < 8; column7++) {
                                                                    if (chessBoard[7][column7].isEmpty == true && !chessBoard[7][column7].underAttack.contains(true)) {
                                                                        addFigure(7, column7);
                                                                        counter++;
                                                                    } else continue;
                                                                removeFigure(7, column7);
                                                                }
                                                            } else continue;
                                                            removeFigure(6, column6);
                                                        }
                                                    } else continue;
                                                    removeFigure(5, column5);
                                                }
                                            } else continue;
                                            removeFigure(4, column4);
                                        }
                                    } else continue;
                                    removeFigure(3, column3);
                                }
                            } else continue;
                            removeFigure(2, column2);
                        }
                    } else continue;
                    removeFigure(1, column1);
                }
            } else continue;
            removeFigure(0, column0);
        }
    }




    public static void fillChessBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoard[i][j] = new Cell();
                for (int k = 0; k < 8; k++) {
                    chessBoard[i][j].underAttack.add(false);
                }
            }
        }
    }

    public static void addFigure(int i, int j) {
        chessBoard[i][j].isEmpty = false;
        for (int k = 0; k < 8; k++) {
            chessBoard[i][k].underAttack.set(i, true);
        }
        for (int k = 0; k < 8; k++) {
            chessBoard[k][j].underAttack.set(i, true);
        }
    }

    public static void removeFigure(int i, int j) {
        chessBoard[i][j].isEmpty = true;
        for (int k = 0; k < 8; k++) {
            chessBoard[i][k].underAttack.set(i, false);
        }
        for (int k = 0; k < 8; k++) {
            chessBoard[k][j].underAttack.set(i, false);
        }
    }

}
