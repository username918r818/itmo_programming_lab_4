import com.username918r818.lab4.entities.*;
import com.username918r818.lab4.exceptions.*;
import com.username918r818.lab4.locations.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        House house = new House();
        Location outside = new Location() {
            private ArrayList<Entity> entities = new ArrayList<Entity>();

            public String getAddress() {
                return "Outside";
            }

            public void getIn(Entity entity, int x, int y, int z) throws OutOfBounds {

                if (!this.entities.contains(entity)) {
                    this.entities.add(entity);
                }
            }

            public void getOut(Entity entity) {
                if (this.entities.contains(entity)) {
                    this.entities.remove(entity);
                }
            }

            public Entity find(String name) {
                for (Entity a : entities) {
                    if (a.getName().equals(name)) {
                        return a;
                    }
                }
                return null;
            }
        };

        Shortman vintik = new Shortman("Vintik", outside, 0, 0, 0, Trait.ILL);
        Shortman shpuntik = new Shortman("Shpuntik", outside, 0, 0, 0, Trait.HEALTHY);
        Shortman ponchik = new Shortman("Ponchik", outside, 0, 0, 0, Trait.TRICKY);

        Bed bed = new Bed(house, 5, 5, 1);
        Manager pilulkin = new Manager("Pilulkin", house, 5, 5, 1, Trait.HEALTHY);
        pilulkin.orderToMove(vintik, bed);
        pilulkin.orderToBring(ponchik, vintik);
        pilulkin.orderToBring(shpuntik, vintik);
        bed.layDown(vintik);

        Campfire campfire = new Campfire(outside, 1, 2, 0);
        pilulkin.orderToMove(shpuntik, campfire);
        pilulkin.orderToMove(ponchik, campfire);
        pilulkin.move(1, 2, 0, outside);

        Container plate1 = new Container(house);
        Container teapot2 = new Container("Super Teapot", outside, 1, 2, 3);

        class Soup implements Food {
        }

        class Porridge implements Food {
        }

        class cranberryJelly implements Food {
        }

        shpuntik.get("Super Teapot");
        Campfire.Cookbook.cook(new Soup());
        shpuntik.fill(teapot2, Campfire.Cookbook.pourFrom());
        shpuntik.move(0, 0, 0, house);
        shpuntik.give(vintik);
        vintik.eat(teapot2);

        shpuntik.get(plate1.getName());
        // System.out.println(shpuntik.grabbed);
        Campfire.Cookbook.cook(new Porridge());
        shpuntik.fill(plate1, Campfire.Cookbook.pourFrom());
        shpuntik.move(0, 0, 0, house);
        vintik.drop();
        shpuntik.give(vintik);
        vintik.eat(plate1);
        vintik.drop();
        // System.out.println(shpuntik.grabbed);
        shpuntik.get(teapot2);
        // System.out.println(shpuntik.grabbed);
        pilulkin.orderToMove(shpuntik, campfire);
        Campfire.Cookbook.cook(new cranberryJelly());
        shpuntik.fill(teapot2, Campfire.Cookbook.pourFrom());
        shpuntik.move(0, 0, 0, house);
        shpuntik.give(vintik);
        vintik.eat(teapot2);
    }
}
