package ua.odessa.tol2000.datetrisclassic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.logging.Logger;

/**
 * Created by Us01 on 13.10.2017.
 */

public class TetrisGrid extends View {

    private final int backColor = Color.WHITE;

    private int numColumns, numRows;
    private int cellWidth, cellHeight;
    private Paint cellPaint = new Paint();
    private boolean[][] cellChecked;

    private int[][] tetGlass;  // array of class (each cell - color in int format)

    public TetrisGrid(Context context)
    {
        this(context, null);
    }

    public TetrisGrid(Context context, AttributeSet attrs) {
        super(context, attrs);
        cellPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        cellPaint.setColor(backColor);
        LocalData.logV("TetrisGrid created!");
    }

    public int getNumColumns() {
        return numColumns;
    }

    public int getNumRows() {
        return numRows;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        refreshGlass();
    }

    public void initGrid(int numRows, int numColumns) {
        if (numColumns < 1 || numRows < 1) {
            throw new IndexOutOfBoundsException("rows and columns must be >1");
        }
        this.numColumns = numColumns;
        this.numRows = numRows;
        tetGlass = new int[numRows][numColumns];
        for (int i=0; i<numRows; i++)
            for (int j=0; j<numColumns; j++)
                tetGlass[i][j] = backColor;
    }

    public void refreshGlass() {
        cellWidth = getWidth() / numColumns;
        cellHeight = getHeight() / numRows;
        invalidate();
    }

    public void figDisp(Figure[] figure, Boolean clear) {
        try {
            int color = backColor;
            for (int i = 0; i < figure.length; i++) {
                if (!clear) color = figure[i].color;
                tetGlass[figure[i].y][(figure[i].x) * 2] = color;
                tetGlass[figure[i].y][(figure[i].x) * 2 + 1] = color;
            }
        } catch (Exception e) {
            LocalData.logE(e.getLocalizedMessage());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.drawColor(backColor);
        int width = getWidth();
        int height = getHeight();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                int color = tetGlass[i][j];
                drawCell(canvas, i, j, color);
            }
        }
    }

    private void drawCell(Canvas canvas, int row, int col, int color) {
        if (cellPaint.getColor() != color) cellPaint.setColor(color);
        canvas.drawRect(
            col * cellWidth, row * cellHeight,
            (col + 1) * cellWidth, (row + 1) * cellHeight,
            cellPaint
        );
    }

}
