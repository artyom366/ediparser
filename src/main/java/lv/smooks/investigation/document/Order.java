package lv.smooks.investigation.document;


import java.util.List;

public class Order {
    private Header header;
    private List<OrderItem> orderItems;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String toString() {
        StringBuffer desc = new StringBuffer();

        desc.append("Order Header: \n");
        desc.append(header);
        desc.append("Order Items: \n");
        for(int i = 0; i < orderItems.size(); i++) {
            desc.append("\t" + "(" + i +  "): " + orderItems.get(i)).append("\n");
        }

        return desc.toString();
    }
}