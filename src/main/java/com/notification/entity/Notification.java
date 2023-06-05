package com.notification.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Notifications")
public class Notification {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column
	private long notification_id;
	@Column
	private String recipient_id;
		
	public Notification(){
	
	}

	public Notification(long notification_id, String recipient_id) {
		super();
		this.notification_id = notification_id;
		this.recipient_id = recipient_id;
	}

	public long getNotification_id() {
		return notification_id;
	}
	public void setNotification_id(long notification_id) {
		this.notification_id = notification_id;
	}

	public String getRecipient_id() {
		return recipient_id;
	}

	public void setRecipient_id(String recipient_id) {
		this.recipient_id = recipient_id;
	}
}


