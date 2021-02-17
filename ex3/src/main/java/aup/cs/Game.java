package aup.cs;

/**
 * The Roulette game
 */
public class Game {
  private Table table;
  private Wheel wheel;

  /**
   * Simulating one round of the game
   * @param player is the playing player
   */
  public void cycle(Player player) {
    player.placeBets(table);
    Bin winningBin = Wheel.spin();
    player.observeWinningBin(winningBin);
    table.removeBets();
  }
}
