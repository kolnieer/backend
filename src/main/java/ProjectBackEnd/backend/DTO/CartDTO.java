package ProjectBackEnd.backend.DTO;

public class CartDTO {
    private Long userId;
    private String productName;
    private int quantity;
    private Long addOnsId;

    CartDTO(){}

    public CartDTO(Long userId, String productName, int quantity, Long addOnsId) {
        this.userId = userId;
        this.productName = productName;
        this.quantity = quantity;
        this.addOnsId = addOnsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getAddOnsId() {
        return addOnsId;
    }

    public void setAddOnsId(Long addOnsId) {
        this.addOnsId = addOnsId;
    }

}
