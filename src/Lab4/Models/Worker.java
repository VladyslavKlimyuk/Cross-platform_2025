package Lab4.Models;

import Lab4.Interfaces.IPart;
import Lab4.Interfaces.IWorker;

public class Worker implements IWorker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void doWork(IPart part) {
        if (!part.isBuilt()) {
            part.build();
        } else {
            System.out.println(name + ": " + part.getDescription() + " вже побудовано.");
        }
    }
}
