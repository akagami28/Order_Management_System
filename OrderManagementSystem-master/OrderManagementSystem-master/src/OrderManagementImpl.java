import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class OrderManagementImpl implements OrderManagement{

    static File f = new File("E:\\Documents\\Visnupriya\\ITOrizon\\Projects\\OrderManagementSystem-master\\OrderManagementSystem-master\\OrderManagement.txt");
    static ArrayList<Order> list = new ArrayList<>();
//    ArrayList<Order> orders = new ArrayList<>();

    @Override
    public void addOrder(String orderId,String orderDescription,String deliveryAddress,String orderDate,double amount) {
    Load();
//        if(list.isEmpty())
//        {
//            try{
//                FileInputStream fi = new FileInputStream(f);
//                ObjectInputStream oi = new ObjectInputStream(fi);
//                ArrayList<Order> orders = (ArrayList<Order>)oi.readObject();
//            }catch(Exception e)
//            {
//                e.printStackTrace();
//            }
//        }else


            list.add(new Order(orderId,orderDescription,deliveryAddress,orderDate,amount));
            System.out.println("Order Added Successfully....");

        //writing to a file
        try {
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(list);
            oo.flush();
            oo.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public void viewOrder() {
        if(f.length()!=0) {
            try {
                FileInputStream fi = new FileInputStream(f);
                ObjectInputStream oi = new ObjectInputStream(fi);
                list = (ArrayList<Order>) oi.readObject();
                System.out.println(" OrderId \t" + " OrderDescription \t" + " DeliveryAddress \t" + " OrderDateTime \t" + " \t\tAmount \t\t\t" + " DeliveryDateTime \t");

//                System.out.println(" | \t +orderId +  | \t + orderDescription +  | \t + deliveryAddress +  | \t + orderDate +  | \t + amount +  | \t +deliveryDateTime +  |");
                // reading to the console
                for (Order i : list) {
                    System.out.println(i.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else
            System.out.println("List is empty.....");
    }

    @Override
    public void viewByOrderId(String orderID) {
        Load();
            System.out.println("----------------------------");
            System.out.println("Order Detail");
            System.out.println("----------------------------");
            for (Order i : list) {
                if (orderID.equals(i.getOrderId())) {
                    System.out.println("Order Id : " + i.getOrderId());
                    System.out.println("Order Description : " + i.getOrderDescription());
                    System.out.println("Delivery Address : " + i.getDeliveryAddress());
                    System.out.println("Order Date : " + i.getOrderDate());
                    System.out.println("Amount : " + i.getAmount());
                    System.out.println("Delivery Date Time : " + i.getDeliveryDateTime());
                }
            }
    }

    @Override
    public void sortOrder() {
//        ******** Choose Sort Order Property*********
//        1.	OrderId
//        2.	Order Desc
//        3.	DeliveryAddress
//        4.	Order Date
//        5.	Amount
//        6.	Delivery Datetime
//        7.	Exit
        Load();
            Scanner sc = new Scanner(System.in);

            System.out.println("********* Choose Sort Order Property **********");
            System.out.println("1. OrderId");
            System.out.println("2. Order Desc");
            System.out.println("3. Delivery Address");
            System.out.println("4. Order Date");
            System.out.println("5. Amount");
            System.out.println("6. Delivery DateTime");

            int choice = sc.nextInt();
            if (choice == 1) {
                Collections.sort(list, new Comparator<Order>() {
                    @Override
                    public int compare(Order o1, Order o2) {
                        return Integer.parseInt(o1.getOrderId()) - Integer.parseInt(o2.getOrderId());
                    }
                });

                System.out.println(" OrderId \t" + " OrderDescription \t" + " DeliveryAddress \t" + " OrderDateTime \t" + " \t\tAmount \t\t\t" + " DeliveryDateTime \t");

                for(int i=0;i<list.size();i++){
                    System.out.println(list.get(i).toString());
                }

//                System.out.println(list.toString());
                System.out.println("Successfully sorted by OrderId.....");
            } else if (choice == 2) {
                Collections.sort(list, new Comparator<Order>() {
                    @Override
                    public int compare(Order o1, Order o2) {
                        return o1.getOrderDescription().compareToIgnoreCase(o2.getOrderDescription());
                    }
                });
                System.out.println(" OrderId \t" + " OrderDescription \t" + " DeliveryAddress \t" + " OrderDateTime \t" + " \t\tAmount \t\t\t" + " DeliveryDateTime \t");

                for(int i=0;i<list.size();i++){
                    System.out.println(list.get(i).toString());
                }
//                System.out.println(list.toString());
                System.out.println("Successfully Sorted By OrderDescription....");
            } else if (choice == 3) {
                Collections.sort(list, new Comparator<Order>() {
                    @Override
                    public int compare(Order o1, Order o2) {
                        return o1.getDeliveryAddress().compareTo(o2.getDeliveryAddress());
                    }
                });
                System.out.println(" OrderId \t" + " OrderDescription \t" + " DeliveryAddress \t" + " OrderDateTime \t" + " \t\tAmount \t\t\t" + " DeliveryDateTime \t");

                for(int i=0;i<list.size();i++){
                    System.out.println(list.get(i).toString());
                }
//                System.out.println(list.toString());
                System.out.println("Successfully sorted on delivery Address.....");
            } else if (choice == 4) {
                Collections.sort(list, new Comparator<Order>() {
                    @Override
                    public int compare(Order o1, Order o2) {
                        return o1.getOrderDate().compareTo(o2.getOrderDate());
                    }
                });
                System.out.println(" OrderId \t" + " OrderDescription \t" + " DeliveryAddress \t" + " OrderDateTime \t" + " \t\tAmount \t\t\t" + " DeliveryDateTime \t");

                for(int i=0;i<list.size();i++){
                    System.out.println(list.get(i).toString());
                }

//                System.out.println(list.toString());
                System.out.println("Successfully sorted on order Date....");
            } else if (choice == 5) {
                Collections.sort(list, new Comparator<Order>() {
                    @Override
                    public int compare(Order o1, Order o2) {
                        return (int) (o1.getAmount() - o2.getAmount());
                    }
                });
                System.out.println(" OrderId \t" + " OrderDescription \t" + " DeliveryAddress \t" + " OrderDateTime \t" + " \t\tAmount \t\t\t" + " DeliveryDateTime \t");

                for(int i=0;i<list.size();i++){
                    System.out.println(list.get(i).toString());
                }

//                System.out.println(list.toString());
                System.out.println("Successfully sorted on Amount.....");
            } else if (choice == 6) {
                Collections.sort(list, new Comparator<Order>() {
                    @Override
                    public int compare(Order o1, Order o2) {
                        return o1.getDeliveryDateTime().compareTo(o2.getDeliveryDateTime());
                    }
                });
                System.out.println(" OrderId \t" + " OrderDescription \t" + " DeliveryAddress \t" + " OrderDateTime \t" + " \t\tAmount \t\t\t" + " DeliveryDateTime \t");

                for(int i=0;i<list.size();i++){
                    System.out.println(list.get(i).toString());
                }
                //System.out.println(list.toString());
                System.out.println("Successfully sorted on Delivery Date Time....");
            }


    }

    @Override
    public void deleteOrderById(String orderId) {
            Load();
//        System.out.println("The size of the List is : " +list.size());
            for (int i = 0; i < list.size(); i++) {
                if (orderId.equals(list.get(i).getOrderId())) {
                    list.remove(i);
                    break;
                }
            }
            System.out.println("Your order has been removed Successfully.....");

            //updating the file
            try {
                FileOutputStream fo = new FileOutputStream(f);
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                oo.writeObject(list);
                oo.flush();
                oo.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    @Override
    public void markAsDelivered(String orderID) {
            Load();
//            System.out.println("The size of the List is : " + list.size());

        String dateFormat = "yyyy-MM-dd hh:mm:ss a";
        LocalDateTime now = LocalDateTime.now();
        String format = (now.format(DateTimeFormatter.ofPattern(dateFormat)));

            for (int i = 0; i < list.size(); i++) {
                if (orderID.equals(list.get(i).getOrderId())) {
                    list.get(i).setDeliveryDateTime(format);
                    System.out.println("Order Delivered Successfully...");
                    break;
                }
            }

            //updating the file
            update();
    }

    @Override
    public void generateReport() {
        Order o = new Order();
        Thread t1 = new Thread(o);
        t1.start();
        System.out.println("Generated Report Successfully...");
    }

    @Override
    public void exit() {
        try {
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(list);
            oo.flush();
            oo.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Exited Thank you.....");
    }

    public static void Load()
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
        }else
            System.out.println("List is empty.....");
    }

    public static void update()
    {
        try {
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(list);
            oo.flush();
            oo.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

//    public void run()
//    {
//        if(f.length()!=0) {
//            try {
//                FileInputStream fi = new FileInputStream(f);
//                ObjectInputStream oi = new ObjectInputStream(fi);
//                list = (ArrayList<Order>) oi.readObject();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }else
//            System.out.println("List is empty.....");
//
//        for(int i=0;i<list.size();i++)
//        {
//            if(list.get(i).getDeliveryDateTime()!=null)
//            {  try {
//                File file = new File("Order_txt_" + String.valueOf(LocalDateTime.now()));
//                file.createNewFile();
//
//                    FileWriter fw = new FileWriter(file);
//                    PrintWriter pw = new PrintWriter(fw);
//                    pw.print(list.get(i).getOrderId() + " " + list.get(i).getOrderDescription());
//            }catch(Exception e)
//            {
//                e.printStackTrace();
//            }
//            }
//        }
//    }
}
