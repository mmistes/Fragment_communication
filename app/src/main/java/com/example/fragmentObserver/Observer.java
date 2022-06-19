package com.example.fragmentObserver;

public interface Observer {
    // Наблюдатель, вызывается updateText, когда надо отправить событие по изменению текста
    void updateText(String text);
}
