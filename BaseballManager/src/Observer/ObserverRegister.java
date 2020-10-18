package Observer;

public interface ObserverRegister {
	public void registerObserver(MainObserver o);
	public void removeObserver(MainObserver o);
	public void notifyObservers();
}
