package com.pb.gvozdev.hw10;

public class NumBox<T extends Number> {

    public final T[] arrayObj;

    public NumBox(int maxlength) {
        arrayObj = (T[]) new Number[maxlength];
    }

    public void add(T num) {
        try {
            for (int i = 0; i <= arrayObj.length; i++) {
                if (arrayObj[i] == null) {
                    arrayObj[i] = num;
                    break;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("!StackOverflow!..." + e.getMessage());
        }
    }

    public T get(int index) {
        return arrayObj[index];
    }

    public int length() {
        return arrayObj.length;
    }

    public double average() {
        return sum() / arrayObj.length;
    }

    public double sum() {
        double result = 0;
        for (T obj : arrayObj) {
            if (obj instanceof Integer) {
                result += obj.intValue();
            }
            if (obj instanceof Double) {
                result += obj.doubleValue();
            }
            if (obj instanceof Float) {
                result += obj.floatValue();
            }
        }
        return result;
    }

    public T max() {
        Double max = 0.0;
        Integer max2 = 0;
        Float max3 = 0.0f;
        for (T t : arrayObj) {
            if (t instanceof Integer) {
                if ((Integer) t > max2) {
                    max2 = (Integer) t;
                }
            }
            if (t instanceof Double) {
                if ((Double) t > max) {
                    max = (Double) t;
                }
            }
            if (t instanceof Float) {
                if ((Float) t > max3) {
                    max3 = (Float) t;
                }
            }
        }
        if (max > 0.0) {
            return (T) max;
        }
        if (max2 > 0) {
            return (T) max2;
        }
        if (max3 > 0.0f) {
            return (T) max3;
        }
        return null;
    }

}


