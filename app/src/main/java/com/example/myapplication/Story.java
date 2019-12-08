package com.example.myapplication;

public class Story {
    private  Situation start_story;
    public Situation current_situation;
    Story() {
        start_story = new Situation("Палата в лаборатории", "Вы проснулись в палате в лаборатории.\n" +
                "Вы ничего не помните. Вы видите три двери. Какую выбрать?",  3);
        start_story.direction[0] = new Situation("Левая палата", "Там оказалася страшный монстр.\n" +
                "Вас съели целиком.",  0);
        start_story.direction[1] = new Situation("Коридор", "Вы вышли из палаты в коридор. Вы видите три двери. Какую выбрать?",  3);
        start_story.direction[2] = new Situation("Правая палата", "Вы вошли в правую палату.\n" +
                "Вы не заметили, что там нет пола.\n" +
                "Вы упали и рассыпались на атомы.\n" +
                "Кто бы мог подумать, что в палате не будет пола?",  0);
        start_story.direction[1].direction[0] = new Situation("Левая дверь", "Вы открыли правую дверь и увидели много дырок.\n" +
                "Нет, вы не умерли от трипофобии.\n" +
                "Это оказались ловушки со стрелами.\n" +
                "Вас застрелили.", 0);
        start_story.direction[1].direction[1] = new Situation("Средняя дверь", "Поздравляю!\n" +
                "Вы обнаружили выход из этой лаборатории и Вам удалось выжить.", 0);
        start_story.direction[1].direction[2] = new Situation("Правая дверь", "Вы открыли дверь и увидели какую-то статую.\n" +
                "Вы моргнули.\n" +
                "Вам свернула шею эта статуя.", 0);
        current_situation = start_story;
    }

    public void go(int num) {
        if (num  <= current_situation.direction.length)
            current_situation = current_situation.direction[num - 1];
        else System.out.println("Вы можете выбирать из " + current_situation.direction.length + " вариантов");
    }
    public boolean isEnd() {
        return current_situation.direction.length == 0;
    }
}
