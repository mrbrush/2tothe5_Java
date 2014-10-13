public class NaiveInfectionModel {
    public enum Susceptibility {
        Susceptible,
        Infected,
        Removed
    }

    public void propagate(Susceptibility[][] population) {
        for(int i = 0; i < population.length; ++i) {
            for (int j = 0; j < population[0].length; ++j) {
                switch (population[i][j]) {
                    case Susceptible:
                        if (hasInfectedNeighbor(population, i, j))
                            population[i][j] = Susceptibility.Infected;
                        break;
                    case Infected:
                        if (Math.random() < 0.5) //Assuming 50% fatality rate
                            population[i][j] = Susceptibility.Removed;
                        break;
                }
            }
        }
    }

    boolean hasInfectedNeighbor(Susceptibility[][] population, int i, int j) {
        return (i > 0 && population[i-1][j] == Susceptibility.Infected) ||
               (i < population.length - 1 && population[i+1][j] == Susceptibility.Infected) ||
               (j > 0 && population[i][j-1] == Susceptibility.Infected) ||
               (j < population[0].length - 1 && population[i][j+1] == Susceptibility.Infected);
    }
}
