package fr.ing.interview.enumeration;

import org.apache.commons.lang3.StringUtils;

public enum Currency {

	AFN("AFN","Afghanistan Afghani"),
	AED("AED","Arab Emirates Dirham"),
	ALL("ALL","Albanian Lek"),
	AMD("AMD","Armenian Dram"),
	AOA("AOA","Angolan Kwanza"),
	ARS("ARS","Argentine Peso"),
	AUD("AUD","Australian Dollar"),
	AWG("AWG","Aruban Guilder"),
	AZN("AZN","Azerbaijan New Manat"),
	BAM("BAM","Marka"),
	BBD("BBD","Barbados Dollar"),
	BDT("BDT","Bangladeshi Taka"),
	BGN("BGN","Bulgarian Lev"),
	BHD("BHD","Bahraini Dinar"),
	BIF("BIF","Burundi Franc"),
	BMD("BMD","Bermudian Dollar"),
	BND("BND","Brunei Dollar"),
	BOB("BOB","Boliviano"),
	BRL("BRL","Brazilian Real"),
	BSD("BSD","Bahamian Dollar"),
	BTN("BTN","Bhutan Ngultrum"),
	BWP("BWP","Botswana Pula"),
	BYR("BYR","Belarussian Ruble"),
	BZD("BZD","Belize Dollar"),
	CAD("CAD","Canadian Dollar"),
	CDF("CDF","Francs"),
	CHF("CHF","Swiss Franc"),
	CLP("CLP","Chilean Peso"),
	CNY("CNY","Yuan Renminbi"),
	COP("COP","Colombian Peso"),
	CRC("CRC","Costa Rican Colon"),
	CUP("CUP","Cuban Peso"),
	CVE("CVE","Cape Verde Escudo"),
	CZK("CZK","Czech Koruna"),
	DJF("DJF","Djibouti Franc"),
	DKK("DKK","Danish Krone"),
	DOP("DOP","Dominican Peso"),
	DZD("DZD","Algerian Dinar"),
	ECS("ECS","Ecuador Sucre"),
	EGP("EGP","Egyptian Pound"),
	ERN("ERN","Eritrean Nakfa"),
	ETB("ETB","Ethiopian Birr"),
	EUR("EUR","Euro"),
	FJD("FJD","Fiji Dollar"),
	FKP("FKP","Falkland Islands Pound"),
	GBP("GBP","Pound Sterling"),
	GEL("GEL","Georgian Lari"),
	GGP("GGP","Pound Sterling"),
	GHS("GHS","Ghanaian Cedi"),
	GIP("GIP","Gibraltar Pound"),
	GMD("GMD","Gambian Dalasi"),
	GNF("GNF","Guinea Franc"),
	GWP("GWP","Guinea-Bissau Peso"),
	GYD("GYD","Guyana Dollar"),
	HKD("HKD","Hong Kong Dollar"),
	HNL("HNL","Honduran Lempira"),
	HRK("HRK","Croatian Kuna"),
	HTG("HTG","Haitian Gourde"),
	HUF("HUF","Hungarian Forint"),
	IDR("IDR","Indonesian Rupiah"),
	ILS("ILS","Israeli New Shekel"),
	INR("INR","Indian Rupee"),
	IQD("IQD","Iraqi Dinar"),
	IRR("IRR","Iranian Rial"),
	ISK("ISK","Iceland Krona"),
	JMD("JMD","Jamaican Dollar"),
	JOD("JOD","Jordanian Dinar"),
	JPY("JPY","Japanese Yen"),
	KES("KES","Kenyan Shilling"),
	KGS("KGS","Som"),
	KHR("KHR","Kampuchean Riel"),
	KMF("KMF","Comoros Franc"),
	KPW("KPW","North Korean Won"),
	KRW("KRW","Korean Won"),
	KWD("KWD","Kuwaiti Dinar"),
	KYD("KYD","Cayman Islands Dollar"),
	KZT("KZT","Kazakhstan Tenge"),
	LAK("LAK","Lao Kip"),
	LBP("LBP","Lebanese Pound"),
	LKR("LKR","Sri Lanka Rupee"),
	LRD("LRD","Liberian Dollar"),
	LSL("LSL","Lesotho Loti"),
	LTL("LTL","Lithuanian Litas"),
	LVL("LVL","Latvian Lats"),
	LYD("LYD","Libyan Dinar"),
	MAD("MAD","Moroccan Dirham"),
	MDL("MDL","Moldovan Leu"),
	MGF("MGF","Malagasy Franc"),
	MKD("MKD","Denar"),
	MMK("MMK","Myanmar Kyat"),
	MNT("MNT","Mongolian Tugrik"),
	MOP("MOP","Macau Pataca"),
	MRO("MRO","Mauritanian Ouguiya"),
	MUR("MUR","Mauritius Rupee"),
	MVR("MVR","Maldive Rufiyaa"),
	MWK("MWK","Malawi Kwacha"),
	MXN("MXN","Mexican Nuevo Peso"),
	MYR("MYR","Malaysian Ringgit"),
	MZN("MZN","Mozambique Metical"),
	NAD("NAD","Namibian Dollar"),
	NGN("NGN","Nigerian Naira"),
	NIO("NIO","Nicaraguan Cordoba Oro"),
	NOK("NOK","Norwegian Krone"),
	NPR("NPR","Nepalese Rupee"),
	NZD("NZD","New Zealand Dollar"),
	OMR("OMR","Omani Rial"),
	PAB("PAB","Panamanian Balboa"),
	PEN("PEN","Peruvian Nuevo Sol"),
	PGK("PGK","Papua New Guinea Kina"),
	PHP("PHP","Philippine Peso"),
	PKR("PKR","Pakistan Rupee"),
	PLN("PLN","Polish Zloty"),
	PYG("PYG","Paraguay Guarani"),
	QAR("QAR","Qatari Rial"),
	QTQ("QTQ","Guatemalan Quetzal"),
	RON("RON","Romanian New Leu"),
	RSD("RSD","Dinar"),
	RUB("RUB","Russian Ruble"),
	RWF("RWF","Rwanda Franc"),
	SAR("SAR","Saudi Riyal"),
	SBD("SBD","Solomon Islands Dollar"),
	SCR("SCR","Seychelles Rupee"),
	SDG("SDG","Sudanese Pound"),
	SEK("SEK","Swedish Krona"),
	SGD("SGD","Singapore Dollar"),
	SHP("SHP","St. Helena Pound"),
	SLL("SLL","Sierra Leone Leone"),
	SOS("SOS","Somali Shilling"),
	SRD("SRD","Surinam Dollar"),
	SSP("SSP","South Sudan Pound"),
	STD("STD","Dobra"),
	SVC("SVC","El Salvador Colon"),
	SYP("SYP","Syrian Pound"),
	SZL("SZL","Swaziland Lilangeni"),
	THB("THB","Thai Baht"),
	TJS("TJS","Tajik Somoni"),
	TMT("TMT","Manat"),
	TND("TND","Tunisian Dollar"),
	TOP("TOP","Tongan Pa'anga"),
	TRY("TRY","Turkish Lira"),
	TTD("TTD","Trinidad and Tobago Dollar"),
	TWD("TWD","Taiwan Dollar"),
	TZS("TZS","Tanzanian Shilling"),
	UAH("UAH","Ukraine Hryvnia"),
	UGX("UGX","Uganda Shilling"),
	USD("USD","US Dollar"),
	UYU("UYU","Uruguayan Peso"),
	UZS("UZS","Uzbekistan Sum"),
	VEF("VEF","Venezuelan Bolivar"),
	VND("VND","Vietnamese Dong"),
	VUV("VUV","Vanuatu Vatu"),
	WST("WST","Samoan Tala"),
	XAF("XAF","CFA Franc BEAC"),
	XCD("XCD","East Caribbean Dollar"),
	XOF("XOF","CFA Franc BCEAO"),
	XPF("XPF","CFP Franc"),
	YER("YER","Yemeni Rial"),
	ZAR("ZAR","South African Rand"),
	ZMW("ZMW","Zambian Kwacha"),
	ZWD("ZWD","Zimbabwe Dollar");

	private String value;
	private String description;

	/**
	 * Default constructor.
	 * 
	 * @param value The Currency.
	 * @param description The description.
	 */
	private Currency(final String value, final String description) {
		this.value = value;
		this.value = description;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param textValue The Currency.
	 */
	public boolean equals(final String textValue) {
		return value.equals(textValue);
	}

	public static Currency fromString(final String textValue) {

		for (final Currency type : Currency.values()) {

			if (StringUtils.equalsIgnoreCase(type.name(), textValue)) {
				return type;
			}
		}

		return null;
	}
}
