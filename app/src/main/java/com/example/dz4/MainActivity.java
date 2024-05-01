package com.example.dz4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputId, inputStartPoint, inputEndPoint, inputStartTime, inputEndTime, ticketPrice;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // привязка разметки к полям
        inputId = findViewById(R.id.inputId);
        inputStartPoint = findViewById(R.id.inputStartPoint);
        inputEndPoint = findViewById(R.id.inputEndPoint);
        inputStartTime = findViewById(R.id.inputStartTime);
        inputEndTime = findViewById(R.id.inputEndTime);
        ticketPrice = findViewById(R.id.ticketPrice);
        button = findViewById(R.id.button);

        // обработка нажатия кнопки
        button.setOnClickListener(listener);
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // проверка введенных данных
            if (inputId.getText().toString().isEmpty() ||
                    inputStartPoint.getText().toString().isEmpty() ||
                    inputEndPoint.getText().toString().isEmpty() ||
                    inputStartTime.getText().toString().isEmpty() ||
                    inputEndTime.getText().toString().isEmpty() ||
                    ticketPrice.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Заполните все поля", Toast.LENGTH_SHORT).show();
            }
            else {
                // получение данных из полей
                int id = Integer.parseInt(inputId.getText().toString()); //айди
                String startPoint = inputStartPoint.getText().toString(); // точка отправления
                String endPoint = inputEndPoint.getText().toString(); // точка прибытия
                String startTime = inputStartTime.getText().toString(); //время отправления
                String endTime = inputEndTime.getText().toString(); //время прибытия
                int price = Integer.parseInt(ticketPrice.getText().toString()); //цена билета

                // создание объекта сущности билета
                Ticket ticket = new Ticket(id, startPoint, endPoint, startTime, endTime, price);

                // создание намерения
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                // передача объекта сущности полиса в намерение
                intent.putExtra(Ticket.class.getSimpleName(), ticket);

                // старт переключения активности
                startActivity(intent);
            }
        }
    };
}