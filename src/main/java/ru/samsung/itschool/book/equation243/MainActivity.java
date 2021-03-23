package ru.samsung.itschool.book.equation243;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    // Вызывается при создании Активности
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Инициализирует Активность.
        setContentView(R.layout.activity_main);
    }

    /** Вызывается при нажатии пользователем на кнопку Решить */
        public void solveEquation(View view) {
            double a, b, c;
            try{
                a = Double.parseDouble( ((EditText)
                        findViewById(R.id.coefficient_a)).getText().toString());
            }
            catch (Exception e){
                a = 0;
            }
            try{
                b = Double.parseDouble( ((EditText)
                        findViewById(R.id.coefficient_b)).getText().toString());
            }
            catch (Exception e){
                b = 0;
            }
            try{
                c = Double.parseDouble( ((EditText)
                        findViewById(R.id.coefficient_c)).getText().toString());
            }
            catch (Exception e){
                c = 0;
            }

            TextView result = (TextView) findViewById(R.id.result);
            if (a == 0)
                if (b == 0)
                    result.setText("Нет решения");
                else
                    result.setText(String.valueOf(-c / b));
            else {
                double d = Math.pow(b, 2) - 4 * a * c;
                if (d < 0)
                    result.setText("Нет действительных корней");
                else if (d == 0)
                    result.setText(String.valueOf((-b + Math.sqrt(d)) / (2 * a)));
                else
                    result.setText(String.valueOf((-b - Math.sqrt(d)) / (2 * a)) +
                            "; " + String.valueOf((-b + Math.sqrt(d)) / (2 * a)));
            }
        }
}
