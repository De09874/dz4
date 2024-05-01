package com.example.dz4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    // поля
    private TextView output;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // привязка разметки к полям
        output = findViewById(R.id.output);
        button = findViewById(R.id.button);

        // считывание данных из намерения
        Bundle bundle = getIntent().getExtras();

        //извлечение объекта сущности полиса по ключу
        if (bundle!= null) {
            Ticket ticket = (Ticket) bundle.getSerializable(Ticket.class.getSimpleName());
            // запись полей объекта сущности
             int id = ticket.getID();
             String startPoint = ticket.getStartPoint();
             String endPoint = ticket.getEndPoint();
             String startTime = ticket.getStartTime();
             String endTime = ticket.getEndTime();
             int price = ticket.getPrice();

            //вывод данных на экран
            output.setText("ID пользователя: " + id + "\n" +
                    "Точка отправления: " + startPoint + "\n" +
                    "Точка прибытия: " + endPoint + "\n" +
                    "Время отправления: " + startTime + "\n" +
                    "Время прибытия: " + endTime + "\n" +
                    "Цена: " + price + " рублей");
        }

        // обработка нажатия кнопки
        button.setOnClickListener(listener);
    }
    // создание слушателя
    private View.OnClickListener listener = v -> {
        // намерение перехода в первую активность
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        // intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); // перемещение активности на вершину стека
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // удаление всех активностей кроме той на корую происходит переход
        startActivity(intent);
    };
}