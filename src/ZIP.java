import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ZIP {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        // 1. Отримуємо ітератори з кожного стріму
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        // 2. Створюємо власний ітератор, який чергує елементи з двох стрімів
        Iterator<T> zippedIterator = new Iterator<>() {
            private boolean toggle = true; // Перемикач для чергування між стрімами

            @Override
            public boolean hasNext() {
                // 3. Стрім закінчується, якщо хоча б один з ітераторів більше не має елементів
                return firstIterator.hasNext() && secondIterator.hasNext();
            }

            @Override
            public T next() {
                // 4. Якщо елементів більше немає, викидаємо виняток
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements");
                }
                // 5. Перемикач чергує між ітераторами: true -> second, false -> first
                toggle = !toggle;
                return toggle ? firstIterator.next() : secondIterator.next();
            }
        };

        // 6. Створюємо Iterable на основі нашого ітератора
        Iterable<T> iterable = () -> zippedIterator;

        // 7. Перетворюємо Iterable у Stream через StreamSupport і повертаємо
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
