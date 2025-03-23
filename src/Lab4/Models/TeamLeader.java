package Lab4.Models;

import Lab4.Interfaces.IPart;
import Lab4.Interfaces.IWorker;

public class TeamLeader implements IWorker {
    private String name;

    public TeamLeader(String name) {
        this.name = name;
    }

    @Override
    public void doWork(IPart part) {
        System.out.println(name + "\nЗвіт про будівництво:");
    }

    public void generateReport(House house){
        IPart[] parts = house.getParts();
        for(IPart part: parts){
            System.out.println(part.getDescription()+": "+ (part.isBuilt() ? "Побудовано" : "Не побудовано"));
        }
    }
}
