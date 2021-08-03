package fr.ing.interview.message;

public class AccountVO {

	private long id;

	private String codeBanque;

	private String codeAgence;

	private String numeroDeCompte;

	private String cleRib;

	private String agenceDeDomiciliation;

	private String currency;

	public AccountVO() {
	}

	public AccountVO(final long id, final String codeBanque, final String codeAgence, final String numeroDeCompte,final  String cleRib,
			final String agenceDeDomiciliation, final String currency) {
		this.id = id;
		this.codeBanque = codeBanque;
		this.codeAgence = codeAgence;
		this.numeroDeCompte = numeroDeCompte;
		this.cleRib = cleRib;
		this.agenceDeDomiciliation = agenceDeDomiciliation;
		this.currency = currency;
	}

	/**
	 * @return the codeBanque
	 */
	public String getCodeBanque() {
		return codeBanque;
	}

	/**
	 * @param codeBanque the codeBanque to set
	 */
	public void setCodeBanque(final String codeBanque) {
		this.codeBanque = codeBanque;
	}

	/**
	 * @return the codeAgence
	 */
	public String getCodeAgence() {
		return codeAgence;
	}

	/**
	 * @param codeAgence the codeAgence to set
	 */
	public void setCodeAgence(final String codeAgence) {
		this.codeAgence = codeAgence;
	}

	/**
	 * @return the numeroDeCompte
	 */
	public String getNumeroDeCompte() {
		return numeroDeCompte;
	}

	/**
	 * @param numeroDeCompte the numeroDeCompte to set
	 */
	public void setNumeroDeCompte(final String numeroDeCompte) {
		this.numeroDeCompte = numeroDeCompte;
	}

	/**
	 * @return the cleRib
	 */
	public String getCleRib() {
		return cleRib;
	}

	/**
	 * @param cleRib the cleRib to set
	 */
	public void setCleRib(final String cleRib) {
		this.cleRib = cleRib;
	}

	/**
	 * @return the agenceDeDomiciliation
	 */
	public String getAgenceDeDomiciliation() {
		return agenceDeDomiciliation;
	}

	/**
	 * @param agenceDeDomiciliation the agenceDeDomiciliation to set
	 */
	public void setAgenceDeDomiciliation(final String agenceDeDomiciliation) {
		this.agenceDeDomiciliation = agenceDeDomiciliation;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
