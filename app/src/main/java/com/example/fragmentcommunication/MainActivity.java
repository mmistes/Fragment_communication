package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PublisherGetter{

    private final Publisher publisher = new Publisher();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Создание фрагментов
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        MainFragment mainFragment = new MainFragment();

        // Подписываем фрагменты, то есть сохраняем подписчиков в массив.
        //Именно эти фрагменты будут узнавать об изменениях
        publisher.subscribe(fragment1);
        publisher.subscribe(fragment2);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        // Добавляем фрагменты
        fragmentTransaction
                .add(R.id.fragment_main, mainFragment);
        fragmentTransaction
                .add(R.id.fragment_1, fragment1);
        fragmentTransaction
                .add(R.id.fragment_2, fragment2);
        //Закрываем транзакцию
        fragmentTransaction
                .commit();

    }

    // Снимем с activity обязанность по передаче событий классу Publisher.
    // Главный фрагмент будет использовать его для передачи событий
    @Override
    public Publisher getPublisher() {
        return publisher;
    }
}