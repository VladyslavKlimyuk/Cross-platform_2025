package Lab4.Models;

import Lab4.Interfaces.IPart;
import Lab4.Interfaces.IWorker;

public class Team {
    private IWorker[] workers;
    private TeamLeader teamLeader;

    public Team(IWorker[] workers, TeamLeader teamLeader) {
        this.workers = workers;
        this.teamLeader = teamLeader;
    }

    public void buildHouse(House house) {
        IPart[] parts = house.getParts();
        for (int i = 0; i < parts.length; i++) {
            workers[i % workers.length].doWork(parts[i]);
        }
        teamLeader.generateReport(house);
        System.out.println("Будівництво будинку завершено.");
    }
}
