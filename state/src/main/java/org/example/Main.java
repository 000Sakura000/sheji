package org.example;

public class Main {
    public static void main(String[] args) {
        LightSwitch lightSwitch = new LightSwitch();
        lightSwitch.press();
        lightSwitch.press();

        NewsAgency agency = new NewsAgency();
        Observer subscriber1 = new NewsSubscriber("Subscriber 1");
        Observer subscriber2 = new NewsSubscriber("Subscriber 2");

        agency.registerObserver(subscriber1);
        agency.registerObserver(subscriber2);

        agency.setNews("Breaking News: Java is awesome!");
        agency.removeObserver(subscriber2);
        agency.setNews("Update: Java is still awesome!");
    }
}