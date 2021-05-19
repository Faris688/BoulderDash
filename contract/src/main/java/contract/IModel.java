package contract;

import java.util.Observable;



/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the map and player.
	 *
	 * @return the map and player entity
	 */
	IMap getMap();
	
	IPlayer getPlayer();

	/**
	 * Load the map.
	 *
	 * @param code
	 *          the code
	 */
	void loadMap(String code);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
