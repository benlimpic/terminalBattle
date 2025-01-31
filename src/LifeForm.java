public class LifeForm {

  public final String ANSI_YELLOW = "\u001B[33m";
  public final String ANSI_RESET = "\u001B[0m";
  
  // LIFEFORM ATTRIBUTES
    private String name;
    private int health;
    private int attack;
    private int defense;

    
  // LIFEFORM CONSTRUCTOR
    public LifeForm(String name, int health, int attack, int defense) {
      this.name = name;
      this.health = health;
      this.attack = attack;
      this.defense = defense;
    }

  //DISPLAY METHOD
    public void display() {
      String textBlock = "";
      textBlock += "Name: " + this.name + "\n";
      textBlock += "Health: " + this.health + "\n";
      textBlock += "Attack: " + this.attack + "\n";
      textBlock += "Defense: " + this.defense + "\n";
      textBlock += "--------------------------------" + "\n";
      speak(textBlock);
    }

  //PRINT METTHOD
    public void speak(String textBlock) {
      System.out.println(textBlock);
    }  

  //BATTLE METHODS
    public void startBattle(LifeForm target) {
      String textBlock = "";
      textBlock += this.name + " is battling " + target.name + "!" + "\n";
      textBlock += "--------------------------------" + "\n";
      stats(textBlock);
      battle(target);
    }

    public void battle(LifeForm target) {
      String textBlock = "";
      while (this.isAlive() && target.isAlive()) {
        this.attack(target);
        target.attack(this);
      }
      if (this.isAlive()) {
        textBlock += this.name + " wins!" + "\n";
      } else {
        textBlock += target.name + " wins!" + "\n";
      }
      textBlock += "--------------------------------" + "\n";
      stats(textBlock);
    }

  //ATTTACK METHODS

    public void attack(LifeForm target) {
      int damage = this.attack - target.defense;
      String textBlock = "";
        if (this.isAlive()) {

          if (damage < 0) {
            target.defense -= this.attack;
            textBlock += target.name + " has blocked " + this.name + "'s attack!" + "\n";
            textBlock += target.name + "'s Defensive points remaining: " + target.defense + "\n";
          } else {
            target.setDefense(0);
            target.health -= damage;
            textBlock += target.name + " has taken " + damage + " damage from " + this.name + "!" + "\n";
          }
          target.display();
        } else {
          textBlock += this.name + " Has Died......." + "\n";
      }
      textBlock += "--------------------------------" + "\n";

      stats(textBlock);
    }

  //CHECK METTHODS

  public boolean isAlive() {
    return this.health > 0;
  }

  //Talk Method
  public void stats(String textBlock) {
    System.out.println(ANSI_YELLOW + textBlock + ANSI_RESET);
  }

  //GETTERS

  public String getName() {
    return this.name;
  }

  public int getHealth() {
    return this.health;
  }

  public int getAttack() {
    return this.attack;
  }

  public int getDefense() {
    return this.defense;
  }

  //SETTTERS
  public void setName(String name) {
    this.name = name;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void setAttack(int attack) {
    this.attack = attack;
  }

  public void setDefense(int defense) {
    this.defense = defense;
  }

}
