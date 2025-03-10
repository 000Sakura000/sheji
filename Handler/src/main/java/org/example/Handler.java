package org.example;

abstract class Handler {
    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public void handleRequest(int request) {
        if (canHandle(request)) {
            processRequest(request);
        } else if (next != null) {
            next.handleRequest(request);
        }
    }

    protected abstract boolean canHandle(int request);
    protected abstract void processRequest(int request);
}

class ConcreteHandler1 extends Handler {
    protected boolean canHandle(int request) {
        return request <= 10;
    }

    protected void processRequest(int request) {
        System.out.println("ConcreteHandler1 handled request " + request);
    }
}

class ConcreteHandler2 extends Handler {
    protected boolean canHandle(int request) {
        return request <= 20;
    }

    protected void processRequest(int request) {
        System.out.println("ConcreteHandler2 handled request " + request);
    }
}

class ConcreteHandler3 extends Handler {
    protected boolean canHandle(int request) {
        return request > 20;
    }

    protected void processRequest(int request) {
        System.out.println("ConcreteHandler3 handled request " + request);
    }
}
