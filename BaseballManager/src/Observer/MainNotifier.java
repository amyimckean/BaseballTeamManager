package Observer;

import java.util.ArrayList;
import java.util.List;

import Enums.ViewEnum;

public class MainNotifier {
	private List<MainObserver> observers;
	private ViewEnum value = ViewEnum.Main;
	
	public MainNotifier() {
		observers = new ArrayList<MainObserver>();
	}
	
	public void registerObserver(MainObserver o) {
		observers.add(o);
	}
	
	public void removeObserver(MainObserver o) {
		observers.remove(o);
	}
	
	public void notifyObservers() {
		for (MainObserver observer : observers) {
			observer.Update(value);
		}
	}
	
	public void setNotifierValue(ViewEnum view) {
		value = view;
	}
	
}
