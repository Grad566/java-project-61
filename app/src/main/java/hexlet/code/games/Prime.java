package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static final int ROUNDS_COUNT = 3;
    public static final String RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    // запускаем игру
    public static void playPrime() {
        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        // генерируем массив из вопросов и ответов
        for (var i = 0; i < ROUNDS_COUNT; i++) {
            questionsAndAnswers[i] = generateRoundData();
        }
        Engine.playGame(questionsAndAnswers, RULE);
    }

    // Проверям простое ли число
    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (var i = 2; i <= (number / 2); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Генерируем вопрос и ответ на один раунд
    public static String[] generateRoundData() {
        final int maxRandomNumber = 200;

        String[] roundDate = new String[2];

        var randomNumber = Utils.getRandomNumber(maxRandomNumber);
        var correctAnswer = isPrime(randomNumber) ? "yes" : "no";

        roundDate[0] = String.valueOf(randomNumber);
        roundDate[1] = correctAnswer;

        return roundDate;
    }
}
