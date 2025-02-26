import java.util.HashMap;
import java.util.Map;

//interface Flyweight - define os comportamentos comuns para os projéteis
interface Projectile {
    void display(int x, int y, String color);
}

//Concrete Flyweight
//essa classe armazena as propriedades intrísecas (de cada um projétil em especial)
class Bullet implements Projectile {
    private final String type;

    public Bullet() {
        this.type = "Bullet";
        System.out.println("Creating new Bullet instance...");
    }

    @Override
    public void display(int x, int y, String color) {
        System.out.println(type + " displayed at (" + x + ", " + y + ") with color " + color);
    }
}

class Missile implements Projectile {
    private final String type;

    public Missile() {
        this.type = "Missile";
        System.out.println("Creating new Missile instance...");
    }

    @Override
    public void display(int x, int y, String color) {
        System.out.println(type + " displayed at (" + x + ", " + y + ") with color " + color);
    }
}

// Flyweight Factory
// essa classe é responsável por criar e gerenciar os objetos Flyweight - ela reutiliza instancias já criadas
class ProjectileFactory {
    private static final Map<String, Projectile> projectiles = new HashMap<>();

    public static Projectile getProjectile(String type) {
        if (!projectiles.containsKey(type)) {
            switch (type) {
                case "Bullet":
                    projectiles.put(type, new Bullet());
                    break;
                case "Missile":
                    projectiles.put(type, new Missile());
                    break;
            }
        }
        return projectiles.get(type);
    }
}

//main
public class FlyweightGame {
    public static void main(String[] args) {
        Projectile bullet = ProjectileFactory.getProjectile("Bullet");
        bullet.display(10, 20, "red");

        Projectile missile = ProjectileFactory.getProjectile("Missile");
        missile.display(30, 40, "green");

        Projectile bullet2 = ProjectileFactory.getProjectile("Bullet");
        bullet2.display(50, 60, "blue");

        Projectile missile2 = ProjectileFactory.getProjectile("Missile");
        missile2.display(70, 80, "yellow");
    }
}

