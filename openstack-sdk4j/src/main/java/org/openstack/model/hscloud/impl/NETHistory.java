package org.openstack.model.hscloud.impl;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("net_history")
public class NETHistory implements Serializable {

	private long timestamp;

	@JsonProperty("rxspeed")
	private float rxSpeed;

	@JsonProperty("txspeed")
	private float txSpeed;

	/**
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the rxSpeed
	 */
	public float getRxSpeed() {
		return rxSpeed;
	}

	/**
	 * @param rxSpeed
	 *            the rxSpeed to set
	 */
	public void setRxSpeed(float rxSpeed) {
		this.rxSpeed = rxSpeed;
	}

	/**
	 * @return the txSpeed
	 */
	public float getTxSpeed() {
		return txSpeed;
	}

	/**
	 * @param txSpeed
	 *            the txSpeed to set
	 */
	public void setTxSpeed(float txSpeed) {
		this.txSpeed = txSpeed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CLASSNAME:NETHistory, " + ", net rx :" + this.rxSpeed
				+ ", net tx:" + this.txSpeed + "timestamp:"
				+ new Date(timestamp);
	}

}
