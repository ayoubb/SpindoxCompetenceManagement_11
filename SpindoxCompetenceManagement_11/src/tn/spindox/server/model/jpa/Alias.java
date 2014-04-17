package tn.spindox.server.model.jpa;

public class Alias {
	
	private int id_alias;
	private String original_name;
	private String alias;
	public int getId_alias() {
		return id_alias;
	}
	public void setId_alias(int id_alias) {
		this.id_alias = id_alias;
	}
	public String getOriginal_name() {
		return original_name;
	}
	public void setOriginal_name(String original_name) {
		this.original_name = original_name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Alias(int id_alias, String original_name, String alias) {
		super();
		this.id_alias = id_alias;
		this.original_name = original_name;
		this.alias = alias;
	}
	
	public Alias(){
		
	}

}
