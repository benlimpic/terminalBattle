public class Human extends LifeForm {
  public final String ANSI_RED = "\u001B[31m";
  public final String ANSI_RESET = "\u001B[0m";

  public Human(String name, int health, int attack, int defense) {
    super(name, health, attack, defense);
  }

  @Override
  public void speak(String text) {
    System.out.println(ANSI_RED + text + ANSI_RESET);
  }

}
