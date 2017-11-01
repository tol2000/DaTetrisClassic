package ua.odessa.tol2000.datetrisclassic;

import android.graphics.Color;

/**
 * Created by Us01 on 17.10.2017.
 */

public class FigureElement {
    public int x; //column (as in math functions)
    public int y; //row (as in math functions)
    public int color;

    public FigureElement() {
        color = Color.BLACK;
        x = 0;
        y = 0;
    }
}
