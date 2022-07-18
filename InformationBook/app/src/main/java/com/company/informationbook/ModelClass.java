package com.company.informationbook;

public class ModelClass {

    String categoryName;
    String categoryImage;

    public ModelClass(String categoryName, String categoryImage) {
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }
}
