package com.example.hooy;

import static android.service.autofill.Validators.or;
import static com.example.hooy.MainActivity.hero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CaveLevel1Slime extends AppCompatActivity {
    private ProgressBar mobHpBar, heroHpBar, heroManaBar;
    private TextView mobName;
    private ImageButton swordButton, healthButton, manaButton;
    private Enemy mob;
    private Hero hero = MainActivity.hero; // получаем героя
    private Double mobHp, heroHp, heroMana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();   // убираем навигацию
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        setContentView(R.layout.cave_level1_slime);   // загружаем весь контент на окно

        mobName = (TextView) findViewById(R.id.nameMobText);  // переменная для замены имен мобов

        mobHpBar = (ProgressBar) findViewById(R.id.hpMobBar);         // переменная для изм хп моба
        heroHpBar = (ProgressBar) findViewById(R.id.hpProgressBar);   // переменная для изм хп героя
        heroManaBar = (ProgressBar) findViewById(R.id.manaProgressBar); // переменная для изм маны героя

        heroHp = hero.getHealPoint();   // получаем макс хп героя
        heroMana = hero.getManaPoint(); // получаем макс ману героя

        swordButton = (ImageButton) findViewById(R.id.swordButton);    //ищем кнопку атаки на холсте
        healthButton = (ImageButton) findViewById(R.id.healthButton);    //ищем кнопку лечения на холсте
        manaButton = (ImageButton) findViewById(R.id.manaButton);    //ищем кнопку вост маны на холсте

        swordButton.setOnClickListener(new View.OnClickListener() { //обработчик нажатия кнопки атаки
            @Override
            public void onClick(View view) {
                try{
                    hero.attack(mob);
                    mob.attack(hero);

                }catch (Exception e){
                    System.out.println(e.getMessage());

                }
            }
        });

        healthButton.setOnClickListener(new View.OnClickListener() { //обработчик нажатия кнопки лечения
            @Override
            public void onClick(View view) {
                try{
                    hero.regHealthPoint();
                    mob.attack(hero);

                }catch (Exception e){
                    System.out.println(e.getMessage());

                }
            }
        });

        manaButton.setOnClickListener(new View.OnClickListener() { //обработчик нажатия кнопки вост маны
            @Override
            public void onClick(View view) {
                try{
                    hero.regManaPoint();
                    mob.attack(hero);

                }catch (Exception e){
                    System.out.println(e.getMessage());

                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<3 ;i++){
                    mob = MainActivity.enemiesLvl1.get(i);  // получаем моба
                    mobName.setText(mob.getName());  // вставляем название моба

                    mobHp =  mob.getHealPoint();    // получаем макс хп моба

                    while( (hero.getHealPoint() > 0) && (hero.getManaPoint()>0) &&
                            (mob.getHealPoint() > 0)){

                        mobHpBar.setProgress((int) ((mob.getHealPoint()*100)/mobHp));     // изм баров с хп и маной у всех
                        heroHpBar.setProgress((int) ((hero.getHealPoint()*100)/heroHp));
                        heroManaBar.setProgress((int) ((hero.getManaPoint()*100)/heroMana));

                    }
                    if (hero.getHealPoint()<=0){
                        // сделать окно и написать код
                        break;
                    }
                    else if (hero.getManaPoint()<=0){
                        // сделать окно и написать код
                    }
                    else if (mob.getHealPoint()<=0){
                        // сделать окно и написать код
                    }

                }

            }
        }).start();

    }
}