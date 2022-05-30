package com.k19.models;
import java.io.Serializable;
import java.util.ArrayList;

public class cartJPA {
    private ArrayList<lineItemJPA> items;
    public cartJPA() {
        items=new ArrayList<lineItemJPA>();
    }
    public ArrayList<lineItemJPA>getItems(){
        return items;
    }
    
    public int getCount(){
        return items.size();
    }
    public double getSum(){
        double price=0;
        for(int i=0;i<items.size();i++){
            lineItemJPA lineItem=items.get(i);
            price+=lineItem.getProduct().getPrice()*lineItem.getQuantity();
        }
        return price;

    }
    public void addItem(lineItemJPA item){
        String code=item.getProduct().getCode();
        int quantity=item.getQuantity();
        for(int i=0;i< items.size();i++){
            lineItemJPA lineItem=items.get(i);
            if(lineItem.getProduct().getCode().equals(code)){
                lineItem.setQuantity(lineItem.getQuantity()+ quantity);
                return;
            }
        }
        items.add(item);    
    }
    public void removeItem(lineItemJPA item) {
        String code = item.getProduct().getCode();
       
        for (int i = 0; i < items.size(); i++) {
            lineItemJPA lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }
    // public void setItems(ArrayList<lineItemJPA> items) {
    //     this.items = items;
    // }

    // member id
    // private int member_id;
    // // status : 1 Đang mua hàng, 2 Đã đặt đơn
    // private int status;

    // public cartJPA() {
    //     items = new ArrayList<lineItemJPA>();
    // }

    // public int getMember_id() {
    //     return member_id;
    // }

    // public void setMember_id(int member_id) {
    //     this.member_id = member_id;
    // }

    // public int getStatus() {
    //     return status;
    // }

    // public void setStatus(int status) {
    //     this.status = status;
    // }

    // public ArrayList<lineItemJPA> getItems() {
    //     // list of line item
    //     return items;
    // }

    // public int getCount() {
    //     return items.size();
    // }

    // public void addItem(lineItemJPA item) {
    //     String code = item.getProduct().getCode();
    //     int qty = item.getQty();
    //     for (int i = 0; i < items.size(); i++) {
    //         lineItemJPA lineItem = items.get(i);
    //         if (lineItem.getProduct().getCode().equals(code)) {
    //             lineItem.setQty(qty);
    //             return;
    //         }
    //     }
    //     items.add(item);
    // }

    // public void removeItem(lineItemJPA item) {
    //     String code = item.getProduct().getCode();
    //     for (int i = 0; i < items.size(); i++) {
    //         lineItemJPA lineItem = items.get(i);
    //         if (lineItem.getProduct().getCode().equals(code)) {
    //             items.remove(i);
    //             return;
    //         }
    //     }
    // }
}
