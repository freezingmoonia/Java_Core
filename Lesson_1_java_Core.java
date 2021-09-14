public class Lesson_1_java_Core {

    //Долго думала как объединять разные объекты в массив, java упорно не давала мне это сделать,
    //в итоге пришлось использовать "extended"

    public static void main(String[] args) {

        Race[] race = new Race[6];             //Измерения в "метрах"
        race[0] = new Track(100);
        race[1] = new Wall(1);
        race[2] = new Track(350);
        race[3] = new Wall(2);
        race[4] = new Track(900);
        race[5] = new Wall(3);

        Runner[] runners = new Runner[6];
        runners[0] = new Cat(200,2, "Кот Вася");
        runners[1] = new Cat(300,3, "Кот Барсик");
        runners[2] = new Human(900,1, "Коля");
        runners[3] = new Human(3000,1, "Ваня");
        runners[4] = new Robot(1000,3, "Робот Фёдор");
        runners[5] = new Robot(50000,10, "Терминатор");

        for (int i = 0; i < runners.length; i++) {
            Runner.gogogo(runners[i], race);
        }

        System.out.println("Дошли до конца: ");
        for (int i = 0; i < runners.length; i++) {
            if (runners[i].loose == false) {
                System.out.println(runners[i].name + " ");
            }
        }
    }

    public static class Runner {
        public int max_run_length;
        public int jump_high;
        public String name;
        public boolean loose;

        public Runner() {
        }

        public void run(Runner r, int l) {
            if (r.max_run_length >= l) {
                System.out.println(r.name + " пробежал беговую дорожку в "
                        + l + " метров");
            } else {
                System.out.println(r.name + " не смог пробежать беговую дорожку "
                        + l + " метров, так как слишком большая дистанция");
                r.loose = true;
            }
        }

        public void jump(Runner r, int h) {
            if (r.jump_high >= h) {
                System.out.println(r.name + " перепрыгнул через препятствие в "
                        + h + " метров");
            } else {
                System.out.println(r.name + " не смог перепрыгнуть через препятствые в "
                        + h + " метров, так как слишком большая высота");
                r.loose = true;
            }
        }
        public static void gogogo(Runner r, Race[] t) {
            for (int i = 0; i < t.length; i++) {
                if (t[i].getClass().equals(Track.class) == true) {   //проверяем - принадлежит ли объект классу к "Track"
                    r.run(r, t[i].length);
                } else {
                    r.jump(r, t[i].length);
                }
                if (r.loose == true) {
                    System.out.println(r.name + " сошел с с испытания из-за не удачи");
                    break;
                }
            }
        }
    }

    public static class Robot extends Runner {

        public Robot(int max_run_length, int jump_high ,String name) {
            this.max_run_length = max_run_length;
            this.jump_high = jump_high;
            this.name = name;
        }
    }

    public static class Human extends Runner {

        public Human(int max_run_length, int jump_high ,String name) {
            this.max_run_length = max_run_length;
            this.jump_high = jump_high;
            this.name = name;
        }
    }

    public static class Cat extends Runner {

        public Cat(int max_run_length, int jump_high ,String name) {
            this.max_run_length = max_run_length;
            this.jump_high = jump_high;
            this.name = name;
        }
    }

    public static class Race {
        public int length;

        public Race(int length) {
            this.length = length;
        }
    }

    public static class Track extends Race {

        public Track(int length) {
            super(length);
        }
    }

    public static class Wall extends Race {

        public Wall(int length) {
            super(length);
        }
    }
}