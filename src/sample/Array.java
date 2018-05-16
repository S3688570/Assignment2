package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Array extends Person{
    //Created by Charles Galea (March 2018)
    static ArrayList<Person> list = new ArrayList<>();

 /*       @Override
        public void addListener(ListChangeListener<? super Person> listener) {

        }

        @Override
        public void removeListener(ListChangeListener<? super Person> listener) {

        }

        @Override
        public boolean addAll(Person... elements) {
            return false;
        }

        @Override
        public boolean setAll(Person... elements) {
            return false;
        }

        @Override
        public boolean setAll(Collection<? extends Person> col) {
            return false;
        }

        @Override
        public boolean removeAll(Person... elements) {
            return false;
        }

        @Override
        public boolean retainAll(Person... elements) {
            return false;
        }

        @Override
        public void remove(int from, int to) {

        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Person> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Person person) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Person> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Person> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Person get(int index) {
            return null;
        }

        @Override
        public Person set(int index, Person element) {
            return null;
        }

        @Override
        public void add(int index, Person element) {

        }

        @Override
        public Person remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Person> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Person> listIterator(int index) {
            return null;
        }

        @Override
        public List<Person> subList(int fromIndex, int toIndex) {
            return null;
        }

        @Override
        public void addListener(InvalidationListener listener) {

        }

        @Override
        public void removeListener(InvalidationListener listener) {

        }
    };  */

    public Array() {
    }

    public Array(String name, String image, String status, String gender, String age, String state) {
        super(name, image, status, gender, age, state);
    }

 /*   public Array(ObservableList list) {
        this.list = list;
    }  */

    //Load array
    public void loadArray() {
        Scanner input = null;
        String line = null;

        try {
            input = new Scanner(new File("C:\\Data\\Database2.txt"));
            while (input.hasNextLine()) {
                String data[] = input.nextLine().split(",");
                list.add(new Person(data[0], data[1], data[2], data[3], data[4], data[5]));
            }

        } catch (FileNotFoundException e) {
            System.err.println("No Such File.");
            System.exit(0);
        }

        input.close();
    }

    //Print the social network
    public void printArray() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
            System.out.println();
        }
    }

//    TODO-me Add method to print single profile
}


