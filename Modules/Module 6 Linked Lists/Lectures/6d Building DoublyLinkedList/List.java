public interface List<E> {
	public void add(E value);
   public void add(int index, E value);
   public E get(int index);
   public int indexOf(E value);
	public E remove(int index);
   public int size();
   public String toString();
}