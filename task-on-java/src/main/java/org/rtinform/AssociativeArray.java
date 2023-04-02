package org.rtinform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssociativeArray {

    private AssociativeArray() {}

    /**
     * Метод подсчитывает количество всех элементов списка и возвращает ассоциативный массив,
     * где ключ – элемент списка, значение – количество этих элементов в списке.
     * @param list список из элементов
     * @param <T> может быть любой класс (необходимо переопределить метод equals для корректности)
     * @exception RuntimeException исключение возникающее в случае если list = null либо пуст
     * @return результирующий массив
     */
    public static <T> Map<Object, Integer> getAssociativeArray(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new RuntimeException("List should not be null or empty");
        }
        Map<Object, Integer> result = new HashMap<>();
        list.forEach(element ->
                result.merge(element, 1, Integer::sum)
        );
        return result;
    }
}
