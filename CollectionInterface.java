public interface CollectionInterface<T> {
    boolean add(T element);
    T get(T target);
    Boolean contains(T target);
    boolean remove(T target);
    boolean isFull();
    boolean isEmpty();
    Integer size();
}
