package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    // выводим привественное сообщение
    // запускаем игру
    public static void playProgression() {
        final int maxStepProgression = 8;

        Engine.cheers();

        System.out.println("What number is missing in the progression?");

        String[][] questionsAndAnswers = new String[Engine.getCountOfQuestions()][2];

        // генерируем массив из вопросов и ответов
        for (var i = 0; i < Engine.getCountOfQuestions(); i++) {
            var step = Engine.getRandomNumber(maxStepProgression);
            // получаем случайный массив с арифм. прогр.
            String[] randomArray = getRandomArray(step);
            // получаем номер элемента для замены
            var randomIndex = Engine.getRandomNumber(randomArray.length - 1);
            // записываем верный ответ
            var correctAnswer = randomArray[randomIndex];
            // получаем массив, который покажем пользователю
            randomArray = getArrayForUser(randomArray, randomIndex);
            String arrayAsString = String.join(" ", randomArray);

            questionsAndAnswers[i][0] = arrayAsString;
            questionsAndAnswers[i][1] = correctAnswer;
        }
        Engine.playGame(questionsAndAnswers);
    }
    // меняем один элемент на ".."
    public static String[] getArrayForUser(String[] arrayNumbers, int randomIndex) {
        arrayNumbers[randomIndex] = "..";
        return arrayNumbers;
    }

    // получаем случайный массив с ариф. прогрессией
    public static String[] getRandomArray(int step) {
        final int maxInitialNumber = 100;
        var initialNumber = Engine.getRandomNumber(maxInitialNumber);
        final int minLength = 5;
        final int averageArrayLength = 10;
        String[] arrayNumbers = new String[Engine.getRandomNumber(averageArrayLength) + minLength];
        var arrayLength = arrayNumbers.length;

        for (var i = 0; i < arrayLength; i++) {
            arrayNumbers[i] = String.valueOf(initialNumber);
            initialNumber += step;
        }
        return arrayNumbers;
    }
}
