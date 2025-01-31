public class Alien extends LifeForm {
  public final String ANSI_GREEN = "\u001B[32m";
  public final String ANSI_RESET = "\u001B[0m";

  public Alien(String name, int health, int attack, int defense) {
    super(name, health, attack, defense);
  }

  @Override
  public void speak(String text) {
    System.out.println(ANSI_GREEN + text + ANSI_RESET);
  }
}
