package ru.ageev.hhgame.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import ru.ageev.hhgame.R;
import ru.ageev.hhgame.main.MainActivity;

public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        Intent game_over_intent = getIntent();
        Intent main_intent = new Intent(this, MainActivity.class);
        String message = game_over_intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView game_over_text = findViewById(R.id.game_over_text);
        game_over_text.setText(String.valueOf(message));

        Button game_again_button = findViewById(R.id.game_again_button);

        game_again_button.setOnClickListener(view -> startActivity(main_intent));
    }
}