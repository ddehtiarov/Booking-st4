package ua.nure.degtuaryov.SummaryTask4.db.entity;

/**
 * 
 * Station class entity from database, extends Entity
 * 
 * @author Degtuaryow
 *
 */
public class Station extends Entity {

	private static final long serialVersionUID = -838365072106070857L;
	
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Station [title=" + title + "]";
	}
}
