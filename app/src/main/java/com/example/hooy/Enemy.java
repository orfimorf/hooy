package com.example.hooy;

public class Enemy{
    String name;
    Double healPoint;
    Double attack;

    Enemy(String name, Double healPoint, Double attack){
        this.attack = attack;
        this.healPoint = healPoint;
        this.name = name;
    }
    Enemy(){}

    public void attack(Hero hero) {
        hero.healPoint = hero.healPoint - this.attack;
    }

    public Double getAttack(){
        return this.attack;
    }
    public Double getHealPoint(){
        return this.healPoint;
    }
    public String getName(){
        return this.name;
    }
}
