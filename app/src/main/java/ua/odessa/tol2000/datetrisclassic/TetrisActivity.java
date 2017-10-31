package ua.odessa.tol2000.datetrisclassic;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class TetrisActivity extends AppCompatActivity {

    DaTetris tetris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetris);
        //myInit();
        tetris = new DaTetris((TetrisGrid) this.findViewById(R.id.tetrisGrid));
    }

    private void myInit() {
        TetrisGrid tetrisGrid = (TetrisGrid) this.findViewById(R.id.tetrisGrid);
        tetrisGrid.initGrid(20,10);

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

        tetrisGrid.figDisp(f, false);
        tetrisGrid.refreshGlass();
    }

    public void leftButtonClick(View v) {
        writeStatus("Left pressed");
    }

    private void writeStatus(String status) {
        ((TextView) this.findViewById(R.id.textViewStatus)).setText(LocalUtils.getDate()+": "+status);
    }

}
