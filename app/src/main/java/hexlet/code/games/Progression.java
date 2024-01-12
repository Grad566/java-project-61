package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    // запускает саму игру и привественное сообщение
    public static void playProgression() {
        var victory = true;

        Engine.cheers();

        System.out.println("What number is missing in the progression?");
        // выводим пользователю арифметическую прогрессию
        // если ответ ложный, прекращаем игру и выводим сообщение о проигрыше
        // повторяем трижды, либо до победы, либо до 1-го неправильного ответа
        for (var i = 0; i < 3; i++) {

            if (!victory) {
                break;
            }
            // получаем шаг арифметической прогрессии
            var step = Engine.getRandomNumber(8);
            // получаем случайный массив с арифм. прогр.
            String[] randomArray = getRandomArray(step);
            // получаем номер элемента для замены
            var randomIndex = Engine.getRandomNumber(randomArray.length - 1);
            // записываем верный ответ
            var correctAnswer = randomArray[randomIndex];
            // получаем массив, который покажем пользователю
            randomArray = getArrayForUser(randomArray, randomIndex);
            String arrayAsString = String.join(" ", randomArray);

            System.out.println("Question: "
                    + arrayAsString);

            victory = Engine.checkAnswer(correctAnswer);

        }
        // проверяме условие победы
        // выводим сообещние, если условие true
        Engine.checkVictory(victory);
    }

    // получаем массив случайной длины, внутри - случайная арифм. прогрессия
    public static String[] getRandomArray(int step) {
        var initialNumber = Engine.getRandomNumber(100);
        var minLength = 5;
        String[] arrayNumber = new String[Engine.getRandomNumber(10) + minLength];
        var arrayLength = arrayNumber.length;

        for (var i = 0; i < arrayLength; i++) {
            arrayNumber[i] = String.valueOf(initialNumber);
            initialNumber += step;
        }

        return  arrayNumber;
    }

    // меняем один элемент на ".."
    public static String[] getArrayForUser(String[] arrayNumber, int randomIndex) {
        arrayNumber[randomIndex] = "..";
        return arrayNumber;
    }
}
