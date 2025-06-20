package com.farmfresh.entity;



	import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "Item")
	public class Item {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "itemid")
		private long itemid;
		private String itemName;
		private String itemCategory;
		private double itemPrice;
		private double itemCount;
		public long getItemid() {
			return itemid;
		}
		public void setItemid(long itemid) {
			this.itemid = itemid;
		}
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		public String getItemCategory() {
			return itemCategory;
		}
		public void setItemCategory(String itemCategory) {
			this.itemCategory = itemCategory;
		}
		public double getItemPrice() {
			return itemPrice;
		}
		public void setItemPrice(double itemPrice) {
			this.itemPrice = itemPrice;
		}
		public double getItemCount() {
			return itemCount;
		}
		public void setItemCount(double itemCount) {
			this.itemCount = itemCount;
		}
		
		
	}


