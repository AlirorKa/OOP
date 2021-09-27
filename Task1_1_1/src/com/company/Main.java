package com.company;

public class Main
{
    /**
     * sort - функция для построения кучи
     * @param arr массив чисел подвергаемый пирамидальной сортровке
     */
    
    public void sort(int[] arr)
    {
        int n = arr.length;

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            sortHeap(arr, n, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру на уменьшенной куче
            sortHeap(arr, i, 0);
        }
    }

     /**
     * sortHeap - процедура преобразования поддерева в двоичную кучу с корнем i
     * @param arr сортируемый массив
     * @param n = длина массива
     * @param i идекс корня в куче на момент создания
     */
    void sortHeap (int[] arr, int n, int i)
    {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2*i + 1; // левый = 2*i + 1
        int r = 2*i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            sortHeap(arr, n, largest);
        }
    }
}
