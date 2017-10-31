package ua.odessa.tol2000.datetrisclassic;

/**
 * Created by Us01 on 31.10.2017.
 */

public class DaTetris {

    private final int numRows = 20;
    private final int numCols = 10;

    private Figure[] figInit = new Figure[7];

    private int figPhase;
    private int figCur;
    private int figNext = 3;

    private int remLines;
    private int level;
    private int score;

    private final TetrisGrid tetrisGrid;

    public DaTetris(TetrisGrid tetrisGrid) {
        this.tetrisGrid = tetrisGrid;
        tetrisGrid.initGrid(numRows, numCols);
        initFig();
    }

    private void initFig() {
        /*
        figInit[0][0].y = 0;
        figInit[0][0].x = 4;
        figInit[0][1].y = 1;
        figInit[0][1].x = 4;
        figInit[0][2].y = 2;
        figInit[0][2].x = 4;
        figInit[0][3].y = 3;
        figInit[0][3].x = 4;

        figInit[1][0].y = 0;
        figInit[1][0].x = 4;
        figInit[1][1].y = 1;
        figInit[1][1].x = 4;
        figInit[1][2].y = 0;
        figInit[1][2].x = 5;
        figInit[1][3].y = 1;
        figInit[1][3].x = 5;

        figInit[2][0].y = 0;
        figInit[2][0].x = 4;
        figInit[2][1].y = 1;
        figInit[2][1].x = 4;
        figInit[2][2].y = 2;
        figInit[2][2].x = 4;
        figInit[2][3].y = 1;
        figInit[2][3].x = 3;

        figInit[3][0].y = 0;
        figInit[3][0].x = 4;
        figInit[3][1].y = 1;
        figInit[3][1].x = 4;
        figInit[3][2].y = 1;
        figInit[3][2].x = 5;
        figInit[3][3].y = 2;
        figInit[3][3].x = 5;

        figInit[4][0].y = 0;
        figInit[4][0].x = 5;
        figInit[4][1].y = 1;
        figInit[4][1].x = 5;
        figInit[4][2].y = 1;
        figInit[4][2].x = 4;
        figInit[4][3].y = 2;
        figInit[4][3].x = 4;

        figInit[5][0].y = 0;
        figInit[5][0].x = 5;
        figInit[5][1].y = 0;
        figInit[5][1].x = 4;
        figInit[5][2].y = 1;
        figInit[5][2].x = 4;
        figInit[5][3].y = 2;
        figInit[5][3].x = 4;

        figInit[6][0].y = 0;
        figInit[6][0].x = 3;
        figInit[6][1].y = 0;
        figInit[6][1].x = 4;
        figInit[6][2].y = 1;
        figInit[6][2].x = 4;
        figInit[6][3].y = 2;
        figInit[6][3].x = 4;
        */
    }

    public void figDown() {

    }

    public void figLeft() {

    }

    public void figRight() {

    }

    public void figRotate() {

    }

}
