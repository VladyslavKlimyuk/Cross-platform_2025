package Lab4;

import Lab4.Models.House;
import Lab4.Models.Team;
import Lab4.Models.TeamLeader;
import Lab4.Models.Worker;
import Lab4.Interfaces.IWorker;

public class Lab4_2 {
    public static void main(String[] args) {
        House house = new House();
        Worker worker1 = new Worker("Іван");
        Worker worker2 = new Worker("Петро");
        TeamLeader teamLeader = new TeamLeader("Сергій");
        IWorker[] workers = {worker1, worker2};
        Team team = new Team(workers, teamLeader);
        team.buildHouse(house);
    }
}
