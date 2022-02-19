package classes.Main;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            String url = "jdbc:postgresql://localhost:5432/ass5";
            String username = "postgres";
            String password = "Gamdes35";
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ArrayList<Items> items = new ArrayList();
            int sum = 0;
            int sum1 = 0;
            System.out.println("____________________________________________________");
            System.out.println("Choose what you wanna buy:");
            System.out.println("____________________________________________________");

            while(true) {
                Cigane:
                while(true) {
                    System.out.println("1. Semi-Precious\n2. Precious\n3.Cart\n0.Exit");
                    int d = sc.nextInt();
                    switch (d){
                        case 1:
                            System.out.println("1. Sapphire\n2. Ruby\n3. Tourmaline\n0.Back to the menu");
                            int n = sc.nextInt();
                            ResultSet rs;
                            int id;
                            int price;
                            int weight;
                            String name;
                            int choose;
                            switch(n) {
                                case 1:
                                    rs = st.executeQuery("select * from sapphire");

                                    while (rs.next()) {
                                        id = rs.getInt(1);
                                        name = rs.getString(2);
                                        price = rs.getInt(3);
                                        weight = rs.getInt(4);
                                        System.out.println(id + ". " + name + ", price: " + price + ", weight: " + weight);
                                    }

                                    rs.close();
                                    choose = sc.nextInt();

                                    for (rs = st.executeQuery("select name, price from sapphire where id = " + choose + ";"); rs.next(); sum += price) {
                                        name = rs.getString(1);
                                        price = rs.getInt(2);
                                        items.add(new Items(name + " " + price + "$ "));
                                    }
                                    for (rs = st.executeQuery("select name, weight from sapphire where id = " + choose + ";"); rs.next(); sum1 += weight) {
                                        name = rs.getString(1);
                                        weight = rs.getInt(2);
                                        items.add(new Items(name + " " + weight + " carats"));
                                    }
                                    break;
                                case 2:
                                    rs = st.executeQuery("select * from ruby");

                                    while (rs.next()) {
                                        id = rs.getInt(1);
                                        name = rs.getString(2);
                                        price = rs.getInt(3);
                                        weight = rs.getInt(4);
                                        System.out.println(id + ". " + name + ", price: " + price + ", weight: " + weight);
                                    }

                                    rs.close();
                                    choose = sc.nextInt();
                                    rs = st.executeQuery("select name, price, weight from ruby where id = " + choose + ";");
                                    while (true) {
                                        if (!rs.next()) {
                                            continue Cigane;
                                        }

                                        name = rs.getString(1);
                                        price = rs.getInt(2);
                                        weight = rs.getInt(3);
                                        items.add(new Items(name + " " + price + "$ " + weight + " carats"));
                                        sum += price;
                                        sum1 += weight;
                                    }
                                case 3:
                                    rs = st.executeQuery("select * from tourmaline");

                                    while (rs.next()) {
                                        id = rs.getInt(1);
                                        name = rs.getString(2);
                                        price = rs.getInt(3);
                                        weight = rs.getInt(4);
                                        System.out.println(id + ". " + name + ", price: " + price + ", weight: " + weight);
                                    }

                                    rs.close();
                                    choose = sc.nextInt();
                                    rs = st.executeQuery("select name, price, weight from tourmaline where id = " + choose + ";");
                                    while (true) {
                                        if (!rs.next()) {
                                            continue Cigane;
                                        }

                                        name = rs.getString(1);
                                        price = rs.getInt(2);
                                        weight = rs.getInt(3);
                                        items.add(new Items(name + " " + price + "$ " + weight + " carats"));
                                        sum += price;
                                        sum1 += weight;
                                    }
                                case 0: continue Cigane;
                            }

                                case 2:
                                    System.out.println("1. Garnet\n2. Zircon \n3. Beryl \n4. Chrysoberyl \n0.Back to the menu");
                                    int c = sc.nextInt();
                                    switch (c) {
                                        case 1:
                                            rs = st.executeQuery("select * from garnet");

                                            while (rs.next()) {
                                                id = rs.getInt(1);
                                                name = rs.getString(2);
                                                price = rs.getInt(3);
                                                weight = rs.getInt(4);
                                                System.out.println(id + ". " + name + ", price: " + price + ", weight: " + weight);
                                            }

                                            rs.close();
                                            choose = sc.nextInt();
                                            rs = st.executeQuery("select name, price, weight from garnet where id = " + choose + ";");

                                            while (true) {
                                                if (!rs.next()) {
                                                    continue Cigane;
                                                }

                                                name = rs.getString(1);
                                                price = rs.getInt(2);
                                                weight = rs.getInt(3);
                                                items.add(new Items(name + " " + price + "$ " + weight + " carats"));
                                                sum += price;
                                                sum1 += weight;
                                            }
                                        case 2:
                                            rs = st.executeQuery("select * from zircon");

                                            while (rs.next()) {
                                                id = rs.getInt(1);
                                                name = rs.getString(2);
                                                price = rs.getInt(3);
                                                weight = rs.getInt(4);
                                                System.out.println(id + ". " + name + ", price: " + price + ", weight: " + weight);
                                            }

                                            rs.close();
                                            choose = sc.nextInt();
                                            rs = st.executeQuery("select name, price, weight from zircon where id = " + choose + ";");

                                            while (true) {
                                                if (!rs.next()) {
                                                    continue Cigane;
                                                }

                                                name = rs.getString(1);
                                                price = rs.getInt(2);
                                                weight = rs.getInt(3);
                                                items.add(new Items(name + " " + price + "$ " + weight + " carats"));
                                                sum += price;
                                                sum1 += weight;
                                            }
                                        case 3:
                                            rs = st.executeQuery("select * from beryl");

                                            while (rs.next()) {
                                                id = rs.getInt(1);
                                                name = rs.getString(2);
                                                price = rs.getInt(3);
                                                weight = rs.getInt(4);
                                                System.out.println(id + ". " + name + ", price: " + price + ", weight: " + weight);
                                            }

                                            rs.close();
                                            choose = sc.nextInt();
                                            rs = st.executeQuery("select name, price, weight from beryl where id = " + choose + ";");

                                            while (true) {
                                                if (!rs.next()) {
                                                    continue Cigane;
                                                }

                                                name = rs.getString(1);
                                                price = rs.getInt(2);
                                                weight = rs.getInt(3);
                                                items.add(new Items(name + " " + price + "$ " + weight + " carats"));
                                                sum += price;
                                                sum1 += weight;
                                            }
                                        case 4:
                                            rs = st.executeQuery("select * from chrysoberyl");

                                            while (rs.next()) {
                                                id = rs.getInt(1);
                                                name = rs.getString(2);
                                                price = rs.getInt(3);
                                                weight = rs.getInt(4);
                                                System.out.println(id + ". " + name + ", price: " + price + ", weight: " + weight);
                                            }

                                            rs.close();
                                            choose = sc.nextInt();
                                            rs = st.executeQuery("select name, price, weight from chrysoberyl where id = " + choose + ";");

                                            while (true) {
                                                if (!rs.next()) {
                                                    continue Cigane;
                                                }

                                                name = rs.getString(1);
                                                price = rs.getInt(2);
                                                weight = rs.getInt(3);
                                                items.add(new Items(name + " " + price + "$ " + weight + " carats"));
                                                sum += price;
                                                sum1 += weight;
                                            }
                                    }case 3:
                            System.out.println("+_________+");

                            for(int i = 0; i < items.size(); ++i) {
                                PrintStream var10000 = System.out;
                                Object var10001 = items.get(i);
                                var10000.println("|" + var10001 + "|");
                            }

                            System.out.println("+_________+");
                            System.out.println("Sum: " + sum);
                            System.out.println("____________________________________________________");
                            System.out.println("Weight: " + sum1);
                            break;
                        case 0:
                            System.exit(0);
                    }
                    }
                }
                    
                        
        } catch (SQLException var16) {
            var16.printStackTrace();
        }
    }
}

