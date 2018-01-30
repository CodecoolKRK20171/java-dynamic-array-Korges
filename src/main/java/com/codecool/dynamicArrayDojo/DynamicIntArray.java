package com.codecool.dynamicArrayDojo;

// put your code here!
public class DynamicIntArray {

    private static final int SIZE_FACTOR = 5;
    private int size;
    private Object[] dynamicArray;
    private int index;


    public DynamicIntArray() {

        this.size = SIZE_FACTOR;
        this.dynamicArray = new Object[SIZE_FACTOR];
    }


    public DynamicIntArray(int size) {

        this.size = size;
        dynamicArray = new Object[size];
    }


    public void add(Object element) {

        if(ifFreeSpace()) {
            increaseArraySize();
        }
        dynamicArray[index++] = element;
    }


    public boolean ifFreeSpace() {
        return index == size;
    }


    public void increaseArraySize() {

        this.size = size + 1;
        Object[] temp = new Object[size];

        for(int i=0;i<dynamicArray.length;i++) {
            temp[i]= dynamicArray[i];
        }
        this.dynamicArray = temp;
    }

    public Object get(int i) throws Exception {

        if(i>index - 1) {
            throw new Exception("ArrayIndexOutOfBound");
        } if (i<0) {
            throw new Exception("Negative Value");
        } else {
            return this.dynamicArray[i];
        }
    }


    public void insert(int position, Object element) {

        if(position>=size) {
            add(element);
        } else {
            this.size = size + 1;
            this.index = 0;
            Object[] temp = new Object[size];
            for(Object value: this.dynamicArray) {
                if(index == position) {
                    temp[index++] = element;
                }
                temp[index++] = value;
            }
            this.dynamicArray = temp;
        }
    }


    public void remove(Object element) {

        int i = 0;
        Object[] temp = new Object[--size];
        for(Object value : dynamicArray) {
            if(value!= element) {
                temp[i++] = value;
            }
        }
        this.dynamicArray = temp;
    }


    @Override
    public String toString() {


        StringBuilder builder = new StringBuilder();
        for (Object value : this.dynamicArray) {
            builder.append(" " + value);
        }
        return builder.toString();
    }
}
