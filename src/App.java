public class App {
    public static void main(String[] args) throws Exception {
        Human human = new Human("Human", 100, 10, 5);
        Alien alien = new Alien("Alien", 100, 10, 5);

        human.display();
        alien.display();
        human.startBattle(alien);
    }
}
