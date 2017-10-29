package ua.odessa.tol2000.datetrisclassic;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

public class TetrisActivity extends AppCompatActivity {

    TetrisGrid tetris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetris);
        myInit();
    }

    private void myInit() {
        tetris = (TetrisGrid) this.findViewById(R.id.tetrisView);
        tetris.initGrid(20,10);

        Figure[] f = new Figure[4];
        for (int i=0; i<4; i++) f[i] = new Figure();

        f[0].y = 1;
        f[0].x = 4;
        f[0].color = Color.BLACK;

        f[1].y = 2;
        f[1].x = 4;
        f[1].color = Color.BLACK;

        f[2].y = 3;
        f[2].x = 4;
        f[2].color = Color.BLACK;

        f[3].y = 3;
        f[3].x = 3;
        f[3].color = Color.BLACK;

        tetris.figDisp(f, false);
        tetris.refreshGlass();
    }

    public void leftButtonClick(View v) {
        ((TextView) this.findViewById(R.id.textViewStatus)).setText("Left pressed "+LocalUtils.getDate());
    }

}
