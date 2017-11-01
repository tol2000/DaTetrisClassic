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
        tetris = new DaTetris((TetrisGrid) this.findViewById(R.id.tetrisGrid));
    }

    public void leftButtonClick(View v) {
        writeStatus("Left pressed");
    }

    private void writeStatus(String status) {
        ((TextView) this.findViewById(R.id.textViewStatus)).setText(LocalUtils.getDate()+": "+status);
    }

}
