package database;

public class InsertionData {
	
	private String personID;
	private String fornavn;
	private String mellomnavn;
	private String etternavn;
	private String vei;
	private int husNr;
	private String poststed;
	private String epost;
	
	public InsertionData(){
		this.personID = new String();
		this.fornavn = new String();
		this.mellomnavn = new String();
		this.etternavn = new String();
		this.vei = new String();
		this.husNr = 0;
		this.poststed = new String();
		this.epost = new String();
	}
	
	public String getFornavn() {
		return fornavn;
	}
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	
	public String getPersonID() {
		return personID;
	}
	public void setPersonID(String personID) {
		this.personID = personID;
	}
	
	public String getMellomnavn() {
		return mellomnavn;
	}
	public void setMellomnavn(String mellomnavn) {
		this.mellomnavn = mellomnavn;
	}
	
	public String getEtternavn() {
		return etternavn;
	}
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	
	public String getVei() {
		return vei;
	}
	public void setVei(String vei) {
		this.vei = vei;
	}
	
	public int getHusNr() {
		return husNr;
	}
	public void setHusNr(int husNr) {
		this.husNr = husNr;
	}
	
	public String getPoststed() {
		return poststed;
	}
	public void setPoststed(String poststed) {
		this.poststed = poststed;
	}

	public String getEpost() {
		return epost;
	}

	public void setEpost(String epost) {
		this.epost = epost;
	} 

}
