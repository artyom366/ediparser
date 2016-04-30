package lv.smooks.investigation.document;

import java.math.BigDecimal;
import java.util.Date;

public class Header {
    private String orderId;
    private long orderStatus;
    private BigDecimal netAmount;
    private BigDecimal totalAmount;
    private BigDecimal tax;
    private Date date;
    private Customer customer;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public long getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(long orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String toString() {
        StringBuffer desc = new StringBuffer();

        desc.append("\tCustomer: " + customer + "\n");
        desc.append("\tDate: " + date + "\n");
        desc.append("\tDetails: ID=" + orderId + ", Status=" + orderStatus + ", Total=" + totalAmount + "\n");

        return desc.toString();
    }
}