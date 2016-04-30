package lv.smooks.investigation.document;

import java.math.BigDecimal;

public class OrderItem {
    private int quantity;
    private String productId;
    private BigDecimal price;
    private String title;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return "ProductID=" + productId + ", Quantity=" + quantity + ", Title='" + title + "', Price=" + price;
    }
}