package ua.odessa.tol2000.datetrisclassic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

public class TetrisActivity extends AppCompatActivity {

    DaTetrisFunc tetrisFunc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetris);
        myInit();
    }

    private void myInit() {
        tetrisFunc = new DaTetrisFunc((GridView) this.findViewById(R.id.gridView));
    }

    public void leftButtonClick(View v) {
        ((TextView) this.findViewById(R.id.textViewStatus)).setText("Left pressed "+LocalUtils.getDate());
    }

}
