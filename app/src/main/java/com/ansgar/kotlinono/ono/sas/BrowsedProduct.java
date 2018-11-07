package com.ansgar.kotlinono.ono.sas;

import android.text.TextUtils;

import java.util.Objects;

public class BrowsedProduct extends GsonDataModel {

    public static final String PRODUCT_TYPE_GD = "gd";
    public static final String PRODUCT_TYPE_MIP = "mip";
    public static final String PRODUCT_TYPE_NSM = "nsm";
    public static final String PRODUCT_TYPE_QTA = "qta";

    public static final String SHORT_DESC_FILTER_STRING = "限時特賣中";

    public String type;
    public String id;
    public String title;
    public String imageUrl;
    public String priceDesc;
    public boolean isFastDeliver;

    // for 商店商品
    public String storeId;
    public String storeName;

    public BrowsedProduct() {
    }


    /**
     * Filter "限時特賣中".
     *
     * @param shortDesc The short description from ECMIPInfo.
     *
     * @return Return empty string if {@code shortDesc} equal "限時特賣中", otherwise original string.
     */
    private String filterShortDesc(String shortDesc) {
        if (TextUtils.isEmpty(shortDesc) || shortDesc.equals(SHORT_DESC_FILTER_STRING)) {
            return "";
        } else {
            return shortDesc;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof BrowsedProduct) {
            BrowsedProduct other = (BrowsedProduct) o;
            return Objects.equals(type, other.type) && Objects.equals(id, other.id);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id);
    }
}
