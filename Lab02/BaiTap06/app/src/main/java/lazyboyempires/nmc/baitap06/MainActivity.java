package lazyboyempires.nmc.baitap06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtRecord;
    ImageButton ibtnPlay;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        final CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number = 5;
                Random ran = new Random();
                int o = ran.nextInt(number);
                int tw = ran.nextInt(number);
                int th = ran.nextInt(number);
                //Kiem tra ai Win
                if (skOne.getProgress() >= skOne.getMax()) {
                    //this.cancel() chỉ chạy được trong máy ảo 5. trở lên
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"FaceBook WIN", Toast.LENGTH_SHORT).show();
                }
                if (skTwo.getProgress() >= skTwo.getMax()) {
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Instagram WIN", Toast.LENGTH_SHORT).show();

                }
                if (skThree.getProgress() >= skThree.getMax()) {
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Twitter WIN", Toast.LENGTH_SHORT).show();

                }
                skOne.setProgress(skOne.getProgress() + o);
                skTwo.setProgress(skTwo.getProgress() + tw);
                skThree.setProgress(skThree.getProgress() + th);

            }

            @Override
            public void onFinish() {

            }
        };
        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skOne.setProgress(0);
                skTwo.setProgress(0);
                skThree.setProgress(0);

                ibtnPlay.setVisibility(View.INVISIBLE);
                countDownTimer.start();
            }
        });
    }
    private void AnhXa() {
        txtRecord = (TextView) findViewById(R.id.textviewRecord);
        ibtnPlay = (ImageButton) findViewById(R.id.buttomPlay);
        cbOne = (CheckBox) findViewById(R.id.checkbox1);
        cbTwo = (CheckBox) findViewById(R.id.checkbox2);
        cbThree = (CheckBox) findViewById(R.id.checkbox3);
        skOne = (SeekBar) findViewById(R.id.seek1);
        skTwo = (SeekBar) findViewById(R.id.seek2);
        skThree = (SeekBar) findViewById(R.id.seek3);

    }
}