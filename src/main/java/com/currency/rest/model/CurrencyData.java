/**
 * 
 */
package com.currency.rest.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is the model class for the currency data, which will be retrieved
 * from the Queue.
 * 
 * @author Macbook pro
 *
 */
public class CurrencyData implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("currencyFrom")
	private String currencyFrom;

	@JsonProperty("currencyTo")
	private String currencyTo;

	@JsonProperty("amountSell")
	private Integer amountSell;

	@JsonProperty("amountBuy")
	private Double amountBuy;

	@JsonProperty("rate")
	private Double rate;

	@JsonProperty("timePlaced")
	private String timePlaced;

	@JsonProperty("originatingCountry")
	private String originatingCountry;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("userId")
	public String getUserId() {
		return userId;
	}

	@JsonProperty("userId")
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@JsonProperty("currencyFrom")
	public String getCurrencyFrom() {
		return currencyFrom;
	}

	@JsonProperty("currencyFrom")
	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	@JsonProperty("currencyTo")
	public String getCurrencyTo() {
		return currencyTo;
	}

	@JsonProperty("currencyTo")
	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	@JsonProperty("amountSell")
	public Integer getAmountSell() {
		return amountSell;
	}

	@JsonProperty("amountSell")
	public void setAmountSell(Integer amountSell) {
		this.amountSell = amountSell;
	}

	@JsonProperty("amountBuy")
	public Double getAmountBuy() {
		return amountBuy;
	}

	@JsonProperty("amountBuy")
	public void setAmountBuy(Double amountBuy) {
		this.amountBuy = amountBuy;
	}

	@JsonProperty("rate")
	public Double getRate() {
		return rate;
	}

	@JsonProperty("rate")
	public void setRate(Double rate) {
		this.rate = rate;
	}

	@JsonProperty("timePlaced")
	public String getTimePlaced() {
		return timePlaced;
	}

	@JsonProperty("timePlaced")
	public void setTimePlaced(String timePlaced) {
		this.timePlaced = timePlaced;
	}

	@JsonProperty("originatingCountry")
	public String getOriginatingCountry() {
		return originatingCountry;
	}

	@JsonProperty("originatingCountry")
	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CurrencyData [userId=" + userId + ", currencyFrom=" + currencyFrom + ", currencyTo=" + currencyTo
				+ ", amountSell=" + amountSell + ", amountBuy=" + amountBuy + ", rate=" + rate + ", timePlaced="
				+ timePlaced + ", originatingCountry=" + originatingCountry + ", additionalProperties="
				+ additionalProperties + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additionalProperties == null) ? 0 : additionalProperties.hashCode());
		result = prime * result + ((amountBuy == null) ? 0 : amountBuy.hashCode());
		result = prime * result + ((amountSell == null) ? 0 : amountSell.hashCode());
		result = prime * result + ((currencyFrom == null) ? 0 : currencyFrom.hashCode());
		result = prime * result + ((currencyTo == null) ? 0 : currencyTo.hashCode());
		result = prime * result + ((originatingCountry == null) ? 0 : originatingCountry.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		result = prime * result + ((timePlaced == null) ? 0 : timePlaced.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CurrencyData other = (CurrencyData) obj;
		if (additionalProperties == null) {
			if (other.additionalProperties != null) {
				return false;
			}
		} else if (!additionalProperties.equals(other.additionalProperties)) {
			return false;
		}
		if (amountBuy == null) {
			if (other.amountBuy != null) {
				return false;
			}
		} else if (!amountBuy.equals(other.amountBuy)) {
			return false;
		}
		if (amountSell == null) {
			if (other.amountSell != null) {
				return false;
			}
		} else if (!amountSell.equals(other.amountSell)) {
			return false;
		}
		if (currencyFrom == null) {
			if (other.currencyFrom != null) {
				return false;
			}
		} else if (!currencyFrom.equals(other.currencyFrom)) {
			return false;
		}
		if (currencyTo == null) {
			if (other.currencyTo != null) {
				return false;
			}
		} else if (!currencyTo.equals(other.currencyTo)) {
			return false;
		}
		if (originatingCountry == null) {
			if (other.originatingCountry != null) {
				return false;
			}
		} else if (!originatingCountry.equals(other.originatingCountry)) {
			return false;
		}
		if (rate == null) {
			if (other.rate != null) {
				return false;
			}
		} else if (!rate.equals(other.rate)) {
			return false;
		}
		if (timePlaced == null) {
			if (other.timePlaced != null) {
				return false;
			}
		} else if (!timePlaced.equals(other.timePlaced)) {
			return false;
		}
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		return true;
	}

}
