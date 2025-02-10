package collection.array;

import java.util.Arrays;

public class MyArrayListV3 {

    private static final int DEFAULT_CAPACITY = 5; // 기본 배열의 크기

    private  Object[] elementData; // 다양한 데이터 타입을 보관하기 위한 Object 배열
    private  int size = 0; // 리스트의 크기, 배열의 크기와 다르다

    public MyArrayListV3() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV3(int initialCapacity) { // 생성자
        elementData = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    // 리스트 마지막에 데이터 추가
    public void add(Object e) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = e;
        size++;
    }
    // 코드 추가
    // 원하는 위치에 데이터 추가
    public  void add(int index, Object e) {
        if(size == elementData.length) {
            grow();
        }
        shiftRightFrom(index);
        elementData[index] = e;
        size++;
    }

    // 리스트 capacity 추가
    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    // 코드 추가
    // 요소의 마지막부터 index까지 오른쪽으로 밀기
    private void shiftRightFrom(int index) {
        for (int i = size; i > index ; i--) {
            elementData[i] = elementData[i - 1];
        }
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
    // 코드추가
    // 데이터 제거
    public Object remove(int index) {
        Object oldValue = get(index);
        shiftLeftFrom(index);

        size--;
        elementData[size] = null;
        return oldValue;
    }

    // 코드 추가
    // 요소의 index부터 마지막까지 왼쪽으로 밀기
    private void shiftLeftFrom(int index) {
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
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
