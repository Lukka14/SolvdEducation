package enums.myenums;

public enum Phone {
    IPHONE_X(Brand.APPLE,Color.BLACK){
            public String getValue() {
                return "Iphone X";
            }
        },
    SAMSUNG_GALAXY_A22(Brand.SAMSUNG,Color.PINK) {
            public String getValue() {
                return "Samsung Galaxy A22";
            }
        },
    NOKIA_C21(Brand.NOKIA,Color.ORANGE) {
            public String getValue() {
                return "NOKIA C21";
            }
        };
    private String color;
    private String brand;

    Phone(Brand brand,Color color){
        this.brand=brand.name();
        this.color=color.name();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
