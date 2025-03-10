package org.example;

import java.util.ArrayList;
import java.util.List;

interface NewsPublisher {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class NewsAgency implements NewsPublisher {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }
}

interface Observer {
    void update(String news);
}

class NewsSubscriber implements Observer {
    private String name;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}
