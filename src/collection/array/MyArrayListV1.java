package collection.array;

import java.util.Arrays;

public class MyArrayListV1 {

    private static final int DEFAULT_CAPACITY = 5; // 기본 배열의 크기

    private  Object[] elementData; // 다양한 데이터 타입을 보관하기 위한 Object 배열
    private  int size = 0; // 리스트의 크기, 배열의 크기와 다르다

    public MyArrayListV1() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV1(int initialCapacity) { // 생성자
        elementData = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    // 리스트에 데이터 추가
    public void add(Object e) {
        elementData[size] = e;
        size++;
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
                return 1;
            }
        }
        return -1;
    }

    public String toString() {return Arrays.toString(Arrays.copyOf(elementData, size)) +
            " size=" + size + ", capacity=" + elementData.length;
    }
}
