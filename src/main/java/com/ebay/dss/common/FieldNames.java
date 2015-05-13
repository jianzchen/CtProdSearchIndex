package com.ebay.dss.common;

import cascading.tuple.Fields;
import com.ebay.hadoop.cascading.util.StringUtil;
import com.ebay.hadoop.platform.hdal.edw.CtProductSearchIndex;

public class FieldNames {
    public static final String TRANSIENT_INDEX_MESSAGE_NAME = "attr_id";
    public static final String TRANSIENT_INDEX_MESSAGE_VALUE = "attr_val";
    public static final Fields TRANSIENT_INDEX_MESSAGE_PAIR_F = StringUtil.fields(TRANSIENT_INDEX_MESSAGE_NAME, TRANSIENT_INDEX_MESSAGE_VALUE);

    public static final String IMAGE_STATUS = "image_status";
    public static final String SEQ_NUM = "seq_num";
    public static final Fields PROD_IMAGE_STATUS = StringUtil.fields(IMAGE_STATUS, SEQ_NUM);

    public static final String AVG_BIN_PRICE = "avg_bin_price ";
    public static final String AVG_COMPLETED_PRICE = "avg_completed_price";
    public static final String AVG_SHIPPING_COST = "avg_shipping_cost";
    public static final String QUANTITY = "quantity";
    public static final String AVAILABLE_ITEMS = "available_items";
    public static final String SOLD_ITEMS = "sold_items";
    public static final String AVAILABLE_STORE_ITEMS = "available_store_items";
    public static final String QUANTITY_NEW_CONDITION = "quantity_new_condition";
    public static final String QUANTITY_USED_CONDITION = "quantity_used_condition";
    public static final String MIN_BIN_PRICE_NEW_CONDITION = "min_bin_price_new_condition";
    public static final String MIN_BIN_PRICE_USED_CONDITION = "min_bin_price_used_condition";
    public static final String AVG_BIN_PRICE_NEW_CONDITION = "avg_bin_price_new_condition";
    public static final String AVG_BIN_PRICE_USED_CONDITION = "avg_bin_price_used_condition";
    public static final String AVG_COMPLETED_PRICE_NEW_CONDITION = "avg_completed_price_new_condition";
    public static final String AVG_COMPLETED_PRICE_USED_CONDITION = "avg_completed_price_used_condition";
    public static final String AVG_SHIPPING_COST_NEW_CONDITION = "avg_shipping_cost_new_condition";
    public static final String AVG_SHIPPING_COST_USED_CONDITION = "avg_shipping_cost_used_condition";
    public static final String AVG_SOLD_TOTAL_COST = "avg_sold_total_cost";
    public static final String MOST_POPULAR_LEAF_CAT = "most_popular_leaf_cat";
    public static final String TOP_RATED_SELLER_ITEM_COUNT = "top_rated_seller_item_count";
    public static final String TOP_RATED_SELLER_AVG_COMPLETED_PRICE = "top_rated_seller_avg_completed_price";
    public static final String TOP_RATED_SELLER_AVG_COMPLETED_PRICE_NEW = "top_rated_seller_avg_completed_price_new";
    public static final String TOP_RATED_SELLER_AVG_COMPLETED_PRICE_USED = "top_rated_seller_avg_completed_price_used";
    public static final String TOP_RATED_SELLER_AVG_SOLD_TOTAL_COST = "top_rated_seller_avg_sold_total_cost";
    public static final String QUANTITY_REFURBISHED_CONDITION = "quantity_refurbished_condition";
    public static final String QUANTITY_LIKE_NEW_CONDITION = "quantity_like_new_condition";
    public static final String QUANTITY_VERY_GOOD_CONDITION = "quantity_very_good_condition";
    public static final String QUANTITY_GOOD_CONDITION = "quantity_good_condition";
    public static final String QUANTITY_SIG_WEAR_CONDITION = "quantity_sig_wear_condition";
    public static final String QUANTITY_DAMAGED_CONDITION = "quantity_damaged_condition";
    public static final String MIN_BIN_PRICE_REFURBISHED_CONDITION = "min_bin_price_refurbished_condition";
    public static final String MIN_BIN_PRICE_LIKE_NEW_CONDITION = "min_bin_price_like_new_condition";
    public static final String MIN_BIN_PRICE_VERY_GOOD_CONDITION = "min_bin_price_very_good_condition";
    public static final String MIN_BIN_PRICE_GOOD_CONDITION = "min_bin_price_good_condition";
    public static final String MIN_BIN_PRICE_SIG_WEAR_CONDITION = "min_bin_price_sig_wear_condition";
    public static final String MIN_BIN_PRICE_DAMAGED_CONDITION = "min_bin_price_damaged_condition";
    public static final String AVG_BIN_PRICE_REFURBISHED_CONDITION = "avg_bin_price_refurbished_condition";
    public static final String AVG_BIN_PRICE_LIKE_NEW_CONDITION = "avg_bin_price_like_new_condition";
    public static final String AVG_BIN_PRICE_VERY_GOOD_CONDITION = "avg_bin_price_very_good_condition";
    public static final String AVG_BIN_PRICE_GOOD_CONDITION = "avg_bin_price_good_condition";
    public static final String AVG_BIN_PRICE_SIG_WEAR_CONDITION = "avg_bin_price_sig_wear_condition";
    public static final String AVG_BIN_PRICE_DAMAGED_CONDITION = "avg_bin_price_damaged_condition";
    public static final String AVG_COMPLETED_PRICE_REFURBISHED_CONDITION = "avg_completed_price_refurbished_condition";
    public static final String AVG_COMPLETED_PRICE_LIKE_NEW_CONDITION = "avg_completed_price_like_new_condition";
    public static final String AVG_COMPLETED_PRICE_VERY_GOOD_CONDITION = "avg_completed_price_very_good_condition";
    public static final String AVG_COMPLETED_PRICE_GOOD_CONDITION = "avg_completed_price_good_condition";
    public static final String AVG_COMPLETED_PRICE_SIG_WEAR_CONDITION = "avg_completed_price_sig_wear_condition";
    public static final String AVG_COMPLETED_PRICE_DAMAGED_CONDITION = "avg_completed_price_damaged_condition";
    public static final String TOP_RATED_SELLER_AVG_COMPLETED_PRICE_REFURBISHED = "top_rated_seller_avg_completed_price_refurbished";
    public static final String TOP_RATED_SELLER_AVG_COMPLETED_PRICE_LIKE_NEW = "top_rated_seller_avg_completed_price_like_new";
    public static final String TOP_RATED_SELLER_AVG_COMPLETED_PRICE_VERY_GOOD = "top_rated_seller_avg_completed_price_very_good";
    public static final String TOP_RATED_SELLER_AVG_COMPLETED_PRICE_GOOD = "top_rated_seller_avg_completed_price_good";
    public static final String TOP_RATED_SELLER_AVG_COMPLETED_PRICE_SIG_WEAR = "top_rated_seller_avg_completed_price_sig_wear";
    public static final String TOP_RATED_SELLER_AVG_COMPLETED_PRICE_DAMAGED = "top_rated_seller_avg_completed_price_damaged";
    public static final String QUANTITY_BRAND_NEW_CONDITION = "quantity_brand_new_condition";
    public static final String QUANTITY_NEW_NON_RETAIL_PACKAGING_CONDITION = "quantity_new_non_retail_packaging_condition";
    public static final String MIN_BIN_PRICE_BRAND_NEW_CONDITION = "min_bin_price_brand_new_condition";
    public static final String MIN_BIN_PRICE_NEW_NON_RETAIL_PACKAGING_CONDITION = "min_bin_price_new_non_retail_packaging_condition";
    public static final String AVG_BIN_PRICE_BRAND_NEW_CONDITION = "avg_bin_price_brand_new_condition";
    public static final String AVG_BIN_PRICE_NEW_NON_RETAIL_PACKAGING_CONDITION = "avg_bin_price_new_non_retail_packaging_condition";
    public static final String AVG_COMPLETED_PRICE_BRAND_NEW_CONDITION = "avg_completed_price_brand_new_condition";
    public static final String AVG_COMPLETED_PRICE_NEW_NON_RETAIL_PACKAGING_CONDITION = "avg_completed_price_new_non_retail_packaging_condition";
    public static final String TOP_RATED_SELLER_AVG_COMPLETED_PRICE_BRAND_NEW = "top_rated_seller_avg_completed_price_brand_new";
    public static final String TOP_RATED_SELLER_AVG_COMPLETED_PRICE_NEW_NON_RETAIL_PACKAGING = "top_rated_seller_avg_completed_price_new_non_retail_packaging";
    public static final String AVG_AUCTION_COMPLETED_PRICE_NEW_CONDITION = "avg_auction_completed_price_new_condition";
    public static final String AVG_AUCTION_COMPLETED_PRICE_USED_CONDITION = "avg_auction_completed_price_used_condition";
    public static final String AVG_BIN_COMPLETED_PRICE_NEW_CONDITION = "avg_bin_completed_price_new_condition";
    public static final String AVG_BIN_COMPLETED_PRICE_USED_CONDITION = "avg_bin_completed_price_used_condition";
    public static final String AVG_COMPLETED_PRICE_SELLER_REFURBISHED_CONDITION = "avg_completed_price_seller_refurbished_condition";

    public static final String[] PROD_PRICE_INFO = {
            AVG_BIN_PRICE
            , AVG_COMPLETED_PRICE
            , AVG_SHIPPING_COST
            , QUANTITY
            , AVAILABLE_ITEMS
            , SOLD_ITEMS
            , AVAILABLE_STORE_ITEMS
            , QUANTITY_NEW_CONDITION
            , QUANTITY_USED_CONDITION
            , MIN_BIN_PRICE_NEW_CONDITION
            , MIN_BIN_PRICE_USED_CONDITION
            , AVG_BIN_PRICE_NEW_CONDITION
            , AVG_BIN_PRICE_USED_CONDITION
            , AVG_COMPLETED_PRICE_NEW_CONDITION
            , AVG_COMPLETED_PRICE_USED_CONDITION
            , AVG_SHIPPING_COST_NEW_CONDITION
            , AVG_SHIPPING_COST_USED_CONDITION
            , AVG_SOLD_TOTAL_COST
            , MOST_POPULAR_LEAF_CAT
            , TOP_RATED_SELLER_ITEM_COUNT
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_NEW
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_USED
            , TOP_RATED_SELLER_AVG_SOLD_TOTAL_COST
            , QUANTITY_REFURBISHED_CONDITION
            , QUANTITY_LIKE_NEW_CONDITION
            , QUANTITY_VERY_GOOD_CONDITION
            , QUANTITY_GOOD_CONDITION
            , QUANTITY_SIG_WEAR_CONDITION
            , QUANTITY_DAMAGED_CONDITION
            , MIN_BIN_PRICE_REFURBISHED_CONDITION
            , MIN_BIN_PRICE_LIKE_NEW_CONDITION
            , MIN_BIN_PRICE_VERY_GOOD_CONDITION
            , MIN_BIN_PRICE_GOOD_CONDITION
            , MIN_BIN_PRICE_SIG_WEAR_CONDITION
            , MIN_BIN_PRICE_DAMAGED_CONDITION
            , AVG_BIN_PRICE_REFURBISHED_CONDITION
            , AVG_BIN_PRICE_LIKE_NEW_CONDITION
            , AVG_BIN_PRICE_VERY_GOOD_CONDITION
            , AVG_BIN_PRICE_GOOD_CONDITION
            , AVG_BIN_PRICE_SIG_WEAR_CONDITION
            , AVG_BIN_PRICE_DAMAGED_CONDITION
            , AVG_COMPLETED_PRICE_REFURBISHED_CONDITION
            , AVG_COMPLETED_PRICE_LIKE_NEW_CONDITION
            , AVG_COMPLETED_PRICE_VERY_GOOD_CONDITION
            , AVG_COMPLETED_PRICE_GOOD_CONDITION
            , AVG_COMPLETED_PRICE_SIG_WEAR_CONDITION
            , AVG_COMPLETED_PRICE_DAMAGED_CONDITION
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_REFURBISHED
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_LIKE_NEW
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_VERY_GOOD
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_GOOD
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_SIG_WEAR
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_DAMAGED
            , QUANTITY_BRAND_NEW_CONDITION
            , QUANTITY_NEW_NON_RETAIL_PACKAGING_CONDITION
            , MIN_BIN_PRICE_BRAND_NEW_CONDITION
            , MIN_BIN_PRICE_NEW_NON_RETAIL_PACKAGING_CONDITION
            , AVG_BIN_PRICE_BRAND_NEW_CONDITION
            , AVG_BIN_PRICE_NEW_NON_RETAIL_PACKAGING_CONDITION
            , AVG_COMPLETED_PRICE_BRAND_NEW_CONDITION
            , AVG_COMPLETED_PRICE_NEW_NON_RETAIL_PACKAGING_CONDITION
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_BRAND_NEW
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_NEW_NON_RETAIL_PACKAGING
            , AVG_AUCTION_COMPLETED_PRICE_NEW_CONDITION
            , AVG_AUCTION_COMPLETED_PRICE_USED_CONDITION
            , AVG_BIN_COMPLETED_PRICE_NEW_CONDITION
            , AVG_BIN_COMPLETED_PRICE_USED_CONDITION
            , AVG_COMPLETED_PRICE_SELLER_REFURBISHED_CONDITION
    };

    public static final String[] PROD_PRICE_INFO_ALL = {
            CtProductSearchIndex.PROD_REFERENCE_ID
            , CtProductSearchIndex.PRODUCT_ID
            , AVG_BIN_PRICE
            , AVG_COMPLETED_PRICE
            , AVG_SHIPPING_COST
            , QUANTITY
            , AVAILABLE_ITEMS
            , SOLD_ITEMS
            , AVAILABLE_STORE_ITEMS
            , QUANTITY_NEW_CONDITION
            , QUANTITY_USED_CONDITION
            , MIN_BIN_PRICE_NEW_CONDITION
            , MIN_BIN_PRICE_USED_CONDITION
            , AVG_BIN_PRICE_NEW_CONDITION
            , AVG_BIN_PRICE_USED_CONDITION
            , AVG_COMPLETED_PRICE_NEW_CONDITION
            , AVG_COMPLETED_PRICE_USED_CONDITION
            , AVG_SHIPPING_COST_NEW_CONDITION
            , AVG_SHIPPING_COST_USED_CONDITION
            , AVG_SOLD_TOTAL_COST
            , MOST_POPULAR_LEAF_CAT
            , TOP_RATED_SELLER_ITEM_COUNT
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_NEW
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_USED
            , TOP_RATED_SELLER_AVG_SOLD_TOTAL_COST
            , QUANTITY_REFURBISHED_CONDITION
            , QUANTITY_LIKE_NEW_CONDITION
            , QUANTITY_VERY_GOOD_CONDITION
            , QUANTITY_GOOD_CONDITION
            , QUANTITY_SIG_WEAR_CONDITION
            , QUANTITY_DAMAGED_CONDITION
            , MIN_BIN_PRICE_REFURBISHED_CONDITION
            , MIN_BIN_PRICE_LIKE_NEW_CONDITION
            , MIN_BIN_PRICE_VERY_GOOD_CONDITION
            , MIN_BIN_PRICE_GOOD_CONDITION
            , MIN_BIN_PRICE_SIG_WEAR_CONDITION
            , MIN_BIN_PRICE_DAMAGED_CONDITION
            , AVG_BIN_PRICE_REFURBISHED_CONDITION
            , AVG_BIN_PRICE_LIKE_NEW_CONDITION
            , AVG_BIN_PRICE_VERY_GOOD_CONDITION
            , AVG_BIN_PRICE_GOOD_CONDITION
            , AVG_BIN_PRICE_SIG_WEAR_CONDITION
            , AVG_BIN_PRICE_DAMAGED_CONDITION
            , AVG_COMPLETED_PRICE_REFURBISHED_CONDITION
            , AVG_COMPLETED_PRICE_LIKE_NEW_CONDITION
            , AVG_COMPLETED_PRICE_VERY_GOOD_CONDITION
            , AVG_COMPLETED_PRICE_GOOD_CONDITION
            , AVG_COMPLETED_PRICE_SIG_WEAR_CONDITION
            , AVG_COMPLETED_PRICE_DAMAGED_CONDITION
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_REFURBISHED
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_LIKE_NEW
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_VERY_GOOD
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_GOOD
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_SIG_WEAR
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_DAMAGED
            , QUANTITY_BRAND_NEW_CONDITION
            , QUANTITY_NEW_NON_RETAIL_PACKAGING_CONDITION
            , MIN_BIN_PRICE_BRAND_NEW_CONDITION
            , MIN_BIN_PRICE_NEW_NON_RETAIL_PACKAGING_CONDITION
            , AVG_BIN_PRICE_BRAND_NEW_CONDITION
            , AVG_BIN_PRICE_NEW_NON_RETAIL_PACKAGING_CONDITION
            , AVG_COMPLETED_PRICE_BRAND_NEW_CONDITION
            , AVG_COMPLETED_PRICE_NEW_NON_RETAIL_PACKAGING_CONDITION
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_BRAND_NEW
            , TOP_RATED_SELLER_AVG_COMPLETED_PRICE_NEW_NON_RETAIL_PACKAGING
            , AVG_AUCTION_COMPLETED_PRICE_NEW_CONDITION
            , AVG_AUCTION_COMPLETED_PRICE_USED_CONDITION
            , AVG_BIN_COMPLETED_PRICE_NEW_CONDITION
            , AVG_BIN_COMPLETED_PRICE_USED_CONDITION
            , AVG_COMPLETED_PRICE_SELLER_REFURBISHED_CONDITION
    };

}
