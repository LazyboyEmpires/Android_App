package lazyboyempires.nmc.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText createX;
    private EditText createY;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createX = (EditText) findViewById(R.id.txtX);
        createY = (EditText)findViewById(R.id.txtY);
        result = (TextView)findViewById(R.id.txtResult);
        add = (Button)findViewById(R.id.btnA);
        sub = (Button)findViewById(R.id.btnS);
        mul = (Button)findViewById(R.id.btnM);
        div = (Button)findViewById(R.id.btnD);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number1 = Integer.parseInt(createX.getText().toString());
                int number2 = Integer.parseInt(createY.getText().toString());
                int sum = number1 +number2;
                result.setText(String.valueOf(sum));
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number1 = Integer.parseInt(createX.getText().toString());
                int number2 = Integer.parseInt(createY.getText().toString());
                int sub = number1 -number2;
                result.setText(String.valueOf(sub));
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number1 = Integer.parseInt(createX.getText().toString());
                int number2 = Integer.parseInt(createY.getText().toString());
                int mul = number1 * number2;
                result.setText(String.valueOf(mul));
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number1 = Integer.parseInt(createX.getText().toString());
                int number2 = Integer.parseInt(createY.getText().toString());
                int div = number1 / number2;
                result.setText(String.valueOf(div));
            }
        });

    }
}