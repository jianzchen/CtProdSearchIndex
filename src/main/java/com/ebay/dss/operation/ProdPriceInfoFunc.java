package com.ebay.dss.operation;

import cascading.flow.FlowProcess;
import cascading.operation.BaseOperation;
import cascading.operation.Function;
import cascading.operation.FunctionCall;
import cascading.tuple.Fields;
import cascading.tuple.Tuple;
import cascading.tuple.TupleEntry;
import com.ebay.dss.common.FieldNames;
import com.ebay.dss.common.ProdPriceInfoObj;
import com.ebay.hadoop.cascading.util.StringUtil;

/**
 * parse the product price info from TRANSIENT_INDEX_MESSAGE2
 * Author: Johnson CHEN
 * Date: 2014/11/28
 */


public class ProdPriceInfoFunc extends BaseOperation
        implements Function {

    public ProdPriceInfoFunc(Fields newFields) {
        super(ANY, newFields);
    }

    @Override
    public void operate(FlowProcess flowProcess, FunctionCall functionCall) {
        TupleEntry argument = functionCall.getArguments();

        Tuple result = new Tuple();
        TupleEntry resultTupleEntry;
        String[] input;
        ProdPriceInfoObj prodPriceInfoObj = new ProdPriceInfoObj();

        for (int i = 0; i < argument.size(); i++) {
            if (argument.getString(i) != null && !argument.getString(i).equals("")) {
                input = argument.getString(i).split("\\|");
                for (String ss : input) {
                    String[] sss = ss.trim().split("\\s", 3);
                    if (sss.length >= 3)
                    {
                        int id = Integer.parseInt(sss[0]);
                        String afterId = sss[1];
                        String attrValues = sss[2].trim();
                        if (afterId.equals("NUM,ST"))
                        {
                            switch (id)
                            {
                        /*      AVG_BIN_PRICE   */
                                case 16 : prodPriceInfoObj.setAvgBinPrice(attrValues); break;

                        /*      AVG_COMPLETED_PRICE     */
                                case 17 : prodPriceInfoObj.setAvgCompletedPrice(attrValues); break;

                        /*      AVG_SHIPPING_COST       */
                                case 19 : prodPriceInfoObj.setAvgShippingCost(attrValues); break;

                        /*      QUANTITY        */
                                case 20 : prodPriceInfoObj.setQuantity(attrValues); break;

                        /*      AVAILABLE_ITEMS */
                                case 21 : prodPriceInfoObj.setAvailableItems(attrValues); break;

                        /*      SOLD_ITEMS      */
                                case 22 : prodPriceInfoObj.setSoldItems(attrValues); break;

                        /*      AVAILABLE_STORE_ITEMS   */
                                case 44 : prodPriceInfoObj.setAvailableStoreItems(attrValues); break;

                        /*      QUANTITY_NEW_CONDITION  */
                                case 50 : prodPriceInfoObj.setQuantityNewCondition(attrValues); break;

                        /*      QUANTITY_USED_CONDITION */
                                case 51 : prodPriceInfoObj.setQuantityUsedCondition(attrValues); break;

                        /*      MIN_BIN_PRICE_NEW_CONDITION     */
                                case 58 : prodPriceInfoObj.setMinBinPriceNewCondition(attrValues); break;

                        /*      MIN_BIN_PRICE_USED_CONDITION    */
                                case 59 : prodPriceInfoObj.setMinBinPriceUsedCondition(attrValues); break;

                        /*      AVG_BIN_PRICE_NEW_CONDITION     */
                                case 60 : prodPriceInfoObj.setAvgBinPriceNewCondition(attrValues); break;

                        /*      AVG_BIN_PRICE_USED_CONDITION    */
                                case 61 : prodPriceInfoObj.setAvgBinPriceUsedCondition(attrValues); break;

                        /*      AVG_COMPLETED_PRICE_NEW_CONDITION       */
                                case 62 : prodPriceInfoObj.setAvgCompletedPriceNewCondition(attrValues); break;

                        /*      AVG_COMPLETED_PRICE_USED_CONDITION      */
                                case 63 : prodPriceInfoObj.setAvgCompletedPriceUsedCondition(attrValues); break;

                        /*      AVG_SHIPPING_COST_NEW_CONDITION */
                                case 66 : prodPriceInfoObj.setAvgShippingCostNewCondition(attrValues); break;

                        /*      AVG_SHIPPING_COST_USED_CONDITION        */
                                case 67 : prodPriceInfoObj.setAvgShippingCostUsedCondition(attrValues); break;

                        /*      AVG_SOLD_TOTAL_COST     */
                                case 212 : prodPriceInfoObj.setAvgSoldTotalCost(attrValues); break;

                        /*      MOST_POPULAR_LEAF_CAT   */
                                case 215 : prodPriceInfoObj.setMostPopularLeafCat(attrValues); break;

                        /*      TOP_RATED_SELLER_ITEM_COUNT     */
                                case 231 : prodPriceInfoObj.setTopRatedSellerItemCount(attrValues); break;

                        /*      TOP_RATED_SELLER_AVG_COMPLETED_PRICE    */
                                case 232 : prodPriceInfoObj.setTopRatedSellerAvgCompletedPrice(attrValues); break;

                        /*      TOP_RATED_SELLER_AVG_COMPLETED_PRICE_NEW        */
                                case 233 : prodPriceInfoObj.setTopRatedSellerAvgCompletedPriceNew(attrValues); break;

                        /*      TOP_RATED_SELLER_AVG_COMPLETED_PRICE_USED       */
                                case 234 : prodPriceInfoObj.setTopRatedSellerAvgCompletedPriceUsed(attrValues); break;

                        /*      TOP_RATED_SELLER_AVG_SOLD_TOTAL_COST    */
                                case 235 : prodPriceInfoObj.setTopRatedSellerAvgSoldTotalCost(attrValues); break;

                        /*      QUANTITY_REFURBISHED_CONDITION  */
                                case 243 : prodPriceInfoObj.setQuantityRefurbishedCondition(attrValues); break;

                        /*      QUANTITY_LIKE_NEW_CONDITION     */
                                case 244 : prodPriceInfoObj.setQuantityLikeNewCondition(attrValues); break;

                        /*      QUANTITY_VERY_GOOD_CONDITION    */
                                case 245 : prodPriceInfoObj.setQuantityVeryGoodCondition(attrValues); break;

                        /*      QUANTITY_GOOD_CONDITION        */
                                case 246 : prodPriceInfoObj.setQuantityGoodCondition(attrValues); break;

                        /*      QUANTITY_SIG_WEAR_CONDITION     */
                                case 247 : prodPriceInfoObj.setQuantitySigWearCondition(attrValues); break;

                        /*      QUANTITY_DAMAGED_CONDITION      */
                                case 248 : prodPriceInfoObj.setQuantityDamagedCondition(attrValues); break;

                        /*      MIN_BIN_PRICE_REFURBISHED_CONDITION     */
                                case 249 : prodPriceInfoObj.setMinBinPriceRefurbishedCondition(attrValues); break;

                        /*      MIN_BIN_PRICE_LIKE_NEW_CONDITION        */
                                case 250 : prodPriceInfoObj.setMinBinPriceLikeNewCondition(attrValues); break;

                        /*      MIN_BIN_PRICE_VERY_GOOD_CONDITION       */
                                case 251 : prodPriceInfoObj.setMinBinPriceVeryGoodCondition(attrValues); break;

                        /*      MIN_BIN_PRICE_GOOD_CONDITION    */
                                case 252 : prodPriceInfoObj.setMinBinPriceGoodCondition(attrValues); break;

                        /*      MIN_BIN_PRICE_SIG_WEAR_CONDITION        */
                                case 253 : prodPriceInfoObj.setMinBinPriceSigWearCondition(attrValues); break;

                        /*      MIN_BIN_PRICE_DAMAGED_CONDITION */
                                case 254 : prodPriceInfoObj.setMinBinPriceDamagedCondition(attrValues); break;

                        /*      AVG_BIN_PRICE_REFURBISHED_CONDITION     */
                                case 255 : prodPriceInfoObj.setAvgBinPriceRefurbishedCondition(attrValues); break;

                        /*      AVG_BIN_PRICE_LIKE_NEW_CONDITION        */
                                case 256 : prodPriceInfoObj.setAvgBinPriceLikeNewCondition(attrValues); break;

                        /*      AVG_BIN_PRICE_VERY_GOOD_CONDITION       */
                                case 257 : prodPriceInfoObj.setAvgBinPriceVeryGoodCondition(attrValues); break;

                        /*      AVG_BIN_PRICE_GOOD_CONDITION    */
                                case 258 : prodPriceInfoObj.setAvgBinPriceGoodCondition(attrValues); break;

                        /*      AVG_BIN_PRICE_SIG_WEAR_CONDITION        */
                                case 259 : prodPriceInfoObj.setAvgBinPriceSigWearCondition(attrValues); break;

                        /*      AVG_BIN_PRICE_DAMAGED_CONDITION */
                                case 260 : prodPriceInfoObj.setAvgBinPriceDamagedCondition(attrValues); break;

                        /*      AVG_COMPLETED_PRICE_REFURBISHED_CONDITION       */
                                case 261 : prodPriceInfoObj.setAvgCompletedPriceRefurbishedCondition(attrValues); break;

                        /*      AVG_COMPLETED_PRICE_LIKE_NEW_CONDITION  */
                                case 262 : prodPriceInfoObj.setAvgCompletedPriceLikeNewCondition(attrValues); break;

                        /*      AVG_COMPLETED_PRICE_VERY_GOOD_CONDITION */
                                case 263 : prodPriceInfoObj.setAvgCompletedPriceVeryGoodCondition(attrValues); break;

                        /*      AVG_COMPLETED_PRICE_GOOD_CONDITION      */
                                case 264 : prodPriceInfoObj.setAvgCompletedPriceGoodCondition(attrValues); break;

                        /*      AVG_COMPLETED_PRICE_SIG_WEAR_CONDITION  */
                                case 265 : prodPriceInfoObj.setAvgCompletedPriceSigWearCondition(attrValues); break;

                        /*      AVG_COMPLETED_PRICE_DAMAGED_CONDITION   */
                                case 266 : prodPriceInfoObj.setAvgCompletedPriceDamagedCondition(attrValues); break;

                        /*      TOP_RATED_SELLER_AVG_COMPLETED_PRICE_REFURBISHED        */
                                case 267 : prodPriceInfoObj.setTopRatedSellerAvgCompletedPriceRefurbished(attrValues); break;

                        /*      TOP_RATED_SELLER_AVG_COMPLETED_PRICE_LIKE_NEW   */
                                case 268 : prodPriceInfoObj.setTopRatedSellerAvgCompletedPriceLikeNew(attrValues); break;

                        /*      TOP_RATED_SELLER_AVG_COMPLETED_PRICE_VERY_GOOD  */
                                case 269 : prodPriceInfoObj.setTopRatedSellerAvgCompletedPriceVeryGood(attrValues); break;

                        /*      TOP_RATED_SELLER_AVG_COMPLETED_PRICE_GOOD       */
                                case 270 : prodPriceInfoObj.setTopRatedSellerAvgCompletedPriceGood(attrValues); break;

                        /*      TOP_RATED_SELLER_AVG_COMPLETED_PRICE_SIG_WEAR   */
                                case 271 : prodPriceInfoObj.setTopRatedSellerAvgCompletedPriceSigWear(attrValues); break;

                        /*      TOP_RATED_SELLER_AVG_COMPLETED_PRICE_DAMAGED    */
                                case 272 : prodPriceInfoObj.setTopRatedSellerAvgCompletedPriceDamaged(attrValues); break;

                        /*      QUANTITY_BRAND_NEW_CONDITION    */
                                case 273 : prodPriceInfoObj.setQuantityBrandNewCondition(attrValues); break;

                        /*      QUANTITY_NEW_NON_RETAIL_PACKAGING_CONDITION     */
                                case 274 : prodPriceInfoObj.setQuantityNewNonRetailPackagingCondition(attrValues); break;

                        /*      MIN_BIN_PRICE_BRAND_NEW_CONDITION       */
                                case 275 : prodPriceInfoObj.setMinBinPriceBrandNewCondition(attrValues); break;

                        /*      MIN_BIN_PRICE_NEW_NON_RETAIL_PACKAGING_CONDITION        */
                                case 276 : prodPriceInfoObj.setMinBinPriceNewNonRetailPackagingCondition(attrValues); break;

                        /*      AVG_BIN_PRICE_BRAND_NEW_CONDITION       */
                                case 277 : prodPriceInfoObj.setAvgBinPriceBrandNewCondition(attrValues); break;

                        /*      AVG_BIN_PRICE_NEW_NON_RETAIL_PACKAGING_CONDITION        */
                                case 278 : prodPriceInfoObj.setAvgBinPriceNewNonRetailPackagingCondition(attrValues); break;

                        /*      AVG_COMPLETED_PRICE_BRAND_NEW_CONDITION */
                                case 279 : prodPriceInfoObj.setAvgCompletedPriceBrandNewCondition(attrValues); break;

                        /*      AVG_COMPLETED_PRICE_NEW_NON_RETAIL_PACKAGING_CONDITION  */
                                case 280 : prodPriceInfoObj.setAvgCompletedPriceNewNonRetailPackagingCondition(attrValues); break;

                        /*      TOP_RATED_SELLER_AVG_COMPLETED_PRICE_BRAND_NEW  */
                                case 281 : prodPriceInfoObj.setTopRatedSellerAvgCompletedPriceBrandNew(attrValues); break;

                        /*      TOP_RATED_SELLER_AVG_COMPLETED_PRICE_NEW_NON_RETAIL_PACKAGING   */
                                case 282 : prodPriceInfoObj.setTopRatedSellerAvgCompletedPriceNewNonRetailPackaging(attrValues); break;

                        /*      AVG_AUCTION_COMPLETED_PRICE_NEW_CONDITION       */
                                case 286 : prodPriceInfoObj.setAvgAuctionCompletedPriceNewCondition(attrValues); break;

                        /*      AVG_AUCTION_COMPLETED_PRICE_USED_CONDITION      */
                                case 287 : prodPriceInfoObj.setAvgAuctionCompletedPriceUsedCondition(attrValues); break;

                        /*      AVG_BIN_COMPLETED_PRICE_NEW_CONDITION   */
                                case 288 : prodPriceInfoObj.setAvgBinCompletedPriceNewCondition(attrValues); break;

                        /*      AVG_BIN_COMPLETED_PRICE_USED_CONDITION  */
                                case 289 : prodPriceInfoObj.setAvgBinCompletedPriceUsedCondition(attrValues); break;

                        /*      AVG_COMPLETED_PRICE_SELLER_REFURBISHED_CONDITION        */
                                case 290 : prodPriceInfoObj.setAvgCompletedPriceSellerRefurbishedCondition(attrValues); break;

                            }
                        }
                    }
                }
            }
        }

        result.clear();
        result.add(prodPriceInfoObj.getAvgBinPrice());
        result.add(prodPriceInfoObj.getAvgCompletedPrice());
        result.add(prodPriceInfoObj.getAvgShippingCost());
        result.add(prodPriceInfoObj.getQuantity());
        result.add(prodPriceInfoObj.getAvailableItems());
        result.add(prodPriceInfoObj.getSoldItems());
        result.add(prodPriceInfoObj.getAvailableStoreItems());
        result.add(prodPriceInfoObj.getQuantityNewCondition());
        result.add(prodPriceInfoObj.getQuantityUsedCondition());
        result.add(prodPriceInfoObj.getMinBinPriceNewCondition());
        result.add(prodPriceInfoObj.getMinBinPriceUsedCondition());
        result.add(prodPriceInfoObj.getAvgBinPriceNewCondition());
        result.add(prodPriceInfoObj.getAvgBinPriceUsedCondition());
        result.add(prodPriceInfoObj.getAvgCompletedPriceNewCondition());
        result.add(prodPriceInfoObj.getAvgCompletedPriceUsedCondition());
        result.add(prodPriceInfoObj.getAvgShippingCostNewCondition());
        result.add(prodPriceInfoObj.getAvgShippingCostUsedCondition());
        result.add(prodPriceInfoObj.getAvgSoldTotalCost());
        result.add(prodPriceInfoObj.getMostPopularLeafCat());
        result.add(prodPriceInfoObj.getTopRatedSellerItemCount());
        result.add(prodPriceInfoObj.getTopRatedSellerAvgCompletedPrice());
        result.add(prodPriceInfoObj.getTopRatedSellerAvgCompletedPriceNew());
        result.add(prodPriceInfoObj.getTopRatedSellerAvgCompletedPriceUsed());
        result.add(prodPriceInfoObj.getTopRatedSellerAvgSoldTotalCost());
        result.add(prodPriceInfoObj.getQuantityRefurbishedCondition());
        result.add(prodPriceInfoObj.getQuantityLikeNewCondition());
        result.add(prodPriceInfoObj.getQuantityVeryGoodCondition());
        result.add(prodPriceInfoObj.getQuantityGoodCondition());
        result.add(prodPriceInfoObj.getQuantitySigWearCondition());
        result.add(prodPriceInfoObj.getQuantityDamagedCondition());
        result.add(prodPriceInfoObj.getMinBinPriceRefurbishedCondition());
        result.add(prodPriceInfoObj.getMinBinPriceLikeNewCondition());
        result.add(prodPriceInfoObj.getMinBinPriceVeryGoodCondition());
        result.add(prodPriceInfoObj.getMinBinPriceGoodCondition());
        result.add(prodPriceInfoObj.getMinBinPriceSigWearCondition());
        result.add(prodPriceInfoObj.getMinBinPriceDamagedCondition());
        result.add(prodPriceInfoObj.getAvgBinPriceRefurbishedCondition());
        result.add(prodPriceInfoObj.getAvgBinPriceLikeNewCondition());
        result.add(prodPriceInfoObj.getAvgBinPriceVeryGoodCondition());
        result.add(prodPriceInfoObj.getAvgBinPriceGoodCondition());
        result.add(prodPriceInfoObj.getAvgBinPriceSigWearCondition());
        result.add(prodPriceInfoObj.getAvgBinPriceDamagedCondition());
        result.add(prodPriceInfoObj.getAvgCompletedPriceRefurbishedCondition());
        result.add(prodPriceInfoObj.getAvgCompletedPriceLikeNewCondition());
        result.add(prodPriceInfoObj.getAvgCompletedPriceVeryGoodCondition());
        result.add(prodPriceInfoObj.getAvgCompletedPriceGoodCondition());
        result.add(prodPriceInfoObj.getAvgCompletedPriceSigWearCondition());
        result.add(prodPriceInfoObj.getAvgCompletedPriceDamagedCondition());
        result.add(prodPriceInfoObj.getTopRatedSellerAvgCompletedPriceRefurbished());
        result.add(prodPriceInfoObj.getTopRatedSellerAvgCompletedPriceLikeNew());
        result.add(prodPriceInfoObj.getTopRatedSellerAvgCompletedPriceVeryGood());
        result.add(prodPriceInfoObj.getTopRatedSellerAvgCompletedPriceGood());
        result.add(prodPriceInfoObj.getTopRatedSellerAvgCompletedPriceSigWear());
        result.add(prodPriceInfoObj.getTopRatedSellerAvgCompletedPriceDamaged());
        result.add(prodPriceInfoObj.getQuantityBrandNewCondition());
        result.add(prodPriceInfoObj.getQuantityNewNonRetailPackagingCondition());
        result.add(prodPriceInfoObj.getMinBinPriceBrandNewCondition());
        result.add(prodPriceInfoObj.getMinBinPriceNewNonRetailPackagingCondition());
        result.add(prodPriceInfoObj.getAvgBinPriceBrandNewCondition());
        result.add(prodPriceInfoObj.getAvgBinPriceNewNonRetailPackagingCondition());
        result.add(prodPriceInfoObj.getAvgCompletedPriceBrandNewCondition());
        result.add(prodPriceInfoObj.getAvgCompletedPriceNewNonRetailPackagingCondition());
        result.add(prodPriceInfoObj.getTopRatedSellerAvgCompletedPriceBrandNew());
        result.add(prodPriceInfoObj.getTopRatedSellerAvgCompletedPriceNewNonRetailPackaging());
        result.add(prodPriceInfoObj.getAvgAuctionCompletedPriceNewCondition());
        result.add(prodPriceInfoObj.getAvgAuctionCompletedPriceUsedCondition());
        result.add(prodPriceInfoObj.getAvgBinCompletedPriceNewCondition());
        result.add(prodPriceInfoObj.getAvgBinCompletedPriceUsedCondition());
        result.add(prodPriceInfoObj.getAvgCompletedPriceSellerRefurbishedCondition());

        resultTupleEntry = new TupleEntry(StringUtil.fields(FieldNames.PROD_PRICE_INFO), result);
        functionCall.getOutputCollector().add(resultTupleEntry);

    }
}
