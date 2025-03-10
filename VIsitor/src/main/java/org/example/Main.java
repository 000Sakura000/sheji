interface Visitor {
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}

interface Element {
    void accept(Visitor visitor);
}

class ConcreteElementA implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class ConcreteElementB implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class ConcreteVisitor implements Visitor {
    public void visit(ConcreteElementA element) {
        System.out.println("Processing ConcreteElementA");
    }
    public void visit(ConcreteElementB element) {
        System.out.println("Processing ConcreteElementB");
    }
}

class ObjectStructure {
    private java.util.List<Element> elements = new java.util.ArrayList<>();
    public void addElement(Element e) {
        elements.add(e);
    }
    public void acceptAll(Visitor visitor) {
        for (Element e : elements) {
            e.accept(visitor);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.addElement(new ConcreteElementA());
        os.addElement(new ConcreteElementB());
        Visitor visitor = new ConcreteVisitor();
        os.acceptAll(visitor);
    }
}