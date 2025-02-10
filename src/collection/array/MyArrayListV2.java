package collection.array;

import java.util.Arrays;

public class MyArrayListV2 {

    private static final int DEFAULT_CAPACITY = 5; // 기본 배열의 크기

    private  Object[] elementData; // 다양한 데이터 타입을 보관하기 위한 Object 배열
    private  int size = 0; // 리스트의 크기, 배열의 크기와 다르다

    public MyArrayListV2() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV2(int initialCapacity) { // 생성자
        elementData = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    // 리스트에 데이터 추가
    public void add(Object e) {
        // 코드추가
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = e;
        size++;
    }
    // 리스트 capacity 추가
    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;
        //배열을 새로 만들고 기존 배열을 새로운 배열에 복사
//        Object[] newArr = new Object[newCapacity];
//
//        for (int i = 0; i < elementData.length ; i++) {
//            newArr[i] = elementData[i]; // 기존 배열의 값을 새로운 배열에 복사
//        }
//        elementData = newArr; // 새로운 배열 참조, 기존 배열주소는 GC
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    // 인덱스 항목 조회
    public Object get(int index) {
        return  elementData[index];
    }

    // 인덱스 항목 변경
    public Object set(int index, Object element) {
        Object oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    // 리스트 순차 탐색 인수와 같은 데이터가 있는 인덱스 위치 검색
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if(o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {return Arrays.toString(Arrays.copyOf(elementData, size)) +
            " size=" + size + ", capacity=" + elementData.length;
    }
}
