package org.example;

interface State {
    void handleRequest();
}

class OnState implements State {
    public void handleRequest() {
        System.out.println("Turning the light off.");
    }
}

class OffState implements State {
    public void handleRequest() {
        System.out.println("Turning the light on.");
    }
}

class LightSwitch {
    private State state;

    public LightSwitch() {
        state = new OffState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void press() {
        state.handleRequest();
        if (state instanceof OffState) {
            setState(new OnState());
        } else {
            setState(new OffState());
        }
    }
}
