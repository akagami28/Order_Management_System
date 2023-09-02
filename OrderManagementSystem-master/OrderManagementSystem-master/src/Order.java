import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable,Runnable{

    private static final long serialVersionUID = -7242995977297486759L;

    static File f = new File("E:\\Documents\\Visnupriya\\ITOrizon\\Projects\\OrderManagementSystem-master\\OrderManagementSystem-master\\OrderManagement.txt");
//    static File fnew = new File("C:\\Workspace\\OrderManagementSystem\\Delivered.txt");
    static ArrayList<Order> list = new ArrayList<>();
    static ArrayList<Order> delivered = new ArrayList<>();

    //Data members
    private String orderId;
    private String orderDescription;
    private String deliveryAddress;
//    private LocalDateTime orderDate
    private String orderDate;
    private double amount;
    private String deliveryDateTime;

    public Order()
    {

    }

    public Order(String orderId, String orderDescription, String deliveryAddress, String orderDate, double amount) {
        this.orderId = orderId;
        this.orderDescription = orderDescription;
        this.deliveryAddress = deliveryAddress;
        this.orderDate = orderDate;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDeliveryDateTime() {
        return deliveryDateTime;
    }

    public void setDeliveryDateTime(String deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    public String toString()
    {
          return " | \t\t" +orderId + " \t| \t\t" + orderDescription + " \t\t| \t\t" + deliveryAddress + " \t\t\t| " + orderDate + " | \t\t" + amount + " | \t\t" +deliveryDateTime + " |";
    }

    @Override
    public void run() {
        load();

        if(delivered.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDeliveryDateTime() != null) {
                    delivered.add(list.get(i));
                }
            }
        }else
        {
            for(int j=0;j<list.size();j++) {
                if (delivered.get(j).getOrderId().contains(list.get(j).getOrderId()))
                {

                }else
                {
                    delivered.add(list.get(j));
                }
            }
        }
        System.out.println("The size of Delivered List is : " +delivered.size());

//        String dateFormat = "yyyy-MM-dd hh:mm:ss a";
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");


        File file = new File("Delivered_" +dateFormat.format(date) + ".txt");
        try {
            file.createNewFile();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        try{
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            if(file.length() == 0)
            {
                pw.println(" OrderId \t" + " OrderDescription \t" + " DeliveryAddress \t" + " OrderDateTime \t" + " \t\tAmount \t\t\t" + " DeliveryDateTime \t");
            }

            for(int i=0;i<delivered.size();i++)
            {
                pw.println(delivered.get(i).toString());
            }
            pw.close();
            delivered.clear();
        }catch(Exception e)
        {
            e.printStackTrace();
        }


    }


    public void load()
    {
        if(f.length()!=0) {
            try {
                FileInputStream fi = new FileInputStream(f);
                ObjectInputStream oi = new ObjectInputStream(fi);
                list = (ArrayList<Order>) oi.readObject();

//                // reading to the console
//                for (Order i : list) {
//                    System.out.println(i.toString());
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("List is empty.....");
        }
        }



}
