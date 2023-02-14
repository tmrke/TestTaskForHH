package ru.ageev.hhgame.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import ru.ageev.hhgame.R;
import ru.ageev.hhgame.game.Game;
import ru.ageev.hhgame.game.GameOverActivity;

public class MainActivity extends AppCompatActivity {
    private TextView gamer_health_text;
    private TextView treats_count;

    private TextView monster_health_text_1;
    private TextView monster_health_text_2;
    private TextView monster_health_text_3;

    public final static String EXTRA_MESSAGE = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gamer_health_text = findViewById(R.id.gamer_health_text);
        treats_count = findViewById(R.id.treats_count);

        monster_health_text_1 = findViewById(R.id.monster_health_text_1);
        monster_health_text_2 = findViewById(R.id.monster_health_text_2);
        monster_health_text_3 = findViewById(R.id.monster_health_text_3);

        Button treat_button = findViewById(R.id.treat_button);
        Button attack_button_1 = findViewById(R.id.attack_button_1);
        Button attack_button_2 = findViewById(R.id.attack_button_2);
        Button attack_button_3 = findViewById(R.id.attack_button_3);

        Game game = new Game();
        Intent intent = new Intent(this, GameOverActivity.class);

        monster_health_text_1.setText(String.valueOf(game.getMonsters().get(0).getHealth()));
        monster_health_text_2.setText(String.valueOf(game.getMonsters().get(1).getHealth()));
        monster_health_text_3.setText(String.valueOf(game.getMonsters().get(2).getHealth()));

        gamer_health_text.setText(String.valueOf(game.getGamer().getHealth()));

        treat_button.setOnClickListener(view -> {
            game.getGamer().treat();
            gamer_health_text.setText(String.valueOf(game.getGamer().getHealth()));
            treats_count.setText(String.valueOf(game.getGamer().getTreatmentsCount()));
        });

        attack_button_1.setOnClickListener(view -> {
            game.getGamer().attack(game.getMonsters().get(0));
            game.getMonsters().get(0).attack(game.getGamer());

            monster_health_text_1.setText(String.valueOf(game.getMonsters().get(0).getHealth()));
            gamer_health_text.setText(String.valueOf(game.getGamer().getHealth()));

            showGameOverActivity(game, intent);
        });

        attack_button_2.setOnClickListener(view -> {
            game.getGamer().attack(game.getMonsters().get(1));
            game.getMonsters().get(1).attack(game.getGamer());

            monster_health_text_2.setText(String.valueOf(game.getMonsters().get(1).getHealth()));
            gamer_health_text.setText(String.valueOf(game.getGamer().getHealth()));

            showGameOverActivity(game, intent);
        });

        attack_button_3.setOnClickListener(view -> {
            game.getGamer().attack(game.getMonsters().get(2));
            game.getMonsters().get(2).attack(game.getGamer());

            monster_health_text_3.setText(String.valueOf(game.getMonsters().get(2).getHealth()));
            gamer_health_text.setText(String.valueOf(game.getGamer().getHealth()));

            showGameOverActivity(game, intent);
        });
    }

    private void showGameOverActivity(Game game, Intent intent) {
        if (game.getGamer().isDead()) {
            intent.putExtra(EXTRA_MESSAGE, "you lose :(");
            startActivity(intent);
        }

        if (game.getMonsters().get(0).isDead()
                && game.getMonsters().get(1).isDead()
                && game.getMonsters().get(2).isDead()) {
            intent.putExtra(EXTRA_MESSAGE, "you win!");
            startActivity(intent);
        }
    }
}