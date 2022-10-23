package capstone.merveozer.model.menu;

public class MenuItem implements Consumerable{

	private String name;
	private int consumeTimeMS;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getConsumeTimeMS() {
		return consumeTimeMS;
	}


	public MenuItem(String name, int consumeTimeMS) {
		super();
		this.name = name;
		this.consumeTimeMS = consumeTimeMS;
	}

	@Override
	public void setConsumeTime(int consumeTimeMS) {
		this.consumeTimeMS = consumeTimeMS;
	}

}
