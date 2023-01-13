package com.example.hooy;

public class EnemyLvl2 extends Enemy{
    Double armorPoint;

    EnemyLvl2(String name, Double healPoint, Double attack,Double armorPoint){
        super(name,healPoint,attack);
        this.armorPoint = armorPoint;

    }
    EnemyLvl2(){}

}
