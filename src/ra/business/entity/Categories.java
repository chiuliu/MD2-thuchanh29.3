package ra.business.entity;

import java.util.List;
import java.util.Scanner;

public class Categories {
    private int catalogID;
    private String catalogName;
    private String description;
    private boolean catalogStatus;
    static int nextID = 1;

    public Categories() {
        this.catalogID = nextID++;
        //id tự tăng
    }

    public Categories(int catalogID, String catalogName, String description, boolean catalogStatus) {
        this.catalogID = catalogID;
        this.catalogName = catalogName;
        this.description = description;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(int catalogID) {
        this.catalogID = catalogID;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputData(Scanner scanner, List<Categories> categoriesList) {
        this.catalogName = inputCatalogName(scanner, categoriesList);
        this.description = inputDescription(scanner);
        this.catalogStatus = inputCatalogStatus(scanner);

    }

    public String inputCatalogName(Scanner scanner, List<Categories> categoriesList) {
        System.out.println("Nhập vào tên danh mục");

        do {
            String catalogName = scanner.nextLine();
            if (catalogName.length() <= 50) {
                boolean isExist = false;
                for (int i = 0; i < categoriesList.size(); i++) {
                    if (categoriesList.get(i).getCatalogName().equals(catalogName)) {
                        isExist = true;
                    }

                }
                if (isExist) {
                    System.err.println("Tên danh mục đã tồn tại ! Vui lòng nhập lại ..");
                } else {
                    return catalogName;
                }

            } else {
                System.err.println("Tên danh mục có độ đài tối đa 50 ký tự ! Vui lòng nhập lại ..");
            }


        }
        while (true);

    }

    public String inputDescription(Scanner scanner) {
        System.out.println("Nhập mô tả danh mục");
        return scanner.nextLine();
    }

    public boolean inputCatalogStatus(Scanner scanner) {
        System.out.printf("Nhập trạng thái danh mục (true / false) :");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println(" Trạng thái danh mục chỉ nhận giá trị true / false ! Vui lòng nhập lại ...");
            }

        } while (true);
    }

    public void displayData(){
        System.out.printf("Mã danh muc : %d - Tên danh mục : %s - Mô tả danh mục : %s - Trạng thái danh mục : %s \n",
                this.catalogID, this. catalogName, this.description, this.catalogStatus ? "Hoạt động" : "Không hoạt động");

    }


}
