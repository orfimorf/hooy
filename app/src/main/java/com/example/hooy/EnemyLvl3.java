package com.example.hooy;

public class EnemyLvl3 extends EnemyLvl2{
    Double healRegen;

    EnemyLvl3(String name, Double healPoint, Double attack,Double armorPoint,Double healRegen){
        super(name,healPoint,attack,armorPoint);
        this.healRegen = healRegen;

    }

}
