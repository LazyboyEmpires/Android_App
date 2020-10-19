package lazyboyempires.nmc.fade_effect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    boolean bartIsShowing = true;
    public void fade(View view) {
        Log.i("Info", "ImageView Tapped");
        ImageView bartView = (ImageView) findViewById(R.id.bartView);
        ImageView homerView = (ImageView) findViewById(R.id.homerView);
        if (bartIsShowing) {
            bartIsShowing = false;
            bartView.animate().alpha(0).setDuration(2000);
            homerView.animate().alpha(1).setDuration(2000);
        }else {
            bartIsShowing = true;
            bartView.animate().alpha(1).setDuration(2000);
            homerView.animate().alpha(0).setDuration(2000);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}