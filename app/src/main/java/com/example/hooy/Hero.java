package com.example.hooy;

import java.util.ArrayList;

public class Hero {
    Double healPoint;
    Double attack;
    Double manaPoint;
    Double manaPointRegen;
    Double healthPointRegen;


    Hero(Double healPoint, Double manaPoint, Double attack, Double manaPointRegen,Double healthPointRegen){
        this.attack = attack;
        this.healPoint = healPoint;
        this.manaPoint = manaPoint;
        this.manaPointRegen = manaPointRegen;
        this.healthPointRegen = healthPointRegen;
    }

    Hero(){}

    public Double getHealPoint(){
        return this.healPoint;
    }
    public Double getManaPoint(){
        return this.manaPoint;
    }
    public Double getAttack(){
        return this.attack;
    }

    public void setHealPoint(Double healPoint){
        this.healPoint = healPoint;
    }
    public void setManaPoint(Double manaPoint){
        this.manaPoint = manaPoint;
    }
    public void setAttack(Double attack){
        this.attack = attack;
    }

    public void regManaPoint(){
        this.manaPoint += manaPointRegen;
    }
    public void regHealthPoint(){
        this.healPoint += healthPointRegen;
        this.manaPoint -= 10;

    }

    public void attack(Enemy enemy) {
        enemy.healPoint = enemy.healPoint - this.attack;
    }

    public void attack(EnemyLvl2 enemy) {
        enemy.healPoint = enemy.healPoint - (this.attack - enemy.armorPoint);
    }

    public void attack(EnemyLvl3 enemy) {
        enemy.healPoint = enemy.healPoint - (this.attack - enemy.armorPoint);
        enemy.healPoint = enemy.healPoint + enemy.healRegen;
    }
}

