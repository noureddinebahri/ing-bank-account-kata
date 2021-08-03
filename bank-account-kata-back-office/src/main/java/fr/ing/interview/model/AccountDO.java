package fr.ing.interview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class AccountDO {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private Long id;

	@Column(name = "CODE_BANQUE")
	private String codeBanque;

	@Column(name = "CODE_AGENCE")
	private String codeAgence;

	@Column(name = "NUMERO_DE_COMPTE")
	private String numeroDeCompte;

	@Column(name = "CLE_RIB")
	private String cleRib;

	@Column(name = "AGENCE_DE_DOMICILIATION")
	private String agenceDeDomiciliation;

	@Column(name = "currency")
	private String currency;

	public AccountDO() {
	}

	public AccountDO(final Long id, final String codeBanque, final String codeAgence, final String numeroDeCompte,final  String cleRib,
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
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
