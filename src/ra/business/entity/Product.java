package ra.business.entity;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Product {
    private String productID;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private int catalogId;

    private enum productStatus {
        ACTIVE,
        BLOCK,
        INACTIVE


    }

    public Product() {
    }

    public Product(String productID, String productName, float price, String description, Date created, int catalogId) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public void inputData(Scanner scanner, List<Product> productList, List <Categories> categoriesList) {
        this.productID = inputProductId(scanner, productList);
        this.productName = inputProductName(scanner, productList );
        this.price = inputPrice (scanner);
        this.description = inputDescription(scanner);

    }

    public String inputProductId(Scanner scanner, List<Product> productList ) {
        String regex = "^([CSA])\\d{3}$";
//        Scanner scanner = new Scanner(System.in);
        do {
            System.out.printf("Nhập mã sản phẩm :");
            String productId = scanner.nextLine();
            //trùng
            if (productId.matches(regex)) {
                if (!productId.equals(this.productID)) {
                    return productId;
                }
            } else {
                System.err.println("Nhập không đúng định dạng, mã sản phẩm đồ uống, gồm 4 ký tự bắt\n" +
                        "đầu là một trong 3 ký tự (C: các đồ uống là café, S: các đồ\n" +
                        "uống là sinh tố, A: các đồ ăn nhanh) Mời bạn nhập lại ..");
            }

        } while (true);
    }

    public String inputProductName(Scanner scanner, List<Product> productList) {
        System.out.printf("Nhập vào tên sản phẩm : ");
        do {
            String productName = scanner.nextLine();
            if (productName.length() >= 10 && productName.length() <= 50) {
                boolean isExist = false;
                for (int i = 0; i < productList.size(); i++) {
                    if (productList.get(i).getProductName().equals(productName)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Tên sản phẩm đã tồn tại, vui lòng nhập lại ..");
                } else {
                    return productName;
                }
            } else {
                System.err.println("Tên sản phẩm có từ 10-50 ký tự, vui lòng nhập lại ..");
            }

        } while (true);
    }

        public float inputPrice(Scanner scanner ) {
            System.out.println("Nhập vào giá sản phẩm:");
            do {
                float price = Float.parseFloat(scanner.nextLine());
                if (price > 0) {
                    return price;
                } else {
                    System.err.println("Giá sản phẩm phải lớn hơn 0, vui lòng nhập lại ..");
                }
            } while (true);
        }
    public String inputDescription(Scanner scanner) {
        System.out.println("Nhập vào mô tả sản phẩm:");
        return scanner.nextLine();
    }


}
