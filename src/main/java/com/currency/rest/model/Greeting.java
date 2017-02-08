/**
 * 
 */
package com.currency.rest.model;

import java.io.Serializable;

/**
 * This class is the model class to send the welcome greeting.
 * 
 * @author Macbook pro
 *
 */
public class Greeting implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private String content;

	public Greeting(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Greeting [content=" + content + "]";
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
		result = prime * result + ((content == null) ? 0 : content.hashCode());
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
		Greeting other = (Greeting) obj;
		if (content == null) {
			if (other.content != null) {
				return false;
			}
		} else if (!content.equals(other.content)) {
			return false;
		}
		return true;
	}

}