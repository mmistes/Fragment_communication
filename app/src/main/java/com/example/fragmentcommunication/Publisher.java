package com.example.fragmentcommunication;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    //Все подписчики (Fragment1, Fragment2)
    private final List <Observer> observers;

    public Publisher() {
        observers = new ArrayList<>();
    }

    //Подписать кого-то на событие, т.е. сохранить в список с подписчиками
    public void  subscribe(Observer observer) {
        observers.add(observer);
    }

    //Отписать
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    // Разослать событие по подписчикам (изменение в тексте)
    public void notify (String text) {
        for (Observer observer: observers) {
            observer.updateText(text);
        }
    }

}
