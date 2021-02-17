package aup.cs;

public class Simulation {

  private Game game;
  private Player player;

  public static void main(String[] args) {
    Simulation sim = new Simulation(new Game(), new Player());
    Statistics stats = sim.simulate();
    System.out.println(stats.toString());
  }

  public Simulation(Game game, Player player) {
    this.game = game;
    this.player = player;
  }

  /**
   * Simulating many instances of a player playing the game
   * @return the stats of the simulation
   */
  private Statistics simulate() {
    Statistics stats = new Statistics();

    for (int i=0; i<stats.getNumCycles(); i++) {
      session(stats);
    }

    return stats;
  }

  /**
   * Simulating one instance of the player playing a sequence of games
   * @param stats the stats are going to be updated with the information of the session
   */
  private void session(Statistics stats) {
    int numRounds = 0;
    while (player.isPlaying()) {
      game.cycle(player);
      numRounds++;
    }
    stats.recordSession(numRounds, player.getStake());
    player.reset();
  }
}
