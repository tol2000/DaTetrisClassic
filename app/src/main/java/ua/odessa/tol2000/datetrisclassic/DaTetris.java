package ua.odessa.tol2000.datetrisclassic;

/**
 * Created by Us01 on 31.10.2017.
 */

public class DaTetris {

    private FigureElement[][] figInit;
    private FigureElement[] figure;
    private FigureElement[][][] figInc;

    private int figPhase;
    private int figCur;
    private int figNext;

    private int remLines;
    private int level;
    private int score;

    private final TetrisGrid tetrisGrid;

    private int tetRandom() {
        return (int) Math.round( Math.random()%7 );
    }

    public DaTetris(TetrisGrid tetrisGrid) {
        this.tetrisGrid = tetrisGrid;

        // initializing elements in figInit
        figInit = new FigureElement[7][4];
        for (FigureElement[] f1 : figInit) {
            for (FigureElement f : f1) { f = new FigureElement(); }
        }
        // initializing elements in figure
        figure = new FigureElement[4];
        for (FigureElement f : figure) f = new FigureElement();
        // initializing elements in figInc
        figInc = new FigureElement[7][4][4];
        for (FigureElement[][] f2 : figInc) {
            for (FigureElement[] f1 : f2) {
                for (FigureElement f : f1) { f = new FigureElement(); }
            }
        }

        createFigures();
        tetrisGrid.initGlass();
        incInit();
        tetrisGrid.refreshTpad();
    }

    void incInit()
    {
        figInc[0][0][0].x= 1;
        figInc[0][0][0].y= 1;
        figInc[0][0][1].x= 0;
        figInc[0][0][1].y= 0;
        figInc[0][0][2].x=-1;
        figInc[0][0][2].y=-1;
        figInc[0][0][3].x=-2;
        figInc[0][0][3].y=-2;

        figInc[0][1][0].x=-1;
        figInc[0][1][0].y= 1;
        figInc[0][1][1].x= 0;
        figInc[0][1][1].y= 0;
        figInc[0][1][2].x= 1;
        figInc[0][1][2].y=-1;
        figInc[0][1][3].x= 2;
        figInc[0][1][3].y=-2;

        figInc[0][2][0].x=-1;
        figInc[0][2][0].y=-1;
        figInc[0][2][1].x= 0;
        figInc[0][2][1].y= 0;
        figInc[0][2][2].x= 1;
        figInc[0][2][2].y= 1;
        figInc[0][2][3].x= 2;
        figInc[0][2][3].y= 2;

        figInc[0][3][0].x= 1;
        figInc[0][3][0].y=-1;
        figInc[0][3][1].x= 0;
        figInc[0][3][1].y= 0;
        figInc[0][3][2].x=-1;
        figInc[0][3][2].y= 1;
        figInc[0][3][3].x=-2;
        figInc[0][3][3].y= 2;

        figInc[2][0][0].x= 1;
        figInc[2][0][0].y= 1;
        figInc[2][0][1].x= 0;
        figInc[2][0][1].y= 0;
        figInc[2][0][2].x=-1;
        figInc[2][0][2].y=-1;
        figInc[2][0][3].x= 1;
        figInc[2][0][3].y=-1;

        figInc[2][1][0].x=-1;
        figInc[2][1][0].y= 1;
        figInc[2][1][1].x= 0;
        figInc[2][1][1].y= 0;
        figInc[2][1][2].x= 1;
        figInc[2][1][2].y=-1;
        figInc[2][1][3].x= 1;
        figInc[2][1][3].y= 1;

        figInc[2][2][0].x=-1;
        figInc[2][2][0].y=-1;
        figInc[2][2][1].x= 0;
        figInc[2][2][1].y= 0;
        figInc[2][2][2].x= 1;
        figInc[2][2][2].y= 1;
        figInc[2][2][3].x=-1;
        figInc[2][2][3].y= 1;

        figInc[2][3][0].x= 1;
        figInc[2][3][0].y=-1;
        figInc[2][3][1].x= 0;
        figInc[2][3][1].y= 0;
        figInc[2][3][2].x=-1;
        figInc[2][3][2].y= 1;
        figInc[2][3][3].x=-1;
        figInc[2][3][3].y=-1;

        figInc[3][0][0].x= 2;
        figInc[3][0][0].y= 0;
        figInc[3][0][1].x= 1;
        figInc[3][0][1].y=-1;
        figInc[3][0][2].x= 0;
        figInc[3][0][2].y= 0;
        figInc[3][0][3].x=-1;
        figInc[3][0][3].y=-1;

        figInc[3][1][0].x=-2;
        figInc[3][1][0].y= 0;
        figInc[3][1][1].x=-1;
        figInc[3][1][1].y= 1;
        figInc[3][1][2].x= 0;
        figInc[3][1][2].y= 0;
        figInc[3][1][3].x= 1;
        figInc[3][1][3].y= 1;

        figInc[3][2][0].x= 2;
        figInc[3][2][0].y= 0;
        figInc[3][2][1].x= 1;
        figInc[3][2][1].y=-1;
        figInc[3][2][2].x= 0;
        figInc[3][2][2].y= 0;
        figInc[3][2][3].x=-1;
        figInc[3][2][3].y=-1;

        figInc[3][3][0].x=-2;
        figInc[3][3][0].y= 0;
        figInc[3][3][1].x=-1;
        figInc[3][3][1].y= 1;
        figInc[3][3][2].x= 0;
        figInc[3][3][2].y= 0;
        figInc[3][3][3].x= 1;
        figInc[3][3][3].y= 1;

        figInc[4][0][0].x= 0;
        figInc[4][0][0].y= 2;
        figInc[4][0][1].x=-1;
        figInc[4][0][1].y= 1;
        figInc[4][0][2].x= 0;
        figInc[4][0][2].y= 0;
        figInc[4][0][3].x=-1;
        figInc[4][0][3].y=-1;

        figInc[4][1][0].x= 0;
        figInc[4][1][0].y=-2;
        figInc[4][1][1].x= 1;
        figInc[4][1][1].y=-1;
        figInc[4][1][2].x= 0;
        figInc[4][1][2].y= 0;
        figInc[4][1][3].x= 1;
        figInc[4][1][3].y= 1;

        figInc[4][2][0].x= 0;
        figInc[4][2][0].y= 2;
        figInc[4][2][1].x=-1;
        figInc[4][2][1].y= 1;
        figInc[4][2][2].x= 0;
        figInc[4][2][2].y= 0;
        figInc[4][2][3].x=-1;
        figInc[4][2][3].y=-1;

        figInc[4][3][0].x= 0;
        figInc[4][3][0].y=-2;
        figInc[4][3][1].x= 1;
        figInc[4][3][1].y=-1;
        figInc[4][3][2].x= 0;
        figInc[4][3][2].y= 0;
        figInc[4][3][3].x= 1;
        figInc[4][3][3].y= 1;

        figInc[5][0][0].x= 0;
        figInc[5][0][0].y= 2;
        figInc[5][0][1].x= 1;
        figInc[5][0][1].y= 1;
        figInc[5][0][2].x= 0;
        figInc[5][0][2].y= 0;
        figInc[5][0][3].x=-1;
        figInc[5][0][3].y=-1;

        figInc[5][1][0].x=-2;
        figInc[5][1][0].y= 0;
        figInc[5][1][1].x=-1;
        figInc[5][1][1].y= 1;
        figInc[5][1][2].x= 0;
        figInc[5][1][2].y= 0;
        figInc[5][1][3].x= 1;
        figInc[5][1][3].y=-1;

        figInc[5][2][0].x= 0;
        figInc[5][2][0].y=-2;
        figInc[5][2][1].x=-1;
        figInc[5][2][1].y=-1;
        figInc[5][2][2].x= 0;
        figInc[5][2][2].y= 0;
        figInc[5][2][3].x= 1;
        figInc[5][2][3].y= 1;

        figInc[5][3][0].x= 2;
        figInc[5][3][0].y= 0;
        figInc[5][3][1].x= 1;
        figInc[5][3][1].y=-1;
        figInc[5][3][2].x= 0;
        figInc[5][3][2].y= 0;
        figInc[5][3][3].x=-1;
        figInc[5][3][3].y= 1;

        figInc[6][0][0].x= 2;
        figInc[6][0][0].y= 0;
        figInc[6][0][1].x= 1;
        figInc[6][0][1].y= 1;
        figInc[6][0][2].x= 0;
        figInc[6][0][2].y= 0;
        figInc[6][0][3].x=-1;
        figInc[6][0][3].y=-1;

        figInc[6][1][0].x= 0;
        figInc[6][1][0].y= 2;
        figInc[6][1][1].x=-1;
        figInc[6][1][1].y= 1;
        figInc[6][1][2].x= 0;
        figInc[6][1][2].y= 0;
        figInc[6][1][3].x= 1;
        figInc[6][1][3].y=-1;

        figInc[6][2][0].x=-2;
        figInc[6][2][0].y= 0;
        figInc[6][2][1].x=-1;
        figInc[6][2][1].y=-1;
        figInc[6][2][2].x= 0;
        figInc[6][2][2].y= 0;
        figInc[6][2][3].x= 1;
        figInc[6][2][3].y= 1;

        figInc[6][3][0].x= 0;
        figInc[6][3][0].y=-2;
        figInc[6][3][1].x= 1;
        figInc[6][3][1].y=-1;
        figInc[6][3][2].x= 0;
        figInc[6][3][2].y= 0;
        figInc[6][3][3].x=-1;
        figInc[6][3][3].y= 1;
    }

    private void createFigures()
    {
        int i;

        figNext = tetRandom();

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
    }

    public void figDown() {

    }

    public void figLeft() {

    }

    public void figRight() {

    }

    public void figRotate() {

    }

    boolean testCross()
    {
        for (int j=0; j<4; j++)
        {
//            if ((glass[figure[j].y][figure[j].x] !=0) || figure[j].y>19 || figure[j].x<0 || figure[j].x>9 || figure[j].y<0) return true;
        }
        return false;
    }

    public void figMake()
    {
        figCur = figNext;
        figNext = tetRandom();
        // Ниже, кажется, выводит след. фигуру...
        //for (int j=0;j<4;j++) mvwaddstr(w2,figInit[figCur][j].y+1, figInit[figCur][j].x*2+4, "  ");
        //for (int j=0;j<4;j++) mvwaddstr(w2,figInit[figNext][j].y+1, figInit[figNext][j].x*2+4, fillStr);
        //mvwprintw(w2,7,9,"%d",remLines);
        //mvwprintw(w2,8,9,"%d",Level);
        //mvwprintw(w2,9,9,"%d",Scores);
        //wnoutrefresh(w2);
        //wnoutrefresh(w1);
        //doupdate();
        figPhase=0;
        for (int j=0; j<4; j++) figure[j]=figInit[figCur][j];
        tetrisGrid.figDisp(figure, false);
    }

}
