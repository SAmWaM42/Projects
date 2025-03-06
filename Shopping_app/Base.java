
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.awt.*;

class item {
    public item(String name, String brand, String descrip, String cat, int price) {
        this.name = name;
        this.brand = brand;
        this.descrip = descrip;
        this.price = price;
        this.category = cat;

    }

    public item() {

    }

    public String category;
    public String name;
    public String brand;
    public String descrip;
    public int price;
}

class shoppinglist_item {
    public item items = new item();
    private int quantity;
    private int final_price;

    public shoppinglist_item(item Item, int quantity) {
        this.items = Item;
        this.quantity = quantity;
        set_final_price();

    }

    private void set_final_price() {
        final_price = items.price * quantity;
    }

    public int get_final_price() {

        return final_price;
    }

}

class shoppinglist 
{


    private ArrayList<shoppinglist_item> items = new ArrayList<shoppinglist_item>();
    public int end_price;
    JPanel list=new JPanel();

    public int get_end_price() {
        int ans = 0;
        for (int i = 0; i < this.items.size(); i++) {
            ans += items.get(i).get_final_price();
        }
        return ans;
    }

    public void add_item(shoppinglist_item a) {
        this.items.add(a);

    }

    public void remove_item(String name) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).items.name == name) {
                if (this.items.get(i).items.name == name) {
                    this.items.remove(this.items.get(i));
                }
            }

        }

    }
    public void display_items()
    {
    
    }
}
class shelf implements ItemListener
{
    private ArrayList<item> items = new ArrayList<item>();
    JComboBox<String> box=new JComboBox<String>();
    JTextField txtInput = new JTextField("Set quantity");
    private ArrayList<String> compare_list = new ArrayList<String>();
    shoppinglist list=new shoppinglist();

    public shelf()
    {
    }
    public void shelf_item(item a)
    {
        this.items.add(a);
        String value=a.name.concat(a.brand).concat(a.descrip); 
        this.box.addItem(value);
        compare_list.add(value);
        }
@Override
public void itemStateChanged(ItemEvent e)
{

    Object obj=e.getSource();
    if(obj==this.box)
    {
       
    int amount=Integer.valueOf(txtInput.getText());
    String item_name=this.box.getSelectedItem().toString();
    int actual_item=0;
    for(int i=0;i<compare_list.size();i++)
    {
        if(compare_list.get(i)==item_name)
        {
           actual_item=i;
        }
    }
     shoppinglist_item  new_item=new shoppinglist_item(items.get(actual_item),amount);
     list.add_item(new_item);

    }

    
}
   


}

class controller  {

}
