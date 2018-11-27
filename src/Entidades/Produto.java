package Entidades;


public class Produto {
	private int id;
	private String name;
	private String prec;
	
	public Produto() {
		
	}
	
	public Produto(int id, String name, String prec) {
		super();
		this.id = id;
		this.name = name;
		this.prec = prec;
	}
	
	public Produto(String name, String prec) {
		super();
		this.name = name;
		this.prec = prec;
	}
	

	public String getPrec() {
		return prec;
	}

	public void setPrec(String d) {
		this.prec = d;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Produto - ID : "+id+" nome " + name + " Preço =" + prec + ""+"\n";
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prec == null) ? 0 : prec.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

}
