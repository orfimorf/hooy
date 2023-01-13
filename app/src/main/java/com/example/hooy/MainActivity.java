package com.example.hooy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static Hero hero = new Hero(100.0, 100.0,
            10.0, 15.0,20.0);      // \/Герой и враги\/
    public static ArrayList<Enemy> enemiesLvl1 = new ArrayList<Enemy>();
    public static ArrayList<EnemyLvl2> enemiesLvl2 = new ArrayList<EnemyLvl2>();
    public static ArrayList<EnemyLvl3> enemiesLvl3 = new ArrayList<EnemyLvl3>();  // /\Герой и враги/\



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_main);

        enemiesLvl1.add(new Enemy("Slime", 50.0, 5.0));
        enemiesLvl2.add(new EnemyLvl2("Armored slime", 100.0, 15.0, 5.0));                        // Cлизь
        enemiesLvl3.add(new EnemyLvl3("King slime", 150.0, 15.0, 5.0, 2.0));

        enemiesLvl1.add(new Enemy("Skelet", 50.0, 15.0));
        enemiesLvl2.add(new EnemyLvl2("Armored skelet", 75.0, 35.0, 15.0));                       // Скелеты
        enemiesLvl3.add(new EnemyLvl3("King skelet", 125.0, 35.0, 15.0, 5.0));

        enemiesLvl1.add(new Enemy("Golem", 100.0, 10.0));
        enemiesLvl2.add(new EnemyLvl2("Fire Golem", 150.0, 25.0, 20.0));                       // Големы
        enemiesLvl3.add(new EnemyLvl3("Haos Golem", 200.0, 35.0, 30.0, 10.0));


        ImageButton buttonStart = (ImageButton) findViewById(R.id.startButton);                                //кнопка новой игры\/
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(MainActivity.this, CaveLevel1Slime.class);
                    startActivity(intent);finish();
                }catch (Exception e){
                    System.out.println(e.getMessage());

                }
            }
        });                                                                                                      //кнопка новой игры/\



    }
}