
class BusBay {

    int[] arr;
    int front;
    int size;
    int capacity;

    // Constructor
    BusBay(int capacity) {

        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        size = 0;
    }

    // Check if bay is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if bay is full
    public boolean isFull() {
        return size == capacity;
    }

    // Insert bus at front
    public boolean insertFront(int bus) {

        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            front = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }

        arr[front] = bus;
        size++;

        return true;
    }

    // Insert bus at rear
    public boolean insertLast(int bus) {

        if (isFull()) {
            return false;
        }

        int rear = (front + size) % capacity;

        arr[rear] = bus;
        size++;

        return true;
    }

    // Delete bus from front
    public boolean deleteFront() {

        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        size--;

        return true;
    }

    // Delete bus from rear
    public boolean deleteLast() {

        if (isEmpty()) {
            return false;
        }

        size--;

        return true;
    }

    // Get front bus
    public int getFront() {

        if (isEmpty()) {
            return -1;
        }

        return arr[front];
    }

    // Get rear bus
    public int getRear() {

        if (isEmpty()) {
            return -1;
        }

        int rear = (front + size - 1) % capacity;

        return arr[rear];
    }
}

public class q4 {

    public static void main(String[] args) {

        BusBay b = new BusBay(3);

        System.out.println(b.insertLast(101));
        System.out.println(b.insertLast(102));
        System.out.println(b.insertFront(100));

        System.out.println(b.insertFront(99));
        System.out.println(b.getRear());
        System.out.println(b.isFull());

        System.out.println(b.deleteLast());
        System.out.println(b.insertFront(98));
        System.out.println(b.getFront());
    }
}
