package ua.odessa.tol2000.datetrisclassic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TetrisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetris);
    }

    public void initClick(View v) {
        ((TextView) this.findViewById(R.id.textView)).setText("Initialized");
    }

}
